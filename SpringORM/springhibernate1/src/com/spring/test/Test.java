package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/spring/resources/applicationContext.xml");
		EmployeeDao empDao = (EmployeeDao) context.getBean("empDao");
		
		/*
		 * Employee emp = new Employee(); emp.setEno(444); emp.setEname("Sid");
		 * emp.setEsal(50000); emp.setEaddr("BLR");
		 * 
		 * String status = empDao.insert(emp); System.out.println(status);
		 */
		 

			/*
			 * Employee emp = empDao.search(111); if (emp == null) {
			 * System.out.println("Employee Not Existed"); } else {
			 * System.out.println("Employee Details");
			 * System.out.println("-----------------");
			 * System.out.println("Employee Number :" + emp.getEno());
			 * System.out.println("Employee Name :" + emp.getEname());
			 * System.out.println("Employee Salary :" + emp.getEsal());
			 * System.out.println("Employee Address :" + emp.getEaddr()); }
			 */
			/*
			 * Employee emp = new Employee(); emp.setEno(444); emp.setEname("Sid");
			 * emp.setEsal(50000); emp.setEaddr("BLR");
			 * 
			 * //String status = empDao.update(emp); //System.out.println(status);
			 */		  
		  Employee emp = new Employee(); 
		  emp.setEno(444); 
		  emp.setEname("Sid");
		  emp.setEsal(50000);
		  emp.setEaddr("BLR");
		  
		  String status = empDao.delete(emp); 
		  System.out.println(status);
	}
}
