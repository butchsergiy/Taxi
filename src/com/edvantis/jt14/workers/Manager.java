package com.edvantis.jt14.workers;

import com.edvantis.jt14.data.*;
import com.edvantis.jt14.*;



public class Manager extends Worker implements WorkersInterface{

/**
 *  Manager can:
 *  1. Make report for any period of time
 *  2. Add or delete any worker
 * 
 */
	
	OrdersDB a=OrdersDB.getReference();
	
	
	public void doReportWithOrders() {
		a.printAll();
		}
	
	public void doReportWithWorkers() {
		
	}
	
	
	@Override
	public void addWorker() {
		
	}
	

	@Override
	public void delWorker() {
		
		
	}

	@Override
	public void printWorkers() {
		
		
	}
	
}
