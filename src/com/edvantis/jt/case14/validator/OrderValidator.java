package com.edvantis.jt.case14.validator;

import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.model.data.Order;


public class OrderValidator {
	
public static void orderDataIsValid (Order o) throws OrderException {
		
		try{
			
			if (o.getAddr1()==null || o.getAddr1().isEmpty() || o.getAddr2()== null || o.getAddr2().isEmpty() || 
				o.getCustomerphone()== null ||o.getCustomerphone().isEmpty()){throw new OrderException(" Error. Order without full information.");} 
			
			if (o.getCustomerphone().matches("[0-9]+") && o.getCustomerphone().length() < 7) {throw new OrderException("Order ID: "+o.getOrderID()+" has Error = Customer number is faulty. ("+o.getCustomerphone()+"). Must contains more than 7 digits");} 
			
						
// and mode and more more validation we can add here 
// for all fields of Order object.
			
			}
		finally{}
					
			
	}
	

}
