package com.edvantis.jt.case14.model.workers;

import com.edvantis.jt.case14.model.data.Order;

/**
 *  Abstract class for operators.
 *  they can create new order
 * 
 *
 */



public abstract class OperatorAbstract extends Worker {

	abstract public Order orderCreate();
	abstract public void orderGetList();
	abstract public void orderChange(int orderNumber);
	
	
	abstract public void makeReport();
}
