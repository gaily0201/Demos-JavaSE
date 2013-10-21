package com.zyg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf;
	
	static{
		emf = Persistence.createEntityManagerFactory("jpaDemo");
	}
	
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}
