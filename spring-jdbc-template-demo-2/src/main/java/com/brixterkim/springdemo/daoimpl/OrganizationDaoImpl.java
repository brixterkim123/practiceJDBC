package com.brixterkim.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brixterkim.springdemo.dao.OrganizationDao;
import com.brixterkim.springdemo.domain.Organization;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(datasource);

	}

	public boolean create(Organization org) {
		
		String sqlQuery = "INSERT INTO organization (company_name, yr_of_incorporation, postal_code, slogan, employee_count)"+
		"VALUES(?, ?, ? ,? ,?)";
		
		Object[] args = new Object[] {org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(),
				org.getSlogan(), org.getEmployeeCount()};
		
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public Organization getOrganization(Integer id) {
		
		String sqlQuery = "SELECT id, company_name, yr_of_incorporation, postal_code, slogan, employee_count "+
						"FROM organization WHERE id = ?";
		Object[] args = new Object[] {id};
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		
		
		return org;
	}

	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		String sqlQuery = "DELETE FROM organization WHERE id = ?";
		Object[] args = new Object[] {org.getId()};
		
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public boolean update(Organization org) {
		String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
		Object[] args = new Object[] {org.getSlogan(), org.getId()};
		
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization";
		jdbcTemplate.execute(sqlQuery);

	}

}
