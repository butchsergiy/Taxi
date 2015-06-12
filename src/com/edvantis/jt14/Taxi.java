package com.edvantis.jt14;

import com.edvantis.jt14.data.*;
import com.edvantis.jt14.workers.*;






public class Taxi {

	public static void main(String[] args) {
		
				
		
		OrdersDB ordersDB1 = OrdersDB.getReference();
		
		
		ordersDB1.orderAdd(ordersDB1.newOrder());
		ordersDB1.orderAdd(ordersDB1.newOrder());
		ordersDB1.orderAdd(ordersDB1.newOrder());
		ordersDB1.orderAdd(ordersDB1.newOrder());
		ordersDB1.orderAdd(ordersDB1.newOrder());

		
		
//		System.out.println(ordersDB1.getOrdersDBSize());
		
		
		
//		ordersDB1.printAll();
		
		Manager man1=new Manager();
		man1.doReportWithOrders();
		
	}

}
