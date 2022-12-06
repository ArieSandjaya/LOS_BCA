package com.multifinance.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multifinance.dao.PostDao;
import com.multifinance.mapper.OfficeListMapper;
import com.multifinance.model.OfficeModel;
import com.multifinance.util.CommonUtil;



@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String entryOffice(OfficeModel officeModel) {
		String query = "INSERT INTO multifinance.offc("
				+ "offc_id, offc_head_id, name, office_type, "
				+ "address, city, district, village, state, "
				+ "hamlet_number, neighbourhood_number, zipcode, comp_id, created_at, "
				+ "created_by, updated_at, updated_by, deleted_at, deleted_by) "
				+ "VALUES (uuid_generate_v4(), ?, ?, ?, "
				+ "?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, now(), "
				+ "?, now(), ?, null, null) RETURNING offc_id;";

		return jdbcTemplate.queryForObject(query,
				new Object[] { Integer.valueOf(officeModel.getOfficeHeadId()), CommonUtil.toTitleCase(officeModel.getName()), officeModel.getOfficeType(),
						CommonUtil.toTitleCase(officeModel.getAddress()), CommonUtil.toTitleCase(officeModel.getCity()),
						CommonUtil.toTitleCase(officeModel.getDistrict()), CommonUtil.toTitleCase(officeModel.getVillage()),
						CommonUtil.toTitleCase(officeModel.getState()), officeModel.getHamletNumber(), 
						officeModel.getNeighbourhoodNumber(), officeModel.getZipcode(),
						officeModel.getCompId(), officeModel.getUpdateBy(), officeModel.getUpdateBy() },
				String.class);

	}
	
	@Override
	public List<OfficeModel> getOfficeAll(){
		String query = "SELECT offc_id, offc_head_id, name, office_type, "
				+ "parent_id, address, city, district, village, state, "
				+ "hamlet_number, neighbourhood_number, zipcode, comp_id " 
				+ "FROM multifinance.offc ORDER BY name ASC ;";
		List<OfficeModel> listOfficeModel = jdbcTemplate.query(query,new Object[] { }, new OfficeListMapper());
		return listOfficeModel;	
	}
	
	@Override
	public int offcNameCheck(String name) {
		String query = "SELECT COUNT(id) FROM multifinance.offc WHERE UPPER(name)=UPPER(?);";
		return jdbcTemplate.queryForObject(query, new Object[] { name }, Integer.class);
	}
}
