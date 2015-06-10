package com.edvantis.jt_14.data;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;




public class OrdersDB implements OrdersDB_Interface{

	List<Order> orders=new LinkedList<>();
	
	
	
	// constructor #1 - If created object of this class without parameters it meens that
	// will be created object in RAM with all records from OrdersDB.
	public OrdersDB(){
		
	}
	
	
	// constructor #2 - for that case when we need to work 
	// with data of specific period
	public OrdersDB(LocalDate Date1, LocalDate Date2) {

	}
	
	
	
	@Override
	public void orderAdd() {
				
	}

	@Override
	public void orderDel() {
				
	}

	
}
