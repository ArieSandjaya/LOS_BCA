package com.multifinance.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multifinance.dao.GetDao;
import com.multifinance.mapper.OfficeTypeMapper;
import com.multifinance.mapper.EmployeeListMapper;
import com.multifinance.mapper.OfficeHeadMapper;
import com.multifinance.mapper.OfficeTreeMapper;
import com.multifinance.mapper.OfficeMapper;
import com.multifinance.model.EmployeeModel;
import com.multifinance.model.OfficeModel;
import com.multifinance.model.response.child.OfficeLookupModel;
import com.multifinance.model.response.child.OfficeTreeModel;

@Repository
public class GetDaoImpl implements GetDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<EmployeeModel> getEmployeeByOffice(String offcId) {
		String query = "SELECT empl.empl_id, empl.empl_userlogin, empl.employee_no, "
				+ "empl.full_name, empl.email, empl.phone, empl.work_position, "
				+ "empl.direct_supervisor, empl.employee_type, empl.company_name, "
				+ "empl.active_date, empl.inactive_date, empl.employment_status, "
				+ "empl.department, empl.division, empl.workgroup, empl.location, "
				+ "empl.birth_place, empl.birth_date, empl.address, empl.city, "
				+ "empl.district, empl.village, empl.state, empl.hamlet_number, "
				+ "empl.neighbourhood_number, empl.zipcode "
				+ "FROM multifinance.empl AS empl "
				+ "INNER JOIN multifinance.empl_offc AS empl_offc ON empl.id = empl_offc.empl_id "
				+ "INNER JOIN multifinance.offc AS offc ON empl_offc.offc_id = offc.id "
				+ "WHERE offc.offc_id = ?;";
		List<EmployeeModel> employeeModels = jdbcTemplate.query(query,
				new Object[] { UUID.fromString(offcId)}, new EmployeeListMapper());
		
		return employeeModels;
	}
	
	@Override
	public List<OfficeLookupModel> lookupOfficeHead() {
		String query = "SELECT id, offc_id, name FROM multifinance.offc ORDER BY name ASC ";
		List<OfficeLookupModel> officeLookupModels = jdbcTemplate.query(query,
				new Object[] {}, new OfficeHeadMapper());
		
		return officeLookupModels;
	}

	@Override
	public List<OfficeLookupModel> lookupOfficeType(String compId) {
		String query = "SELECT lookup_key, lookup_value FROM parameters.lookup_detail "
				+ "LEFT JOIN parameters.lookup ON lookup.id = lookup_detail.lookup_head_id "
				+ "WHERE lookup.lookup_name='company.office' AND lookup_detail.comp_id=?";
		List<OfficeLookupModel> officeLookupModels = jdbcTemplate.query(query,
				new Object[] { Integer.valueOf(compId) }, new OfficeTypeMapper());
		
		return officeLookupModels;
	}
	
	@Override
	public OfficeModel getOfficeById(String id) {
		String query = "SELECT offc_head_id, name, office_type, "
				+ "address, city, district, village, state, "
				+ "hamlet_number, neighbourhood_number, zipcode, comp_id FROM multifinance.offc WHERE offc_id = ?;";
		OfficeModel officeModel = jdbcTemplate.queryForObject(query, new Object[] { UUID.fromString(id) },
				new OfficeMapper());

		return officeModel;
	}
	
	@Override
	public int offcIdCheck(String id) {
		String query = "SELECT COUNT (id) FROM multifinance.offc WHERE offc_id = ?; ";
		
		return jdbcTemplate.queryForObject(query, new Object[] { UUID.fromString(id) },
					Integer.class);
	}
	
	@Override
	public List<OfficeTreeModel> lookupOfficeTree() {
		String query = "SELECT id, offc_id, offc_head_id, name, office_type, zipcode FROM multifinance.offc ";
		List<OfficeTreeModel> officeTreeModels = jdbcTemplate.query(query,
				new Object[] {}, new OfficeTreeMapper());
		
		return officeTreeModels;
	}
	
	@Override
	public void closeSession() {
		String query = "SELECT pg_terminate_backend(pid) AS response "
				+ "FROM pg_stat_activity "
				+ "WHERE datname = 'dft_multifinance' "
				+ "AND pid <> pg_backend_pid() "
				+ "AND state in ('idle', 'idle in transaction (aborted)', 'disabled') "
				+ "AND application_name = 'PostgreSQL JDBC Driver' "
				+ "AND state_change < current_timestamp - INTERVAL '30 SECOND';";
		jdbcTemplate.queryForList(query);
	}
}
