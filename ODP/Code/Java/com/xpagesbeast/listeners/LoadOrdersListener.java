package com.xpagesbeast.listeners;

import java.util.List;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import com.ibm.xsp.complex.Parameter;
import com.ibm.xsp.component.xp.XspEventHandler;
import com.xpagesbeast.common.CommonUtil;
import com.xpagesbeast.managedbeans.ConstantsBean;
import com.xpagesbeast.managedbeans.PageBean;

public class LoadOrdersListener implements ActionListener{

	public void processAction(ActionEvent event) throws AbortProcessingException {
		String btnName = "          " + this.getClass().getSimpleName() + ".processAction() ";
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
		}else{
			System.out.println(btnName + "params is null.");
		}
		/*
		if(null==CommonUtil.getInstance().getBean(ConstantsBean.CONTRACT_BEAN))
		{
			CommonUtil.getInstance().initializeBean(ConstantsBean.CONTRACT_BEAN, new ContractBean());
		}
		*/
		if(null!=CommonUtil.getInstance().getBeanFromViewScope(ConstantsBean.ORDERS_BEAN)){
			System.out.println(btnName + " bean found.");
			((PageBean)CommonUtil.getInstance().getBeanFromViewScope(ConstantsBean.ORDERS_BEAN)).loadOrders(rowIndex,opCode);
		}
		
		System.out.println(btnName + " completed.");		
				
	}

}
