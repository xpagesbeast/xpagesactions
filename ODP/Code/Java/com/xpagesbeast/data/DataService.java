package com.xpagesbeast.data;


import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import com.xpagesbeast.common.CommonUtil;
import com.xpagesbeast.managedbeans.ConstantsBean;
import com.xpagesbeast.model.Customer;
import com.xpagesbeast.model.Order;
import com.xpagesbeast.ui.CustomerItem;
import com.xpagesbeast.ui.OrderItem;

public class DataService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Customer> customers = null;
	private List<Order> orders = null;
	private static DataService instance = null;
	
	public static DataService getInstance() {
		String btnName = "          DataService.getInstance() ";
		CommonUtil.printDebug(btnName + " started.",ConstantsBean.DEBUG_DATASERVICE);
		if(instance == null){
			CommonUtil.printDebug(btnName + " creating a new instance",ConstantsBean.DEBUG_DATASERVICE);
			instance = new DataService();
		}else{
			CommonUtil.printDebug(btnName + " use existing Singleton",ConstantsBean.DEBUG_DATASERVICE);
		}
		CommonUtil.printDebug(btnName + " returning",ConstantsBean.DEBUG_DATASERVICE);
		return instance;
	}
	
	public DataService(){
		String btnName = "          DataService.constructor() ";
		CommonUtil.printDebug(btnName + " started.",ConstantsBean.DEBUG_DATASERVICE);
		createCustomers();
		createOrders();
		CommonUtil.printDebug(btnName + " returning.",ConstantsBean.DEBUG_DATASERVICE);
	}
	
	public int getOrderCount(){
		if(orders == null){
			return 0;
		}
		return orders.size();
	}
	
	public int getCustomerCount(){
		if(customers == null){
			return 0;
		}
		return customers.size();
	}
	
	public void resetData(){
		createCustomers();
		createOrders();
	}
	
	private void createCustomers(){
		String btnName = "          DataService.createCustomers() ";
		CommonUtil.printDebug(btnName + " started.",ConstantsBean.DEBUG_DATASERVICE);
		customers = new ArrayList<Customer>();
		
		//read a database NoSQL or SQL or REST Service
		
		Customer customer = new Customer();
		customer.setName("Walgreens");
		customer.setNumber(1);
		customers.add(customer);
		customer = new Customer();
		customer.setName("State Farm");
		customer.setNumber(2);
		customers.add(customer);
		customer = new Customer();
		customer.setName("Aon Corporation");
		customer.setNumber(3);
		customers.add(customer);
		customer = new Customer();
		customer.setName("Federal Reserve Bank of Chicago");
		customer.setNumber(4);
		customers.add(customer);
		CommonUtil.printDebug(btnName + " returning.",ConstantsBean.DEBUG_DATASERVICE);
	}
	
	private void createOrders(){
		String btnName = "          DataService.createOrders() ";
		CommonUtil.printDebug(btnName + " started.",ConstantsBean.DEBUG_DATASERVICE);
		orders = new ArrayList<Order>();
		int customerNumber;
		int orderNumber;
		//read a database NoSQL or SQL or REST Service
		
		//Customer 1 Orders
		customerNumber = 1;
		orderNumber = 100;
		
		Order order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Star Wars BB8");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Star Wars R2D2");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Star Wars Chewbacca");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Star Wars Han Solo");
		orders.add(order);
		
		//Customer 2 Orders
		customerNumber = 2;
		orderNumber = 220;

		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Computer Raspberry Pi");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Microcontroller Arduino");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Amazon Alexa");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Nest Thermostat");
		orders.add(order);
		
		//Customer 3 Orders
		customerNumber = 3;
		orderNumber = 340;
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Car Toyota Prius");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Car Tesla Model 3");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Car Tesla Model S");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Car Nissan Leaf");
		orders.add(order);
		
		//Customer 4 Orders
		customerNumber = 4;
		orderNumber = 450;
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Figures Superman");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Figures Batman");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Figures Wonder Woman");
		orders.add(order);
		
		order = new Order();
		order.setCustomerId(customerNumber);
		order.setNumber(orderNumber++);
		order.setDescription("Figures Flash");
		orders.add(order);
		CommonUtil.printDebug(btnName + " returning.",ConstantsBean.DEBUG_DATASERVICE);
	}

	private List<Customer> getCustomers() {
		return customers;
	}

	private void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	private List<Order> getOrders() {
		return orders;
	}

	private void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<CustomerItem> getCustomerItems(){
		ArrayList<CustomerItem> customerItems = new ArrayList<CustomerItem>();
		
		if(customers == null){
			createCustomers();
		}
		
		for(Customer customer : customers){
			CustomerItem item = new CustomerItem();
			item.setCustomer(customer);
			item.copyBackEndToFrontEnd();
			customerItems.add(item);
		}
				
		return customerItems;
	}
	
	public ArrayList<OrderItem> getOrderItems(){
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		if(orders == null){
			createOrders();
		}
		
		for(Order order : orders){
			OrderItem item = new OrderItem();
			item.setItem(order);
			item.copyBackEndToFrontEnd();
			orderItems.add(item);
		}
				
		return orderItems;
	}

	public int getOrderCountByCustomerId(int id) {
		int number = 0;
		for(Order order : orders){
			if(order.getCustomerId() == id){
				number++;
			}
		}
		return number;
	}

		
	
}
