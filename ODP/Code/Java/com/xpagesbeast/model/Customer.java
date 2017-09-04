package com.xpagesbeast.model;

import java.io.Serializable;

/*Simple Plain Java Object POJO
 * This is what is retrieved from JDBC Call or Notes Document or both merged into one single object.
 * 
 * */

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int number;
	
	public Customer(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
