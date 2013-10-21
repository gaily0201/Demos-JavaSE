package com.zyg.dp.abstractdp;

abstract class Person{
	private String name;
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Person(String name,int age){
		this.setName(name);
		this.setAge(age);
	}
	
	public abstract String getSay();
	public void say(){
		System.out.println(this.getSay());
	}
}

class Worker extends Person{
	private float money;

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	public Worker(String name,int age,float money){
		super(name,age);
		this.setMoney(money);
	}
	
	public String getSay(){
		return "我是一个工人，我的名字是："+super.getName()+",年龄："+super.getAge()+",工资："+this.getMoney();
	}
}

class Student extends Person{
	private float score;

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	public Student(String name,int age,float score){
		super(name,age);
		this.setScore(score);
	}
	
	public String getSay(){
		return "我是一个学生，我的名字是："+super.getName()+",年龄："+super.getAge()+",成绩："+this.getScore();
	}
}
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p=new Worker("zhangsan",12,3000);
		//Person p=new Student("lisi",18,90);
		p.say();

	}

}
