package com.edvantis.jt.case14.model.data;

public interface OrdersDBInterface {
	
	public void orderAdd(Order order);
	public void orderDel(int number);
	public Order orderGet(int number);
	public Order orderSet(int number);
	
	

	
	
	

}
