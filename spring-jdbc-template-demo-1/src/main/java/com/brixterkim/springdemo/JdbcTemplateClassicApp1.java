package com.brixterkim.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.brixterkim.springdemo.dao.OrganizationDao;
import com.brixterkim.springdemo.daoimpl.OrganizationDaoImpl;
import com.brixterkim.springdemo.domain.Organization;

public class JdbcTemplateClassicApp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating the application context
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//Create Bean
		OrganizationDao dao = (OrganizationDaoImpl) context.getBean("orgDao");
		List<Organization> orgs =dao.getAllOrganizations();
		for(Organization org: orgs) {
			System.out.println(org);
		}
		
		//close application
		
		((ClassPathXmlApplicationContext) context).close();
	}

}
