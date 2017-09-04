package com.xpagesbeast.managedbeans;

import java.io.Serializable;

public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = "Steve Lohja";
	
	public UserBean(){
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
