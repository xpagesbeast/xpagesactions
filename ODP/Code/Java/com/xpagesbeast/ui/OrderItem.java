package com.xpagesbeast.ui;

import java.io.Serializable;

import com.xpagesbeast.grids.GridItem;
import com.xpagesbeast.model.Customer;
import com.xpagesbeast.model.Order;

public class OrderItem extends GridItem<Order> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*These fields map to the UI Components.*/
	private String description;
	private int number;
	private int customerId;
	
	public Order getItem() {
		return super.getItem();
	}
	
	public void setItem(Order order) {
		super.setItem(order);
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String name) {
		this.description = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	/*Interface ManagedItem*/
	@Override
	public void copyFrontEndToBackEnd(){
		if(super.getItem() == null){
			super.setItem(new Order());
		}
		super.getItem().setDescription(this.getDescription());
		super.getItem().setNumber(this.getNumber());
		super.getItem().setCustomerId(this.getCustomerId());
	}
	
	/*Interface ManagedItem*/
	@Override
	public void copyBackEndToFrontEnd(){
		if(super.getItem() != null){
			setDescription(super.getItem().getDescription());
			setNumber(super.getItem().getNumber());
			setCustomerId(super.getItem().getCustomerId());
		}
	}

}
