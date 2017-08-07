package com.mp.spring.model;

public class Customer {

	private int c_id;

	private String c_email;

	private String c_password;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_email=" + c_email + ", c_password=" + c_password + "]";
	}

}
