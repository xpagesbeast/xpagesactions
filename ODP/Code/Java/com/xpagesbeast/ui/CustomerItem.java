package com.xpagesbeast.ui;

import java.io.Serializable;

import com.xpagesbeast.data.DataService;
import com.xpagesbeast.grids.GridItem;
import com.xpagesbeast.model.Customer;

/*
 * This is a JavaBean that represents a model object and some actions on it.
 * The actual model object is wrapped with this class so it can be managed in a collection.
 * */

public class CustomerItem extends GridItem<Customer> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*These fields map to the UI Components.*/
	private String name;
	private int number = 0;
	
	public Customer getCustomer() {
		return super.getItem();
	}
	
	public void setCustomer(Customer customer) {
		super.setItem(customer);
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
	
	/*Interface ManagedItem*/
	@Override
	public void copyFrontEndToBackEnd(){
		if(super.getItem() == null){
			super.setItem(new Customer());
		}
		super.getItem().setName(this.getName());
		super.getItem().setNumber(this.getNumber());
	}
	
	/*Interface ManagedItem*/
	@Override
	public void copyBackEndToFrontEnd(){
		if(super.getItem() != null){
			setName(super.getItem().getName());
			setNumber(super.getItem().getNumber());
		}
	}
	
	public double getNumOrdersByCustomer(){
		int number = 0;
		number = DataService.getInstance().getOrderCountByCustomerId(this.getNumber());
		return number;
	}
	
}
