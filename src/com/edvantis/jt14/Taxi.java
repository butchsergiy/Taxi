package com.edvantis.jt14;

import com.edvantis.jt14.data.OrdersDB;






public class Taxi {

	public static void main(String[] args) {
		
				
		
		OrdersDB orderDB1 = new OrdersDB();
		orderDB1.orderAdd(orderDB1.newOrder());
		orderDB1.orderAdd(orderDB1.newOrder());
		orderDB1.orderAdd(orderDB1.newOrder());
		orderDB1.orderAdd(orderDB1.newOrder());
		orderDB1.orderAdd(orderDB1.newOrder());

		
		
		System.out.println(orderDB1.orders.size());
		
		orderDB1.printAll();
		
	}

}
