package com.multifinance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.multifinance.model.EmployeeModel;

public class EmployeeListMapper implements RowMapper<EmployeeModel> {

	@Override
	public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setEmployeeId(rs.getString("empl_id"));
		employeeModel.setEmployeeUserLogin(rs.getString("empl_userlogin"));
		employeeModel.setEmployeeNo(rs.getString("employee_no"));
		employeeModel.setFullName(rs.getString("full_name"));
		employeeModel.setEmail(rs.getString("email"));
		employeeModel.setPhone(rs.getString("phone"));
		employeeModel.setWorkPosition(rs.getString("work_position"));
		employeeModel.setDirectSupervisor(rs.getInt("direct_supervisor"));
		employeeModel.setEmployeeType(rs.getString("employee_type"));
		employeeModel.setCompanyName(rs.getString("company_name"));
		employeeModel.setActiveDate(rs.getDate("active_date"));
		employeeModel.setInactiveDate(rs.getDate("inactive_date"));
		employeeModel.setEmploymentStatus(rs.getString("employment_status"));
		employeeModel.setDepartment(rs.getString("department"));
		employeeModel.setDivision(rs.getString("division"));
		employeeModel.setWorkgroup(rs.getString("workgroup"));
		employeeModel.setLocation(rs.getString("location"));
		employeeModel.setBirthPlace(rs.getString("birth_place"));
		employeeModel.setBirthDate(rs.getDate("birth_date"));
		employeeModel.setAddress(rs.getString("address"));
		employeeModel.setCity(rs.getString("city"));
		employeeModel.setDistrict(rs.getString("district"));
		employeeModel.setVillage(rs.getString("village"));
		employeeModel.setState(rs.getString("state"));
		employeeModel.setHamletNumber(rs.getString("hamlet_number"));
		employeeModel.setNeighbourhoodNumber(rs.getString("neighbourhood_number"));
		employeeModel.setZipcode(rs.getString("zipcode"));
		
		return employeeModel;
	}
}
