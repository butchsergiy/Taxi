package com.edvantis.jt.case14.model.workers;

import java.util.LinkedList;
import java.util.List;


import com.edvantis.jt.case14.exceptions.WorkerExceptions;
import com.edvantis.jt.case14.validator.WorkerValidator;



public class WorkersDB extends WorkersAbs{

	private static WorkersDB w=new WorkersDB();				// Singeton
	
	private List<Worker> workers=new LinkedList<>();
	
	public static String[] positions={"Manager", "simple Operator", "main Operator", "Driver"};
	
// constructor #1 	
	private WorkersDB() {
		
	}
	
	public static WorkersDB getReference(){
		
		return w;
	}
	
//////////////////////////////////////////////////////////////////////////	
	
	
	public int getWorkersDBSize(){
		return w.workers.size();
	}
	

	@Override
	public void workerDel() {

	}
	

	@Override
	public void workerAdd(Worker w) throws WorkerExceptions {
		WorkerValidator.workerDataIsValid(w);
		System.out.println("ID: "+ w.getIdNumber() + ", Worker: " + w.getName()+ ", added to the Workers DB.\n");
		workers.add(w);	
	}
	
	

	@Override
	public void workersPrint() {
		System.out.println("\n We have "+ workers.size() + " workers:");
		for(Worker w: workers){
			System.out.println();
			System.out.println(" worker ID number:\t"+w.getIdNumber());
			System.out.println(" worker Name:\t\t"+ w.getName());
			System.out.println(" worker possition:\t" + w.getPosition() );
			System.out.println(" worker birthday:\t" + w.getBirthDate() );
			
		}
	
	}


	
	
	
}


