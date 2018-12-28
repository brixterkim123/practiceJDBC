package com.brixterkim.springdemo.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brixterkim.springdemo.domain.Organization;

public class OrganizationRowMapper implements RowMapper<Organization> {

	public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Organization org = new Organization();
		org.setId(rs.getInt("id"));
		org.setCompanyName(rs.getString("company_name"));
		org.setYearOfIncorporation(rs.getInt("yr_of_incorporation"));
		org.setPostalCode(rs.getString("postal_code"));
		org.setEmployeeCount(rs.getInt("employee_count"));
		org.setSlogan(rs.getString("slogan"));
		
		return org;
	}

}
