package com.brixterkim.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.brixterkim.springdemo.dao.OrganizationDao;
import com.brixterkim.springdemo.daoimpl.OrganizationDaoImpl;
import com.brixterkim.springdemo.domain.Organization;

public class JdbcTemplateClassicApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating the application context
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//Create Bean
		OrganizationDao dao = (OrganizationDaoImpl) context.getBean("orgDao");
		
		//creating seed data
		DaoUtils.createSeedData(dao);
		
		//List organizations
		List<Organization> orgs = dao.getAllOrganizations();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);
		
		//Create new organizations
		Organization org = new Organization("General Electric", 1978, "98989", "Imagination at work",5576);
		boolean isCreated = dao.create(org);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.readOperation);
		
		//get a single organization
		Organization org2 = dao.getOrganization(1);
		DaoUtils.printOrganization(org2, "getOrganization");
		
		//Update an organization
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build *+ awesome+* driving machines");
		boolean isUpdated = dao.update(org3);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(dao.getOrganization(2), DaoUtils.updateOperation);
		
		//Delete an organization
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.deleteOperation);
		
		//clean up
		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.cleanupOperation);
		
		//close application
		((ClassPathXmlApplicationContext) context).close();
	}

}


//List<Organization> orgs =dao.getAllOrganizations();
//for(Organization org: orgs) {
//	System.out.println(org);
//}