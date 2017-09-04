package com.xpagesbeast.managedbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.ibm.xsp.complex.Parameter;
import com.ibm.xsp.component.xp.XspEventHandler;
import com.xpagesbeast.common.CommonUtil;
import com.xpagesbeast.data.DataService;
import com.xpagesbeast.ui.CustomerItem;
import com.xpagesbeast.ui.OrderItem;

public class PageBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String label;
	private UIComponent button2;
	
	private List<CustomerItem> customerItems = null;
	private List<OrderItem> orderItems = null;
	private CustomerItem currentCustomerItem = null;
	private OrderItem currentOrderItem = null;
	
	private int currentCustomerItemRow = -1;
	
	private DataService service = null;
	
	public PageBean(){
		setLabel("I am a xp:label set by a backing bean property.");
		customerItems = DataService.getInstance().getCustomerItems();
		orderItems = DataService.getInstance().getOrderItems();
		
		currentCustomerItem = new CustomerItem();
		currentOrderItem = new OrderItem();
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public void resetData(){
		DataService.getInstance().resetData();
	}
	
	public int getOrderCount(){
		return orderItems.size();
	}
	
	public int getCustomerCount(){
		return customerItems.size();
	}
	
	public void createCustomer(){
		customerItems.add(currentCustomerItem);
	}
	
	public String doTask(){
		System.out.println("pageBean.doTask()"); 
		FacesContext context = FacesContext.getCurrentInstance();
		FacesContext.getCurrentInstance().addMessage("messages1",new FacesMessage("doTask() executed, and set a JSF message in Java to be surfaced in User Interface."));
		setLabel(this.getTime());
		return "listen.xsp";
	}
	
	public void listen(ActionEvent ae){
		System.out.println("pageBean.listen()" + ae.getComponent().getId());
		return;
	}

	public String getLabel() {
		return label;
	}

	public UIComponent getButton2() {
		return button2;
	}

	public void setButton2(UIComponent button2) {
		this.button2 = button2;
	}
	
	public String getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = new Date();
		return sdf.format(date);
	}

	public void loadOrders(int rowIndex, String opCode) {
		String btnName = "          " + this.getClass().getSimpleName() + ".loadOrders() ";
		System.out.println(btnName + " started.");
		if(opCode.equals("edit")){
			currentOrderItem = orderItems.get(rowIndex);
		}else{
			currentOrderItem = new OrderItem();
		}
		System.out.println(btnName + " completed.");
		
	}

	public void loadCurrentCustomer(int rowIndex, String opCode) {
		String btnName = "          " + this.getClass().getSimpleName() + ".loadCustomer("+rowIndex + "," + opCode + ") ";
		System.out.println(btnName + " started.");
		if(opCode.equals("edit")){
			if(rowIndex > -1){
				currentCustomerItem = customerItems.get(rowIndex);
			}
		}else{
			currentCustomerItem = new CustomerItem();
		}
		System.out.println(btnName + " completed.");
		
	}
	
	public void resetCurrentCustomer(){
		currentCustomerItem = new CustomerItem();
	}

	public DataService getService() {
		return service;
	}

	public void setService(DataService service) {
		this.service = service;
	}

	public List<CustomerItem> getCustomerItems() {
		return customerItems;
	}

	public void setCustomerItems(List<CustomerItem> customerItems) {
		this.customerItems = customerItems;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public CustomerItem getCurrentCustomerItem() {
		return currentCustomerItem;
	}

	public void setCurrentCustomerItem(CustomerItem currentCustomerItem) {
		this.currentCustomerItem = currentCustomerItem;
	}

	public OrderItem getCurrentOrderItem() {
		return currentOrderItem;
	}

	public void setCurrentOrderItem(OrderItem currentOrderItem) {
		this.currentOrderItem = currentOrderItem;
	}

	public void saveCurrentCustomer() {
		if(currentCustomerItem.getNumber()==0){
			//this is a new item.
			currentCustomerItem.setNumber(customerItems.size()+1);
			customerItems.add(currentCustomerItem);
		}else{
			//we are editing.  this is bound to the dialog directly.  no need to do anything else.
		}
	}

	public void deleteCustomer(int rowIndex) {
		customerItems.remove(rowIndex);		
	}
	
	public void deleteCustomer() {
		customerItems.remove(this.getCurrentCustomerItemRow());		
	}
	
	public void deleteOrder(int rowIndex) {
		orderItems.remove(rowIndex);		
	}
	
	public void deleteCustomerItem(ActionEvent event){
		String btnName = "          " + this.getClass().getSimpleName() + ".deleteCustomerItem() ";
		System.out.println(btnName + " started.");
		XspEventHandler eventHandler = (XspEventHandler) event.getSource();
		List<Parameter> params = eventHandler.getParameters();
		System.out.println(btnName + "checking event params");
		int rowIndex = -1;
		String opCode = "";
		
		if(params != null){
			for (Parameter p : params) {
				System.out.println(btnName + p.getName() + "," + p.getValue());
				
				
				if(p.getName().equals("rowIndex")){
					rowIndex = Integer.parseInt(p.getValue());
				}else if(p.getName().equals("opCode")){
					opCode = p.getValue();
				}
			}
			if(rowIndex > -1){
				deleteCustomer(rowIndex);
			}
		}else{
			System.out.println(btnName + "params is null.");
		}
				
		System.out.println(btnName + " completed.");
	}

	public int getCurrentCustomerItemRow() {
		return currentCustomerItemRow;
	}

	public void setCurrentCustomerItemRow(int currentCustomerItemRow) {
		this.currentCustomerItemRow = currentCustomerItemRow;
	}


}
