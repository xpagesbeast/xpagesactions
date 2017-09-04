package com.xpagesbeast.common;

import static com.ibm.xsp.extlib.util.ExtLibUtil.resolveVariable;

import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import lotus.domino.Session;

import com.xpagesbeast.managedbeans.ConstantsBean;

public class CommonUtil {

	private static CommonUtil commonUtil;

	public static CommonUtil getInstance() {
		if (null == commonUtil) {
			commonUtil = new CommonUtil();
		}
		return commonUtil;
	}

	public static Session getCurrentXPSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		Session session = (Session) context.getApplication().getVariableResolver().resolveVariable(context,
				ConstantsBean.JSF_SESION_NAME);
		return session;
	}

	public Object getBean(String beanName) {
		Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		return sessionMap.get(beanName);
	}
	
	public Object getBeanFromViewScope(String beanName) {
		Map viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();
		return viewMap.get(beanName);
	}

	public void initializeBean(String beanName, Object obj) {
		Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put(beanName, obj);
	}
	
	public void initializeBeanViewScope(String beanName, Object obj) {
		Map viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();
		viewMap.put(beanName, obj);
		System.out.println("CommonUtil.getBean() " + viewMap);
	}

	public static void printDebug(String message, boolean debugMode){
		if(debugMode){
			System.out.println(message);
		}
	}
	
    public Object getGlobalObject(String obj) throws Exception {
		return resolveVariable(FacesContext.getCurrentInstance(), obj);
	}
    
	public String getLangString(String bundle, String key) throws Exception {
		try {
			ResourceBundle rb = (ResourceBundle) this.getGlobalObject(bundle);
			return rb.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
			return "##NOT FOUND##";
		}
	}
	    
}

