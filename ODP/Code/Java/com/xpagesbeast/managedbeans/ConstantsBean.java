package com.xpagesbeast.managedbeans;

import java.io.Serializable;

public class ConstantsBean implements Serializable{
	
	public static final String JSF_SESION_NAME = "session";
	
	public static final String NOTFOUND = "##NOT FOUND##";
	
	
	public static final boolean DEBUG_PAGEBEAN = false;
	public static final boolean DEBUG = false;
	public static final boolean DEBUG_ADMIN = false;
	
	// keys used typically inside grids with action listeners to set the Intent.
	public static final String OPCODE_NEW = "NEW";
	public static final String OPCODE_CLONE = "CLONE";
	public static final String OPCODE_EDIT = "EDIT";
	public static final String OPCODE_DELETE = "DELETE";
	
	// Used to get the Bean from Faces Context
	public static final String USER_PROFILE_BEAN = "userProfileBean";
	public static final String USER_BEAN = "userBean";
	public static final String VALIDATORS_BEAN = "validators";
	public static final String CUSTOMER_BEAN = "pageBean";
	public static final String ORDERS_BEAN = "pageBean";

	public static final boolean DEBUG_DATASERVICE = false;
	
	public ConstantsBean(){
		
	}

}
