package com.brixterkim.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.brixterkim.springdemo.domain.Organization;

public interface OrganizationDao {
	
	//Set data source that will be required to create a connection to the database
	public void setDataSource(DataSource ds);
	
	//Create a record in the organization table
	public boolean create(Organization org);
	
	//Retrieve a single Organization
	public Organization getOrganization(Integer id);
	
	//Retrieve all organizations in the database
	public List<Organization> getAllOrganizations();

	//Delete a specific organization from the table
	public boolean delete(Organization org);
	
	//Update organization in table
	public boolean update(Organization org);
	
	public void cleanup();
}
