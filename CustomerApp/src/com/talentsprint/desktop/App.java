package com.talentsprint.desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.talentsprint.businesstier.manager.CustomerManager;

//@Component
public class App {
	//@Autowired
	private static CustomerManager manager;

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		
		
		manager = (CustomerManager)context.getBean("customerManager");
		String message=manager.deleteCustomer(4);
		System.out.println(message);
	}

}
