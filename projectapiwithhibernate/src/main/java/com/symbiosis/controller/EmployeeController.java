package com.symbiosis.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.symbiosis.model.Employee;

public class EmployeeController {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP");

		EntityManager em = emf.createEntityManager();
		
		  em.getTransaction().begin();
		  
		  Employee e = new Employee(); 
		  		e.setName("ajay");
		  		e.setSalary(50000);
		  
		  Employee e1 = new Employee(); 
		  		e1.setName("vijay");
		  		e1.setSalary(50000);
		  
				 em.persist(e);
				 em.persist(e1);
				 
				 
		  em.getTransaction().commit();
		  
		  System.out.println("Data Is Stored Successfully ");
		 

		Employee e2 = em.find(Employee.class, 1);
		System.out.println(e2);
		
		System.out.println("\n");
		/*
		 * em.getTransaction().begin(); Employee e3 = em.find(Employee.class, 1);
		 * em.remove(e3); em.getTransaction().commit();
		 * 
		 */
		
		em.getTransaction().begin();
		
		  Employee e4 = em.find(Employee.class, 1);
		  		e4.setName("Rajveer");
		  		em.persist(e4);
		  		
		  em.getTransaction().commit();
		  
		  
		System.out.println("Updated successfully");
		
		System.out.println("Display Data ");
		Employee e5 = em.find(Employee.class, 1);
		System.out.println(e);
		
	}

}
