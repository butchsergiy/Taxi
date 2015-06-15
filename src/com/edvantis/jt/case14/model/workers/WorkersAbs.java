package com.edvantis.jt.case14.model.workers;

import com.edvantis.jt.case14.exceptions.WorkerExceptions;



public abstract class WorkersAbs implements WorkersInterface {

	
	public abstract void workerAdd(Worker w) throws WorkerExceptions;

	public abstract void workersPrint();

	public abstract void workerDel(long id);
	


	
}
