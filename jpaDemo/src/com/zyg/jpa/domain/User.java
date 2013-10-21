package com.zyg.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;

@Entity
@Table(name="user")
//@GenericGenerator(name="uuidpk",strategy="uuid")
public class User {
	@Id
	@GeneratedValue()
	//@GeneratedValue(generator="uuid")
	private int id;
	//@Index(name="name_index")
	//@Column(nullable=true,name="user_name",unique=true)
	private String name;
	private Date birthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
