package com.xpagesbeast.grids;

import java.util.List;
import java.util.ArrayList;

public class Grid<T> {
	
	//This is a collection of objects.
	private List<T> list = new ArrayList<T>();
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public void Grid(ArrayList<T> t){
		list = t;
	}
	
	/* delete from list */
	public void deleteItem(int index){
		list.remove(index);
	}
		
	/* Get Item from the list */
	public T getItem(int index){
		return list.get(index);
	}
	
	/*Add to list*/
	public void addItem(T t){
		list.add(t);
	}
	
}
