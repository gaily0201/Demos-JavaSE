package com.zyg.jpa;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.zyg.jpa.domain.Department;
import com.zyg.jpa.domain.Employee;
import com.zyg.jpa.domain.MyUser;
import com.zyg.jpa.domain.Sales;
import com.zyg.jpa.domain.Skiller;
import com.zyg.jpa.domain.User;

public class BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName("changGong2");
		user.setBirthday(new Date());
		addUser(user);
		
		//getUserList();
		
		/*MyUser myUser = new MyUser();
		myUser.setName("changongniu");
		myUser.setBirthday(new Date());
		//单个表的更新
		addUser(myUser);*/
		
		//关联和继承更新
		//addDepart();
		
		//简单查询
		queryById(user.getId());
	}
	
	static void addUser(User user){
		EntityManager em = null;
		EntityTransaction tx = null;
		try{
			em = JpaUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(user);
			tx.commit();
		}finally{
			if(em!=null){
				em.close();
			}
		}
	}
	
	static void addDepart(){
		EntityManager em = null;
		EntityTransaction tx = null;
		try{
			em = JpaUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Department depart = new Department();
			depart.setName("SoftWare");
			
			Employee emp1 = new Employee();
			emp1.setDepart(depart);
			emp1.setName("ZhangSan");
			
			Skiller emp2 = new Skiller();
			emp2.setDepart(depart);
			emp2.setName("Changong");
			emp2.setSkill("programmer");
			
			Sales emp3 = new Sales();
			emp3.setDepart(depart);
			emp3.setName("Bowman");
			emp3.setSell(120);
			
			Set<Employee> emps = new HashSet<Employee>();
			emps.add(emp2);
			emps.add(emp1);
			emps.add(emp3);
			depart.setEmps(emps);
			em.persist(depart);
			tx.commit();
		}finally{
			if(em!=null){
				em.close();
			}
		}
	}
	
	static void addUser(MyUser user){
		EntityManager em = null;
		EntityTransaction tx = null;
		try{
			em = JpaUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(user);
			tx.commit();
		}finally{
			if(em!=null){
				em.close();
			}
		}
	}
	
	static User queryById(int id){
		EntityManager em = null;
		em = JpaUtil.getEntityManager();
		String jpaSql = "select user from User user";
		Query q = em.createQuery(jpaSql);
		//User user = q.getSingleResult(id,p);
		
		User user = (User)q.getSingleResult();
		
		//User user = em.find(User.class, id);
		System.out.println(user.getName()+" @@@@@@@@@@");
		em.close();
		return user;
	}
	
	static void getUserList(){
		EntityManager em = null;
		EntityTransaction tx = null;
		try{
			String sql = "select u from user u";
			em = JpaUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			List list = em.createQuery(sql).getResultList();
			
			System.out.println(list.size() + " !!!!!!!!");
			tx.commit();
		}finally{
			if(em!=null){
				em.close();
			}
		}
	}
}
