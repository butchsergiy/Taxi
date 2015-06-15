package com.edvantis.jt.case14.model.workers;

import java.time.LocalDate;

import com.edvantis.jt.case14.model.data.*;


public class Manager extends Worker implements WorkersInterface{

/**
 *  Manager can:
 *  1. Make report for any period of time
 *  2. Add or delete any worker
 * 
 */
	
// Constructor #1.	
	public Manager(int id, String name, String pos) {
		
		this.setIdNumber(id);
		this.setName(name);
		this.setPosition(pos);
//		
//		System.out.println(this.getIdNumber());
//		System.out.println(this.getName());
		
		}

	OrdersDB a=OrdersDB.getReference();
	
	
	public void doReportWithOrders() {
		a.printAll();
		}
	
	
	public void doReportWithWorkers() {
		
	}
	
	
/////////////////////////////////////////////////////////////////////////
// when this program will be done this method would call webpage where manager will 
// enter all data about new worker and press button Add and it will call (workersDB0.workerAdd(Worker w))
//
// But now I just simulate that process.
	public Worker workerCreateTemp(){
		Worker w=new Worker();
		w.setIdNumber((int)(Math.random() * 100000000));
		w.setName("Oleg_" + ((int) (Math.random() * 100)));
		w.setBirthDate(LocalDate.parse("1980-01-01"));
		w.setPosition(WorkersDB.positions[(int)(Math.random()*3)]);
		w.setAccessLevel(1);
		w.setPassword("");
		w.setLogget(false);
		
		
		return w;
	}

	
	@Override
	public void workerDel() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void workersPrint() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void workerAdd(Worker w) {

	}
	
}
