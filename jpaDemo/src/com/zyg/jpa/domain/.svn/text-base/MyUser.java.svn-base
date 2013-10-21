package com.zyg.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity(name="u user")
@Entity(name="user")
//@Table(name="user")
public class MyUser {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	///@GeneratedValue()
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="birthday")
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
