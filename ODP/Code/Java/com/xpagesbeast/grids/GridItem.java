package com.xpagesbeast.grids;

import com.xpagesbeast.interfaces.ManagedItem;

public class GridItem<T> implements ManagedItem{

	private T item = null;
	
	public GridItem(){
		
	}
	
	public GridItem(T t){
		item = t;
	}
	
	public T getItem(){
		return item;
	}
	
	public void setItem(T t){
		item = t;
	}

	public void copyBackEndToFrontEnd() {
		// TODO Auto-generated method stub
		
	}

	public void copyFrontEndToBackEnd() {
		// TODO Auto-generated method stub
		
	}

}
