package com.mp.spring.model;

public class User {

	private int id;

	private String firstName;

	private int age;

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", age=" + age + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
