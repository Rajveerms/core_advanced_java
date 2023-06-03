package com.symbiosis.projectapiwithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP");
    	EntityManager em = emf.createEntityManager(); 
    	
    	Actor a = new Actor(101,"SRK","Pathan");
    	Actor a1 = new Actor(102,"YASH","KGF");
    	
    	em.getTransaction().begin();
    	em.persist(a);
    	em.persist(a1);
    	em.getTransaction().commit();
    	System.out.println("Saved Data Successfully ...! ");
    	
    }
}
