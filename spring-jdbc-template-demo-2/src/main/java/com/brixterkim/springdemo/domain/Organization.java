package com.brixterkim.springdemo.domain;

public class Organization {

	private int id;
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private String slogan;
	private int employeeCount;
	
	public Organization() {
		
	}
	
	public Organization(String companyName, int yearOfIncorporation, String postalCode, String slogan,
			int employeeCount) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		this.postalCode = postalCode;
		this.slogan = slogan;
		this.employeeCount = employeeCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getYearOfIncorporation() {
		return yearOfIncorporation;
	}
	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	

	@Override
	public String toString() {
		return "Organization [id=" + id + ", companyName=" + companyName + ", yearOfIncorporation="
				+ yearOfIncorporation + ", postalCode=" + postalCode + ", slogan=" + slogan + ", employeeCount="
				+ employeeCount + "]";
	}
	
}
