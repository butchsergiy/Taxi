package com.edvantis.jt.case14.model.workers;

import com.edvantis.jt.case14.model.data.*;




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
