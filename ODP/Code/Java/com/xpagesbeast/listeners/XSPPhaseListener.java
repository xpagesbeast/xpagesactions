package com.xpagesbeast.listeners;


import java.util.Iterator;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
 
/**
 * @author Tony McGuckin, IBM
 */
public class XSPPhaseListener implements javax.faces.event.PhaseListener {
 
  private static final long serialVersionUID = 1L;
 
  public PhaseId getPhaseId() {
      return PhaseId.ANY_PHASE;
    }
 
    public void beforePhase(PhaseEvent event) {
      if(event.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
          System.out.println(" ");
        System.out.println("REQUEST:\tStarted......................");
      }
      System.out.println(" ");
      System.out.println("Lifecycle:\tBefore Phase: " + event.getPhaseId());
      /*
      Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
      
      if(null != parameterMap){
    	  Iterator itr = parameterMap.entrySet().iterator();
    	  while(itr.hasNext()){
    		  Map.Entry<String, String> pair = (Map.Entry<String, String>) itr.next();
    		  System.out.println(pair.getKey() + " = " + pair.getValue());
    		  itr.remove();
    	  }
      }
      */
      
    }
 
    public void afterPhase(PhaseEvent event) {
      System.out.println("Lifecycle:\tAfter Phase: " + event.getPhaseId() + "\\\\\\\\\\\\\\\\\\\\\\");
      System.out.println(" ");
      if(event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
        System.out.println("REQUEST:\tCompleted......................");
        System.out.println(" ");
      }
    }
}
