package com.edvantis.jt.case14.model.workers;

import com.edvantis.jt.case14.exceptions.WorkerExceptions;



public abstract class WorkersAbs implements WorkersInterface {

	
	abstract public void workerAdd(Worker w) throws WorkerExceptions;

	abstract public void workersPrint();
	


	
}
