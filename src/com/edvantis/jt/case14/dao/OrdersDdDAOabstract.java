package com.edvantis.jt.case14.dao;

import com.edvantis.jt.case14.model.data.Order;



public abstract class OrdersDdDAOabstract {

	public abstract void addToOrdersDB(Order o);
	public abstract void readAllordersDB();
	public abstract void updateOrder(Order order);
	public abstract void updateOrder(int id);
	public abstract void delOrder(int id);

	
}