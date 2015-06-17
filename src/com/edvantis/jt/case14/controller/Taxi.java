package com.edvantis.jt.case14.controller;

import com.edvantis.jt.case14.dao.OrdersDdDAOabstract;
import com.edvantis.jt.case14.dao.factory.OrdersDbDAOFactory;
import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.exceptions.WorkerExceptions;
import com.edvantis.jt.case14.model.data.*;
import com.edvantis.jt.case14.model.workers.*;


public class Taxi {

	public static void main(String[] args) {
		
		final String ORM_TYPE 	=	"JDBC";
		final String DB_TYPE 	=	"MySQL";
		OrdersDdDAOabstract ordersDBDAO = OrdersDbDAOFactory.getOrdersDbDAO(ORM_TYPE, DB_TYPE);
		
		OrdersDB ordersDB0 = OrdersDB.getReference();
		WorkersDB workersDB0 = WorkersDB.getReference();
		
		

/*
 * SIMULATION bussines logic with WORKERS
 */
		
		Manager man1=new Manager(1,"Vova Biggest Manager","Manager");		//create first manager, and only he has right to create and add new workers(operators and drivers)
		try{workersDB0.workerAdd(man1);} catch (WorkerExceptions e){}
		try{workersDB0.workerAdd(man1.workerCreateTemp()); }catch (WorkerExceptions e){}			// here I simulate how Manager adding of new worker(random)
		try{workersDB0.workerAdd(man1.workerCreateTemp()); }catch (WorkerExceptions e){}			// here I simulate how Manager adding of new worker(random)		 			
			
		workersDB0.workersPrint();
		System.out.println("------------------------------------");
		
		
/*
 * SIMULATION bussines logic with ORDERS 
 */
		
		System.out.println("\n----------------\n---- ORDERS ----");
		
		// here I read all data from ordersDB table of database
		ordersDBDAO.readAllordersDB();				
				
		// just for testing. I simulate process of creating of order and adding that order to ordersDB. 
		try {ordersDB0.orderAdd(OperatorSimple.orderCreateTemp());} catch (OrderException e) {}
		try {ordersDB0.orderAdd(OperatorSimple.orderCreateTemp());} catch (OrderException e) {}
		try {ordersDB0.orderAdd(OperatorSimple.orderCreateTemp());} catch (OrderException e) {}

		man1.doReportWithOrders();
		System.out.println("------------------------------------");
		System.out.println("We already have " + ordersDB0.getOrdersDBSize() + " orders.");
		System.out.println("------------------------------------");
		

		ordersDBDAO.addToOrdersDB(OperatorSimple.orderCreateTemp());
	
		
		
	}
}
