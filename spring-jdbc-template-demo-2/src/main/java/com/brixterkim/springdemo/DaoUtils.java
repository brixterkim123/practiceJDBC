package com.brixterkim.springdemo;

import java.util.ArrayList;
import java.util.List;

import com.brixterkim.springdemo.dao.OrganizationDao;
import com.brixterkim.springdemo.domain.Organization;

public class DaoUtils {
	
	public static final String createOperation = "CREATE";
	public static final String readOperation = "READ";
	public static final String updateOperation = "UPDATE";
	public static final String deleteOperation = "DELETE";
	public static final String cleanupOperation = "TRUNCATE";
	
	public static void printOrganizations(List<Organization> orgs, String operation) {
		System.out.println("\n********** printing organizations after "+operation+" operation **********");
		for(Organization org: orgs) {
			System.out.println(org);
		}
	
	}
	
	public static void printOrganization(Organization org, String operation) {
		System.out.println("\n********** printing organization after invoking  "+ operation + "**********\n" + org);
	}
	
	public static void printSuccessFailure(String operation, boolean param) {
		if(param)
			System.out.println("\nOperation "+ operation + " successful");
		else
			System.out.println("\nOperation "+ operation + " failed");
	}
	
	public static void createSeedData(OrganizationDao dao) {
		Organization org1 = new Organization("Amazon", 1994, "65656", "Work hard", 8765);
		Organization org2 = new Organization("BMW", 1924, "45454", "We build ultimate machine", 5501);
		Organization org3 = new Organization("Google", 1996, "57575", "Dont be eveil", 4567);
		
		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(0, org1); 
		orgs.add(1, org2); 
		orgs.add(2, org3); 
		
		int createCount = 0;
		for(Organization org: orgs) {
			boolean isCreated = dao.create(org);
			if(isCreated)
				createCount += 1;
		}
		
		System.out.println("Created "+ createCount+" organizations");
		
		}
	
		public static void printOrganizationCount(List<Organization> orgs, String operation) {
		System.out.println("\n********** Currently we have  "+orgs.size() +" organizations after "+ operation+" operation **********");
	
	}

}
