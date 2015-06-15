package com.edvantis.jt.case14.model.workers;

import com.edvantis.jt.case14.exceptions.WorkerExceptions;



public interface WorkersInterface {

	public void workerAdd(Worker w) throws WorkerExceptions;
	public void workerDel(long id);
	public void workersPrint();
	
}
