package com.edvantis.jt.case14.model.workers;

/**
 *  Abstract class for operators.
 *  they can create new order
 * 
 *
 */



public abstract class OperatorAbs extends Worker {

	abstract public void orderAdd();
	abstract public void orderGetList();
	abstract public void orderChange(int orderNumber);
	
	
	abstract public void makeReport();
}
