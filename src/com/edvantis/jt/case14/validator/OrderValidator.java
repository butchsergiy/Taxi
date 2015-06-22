package com.edvantis.jt.case14.validator;

import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.model.data.Order;


public class OrderValidator {
	
public static void orderDataIsValid (Order o) throws OrderException {
		
		try{
			
			if (o.getAddr1()==null || o.getAddr1().isEmpty() || o.getAddr2()== null || o.getAddr2().isEmpty() || 
				o.getCustomerPhone()== null ||o.getCustomerPhone().isEmpty()){throw new OrderException(" Error. Order without full information.");} 
			
			if (o.getCustomerPhone().matches("[0-9]+") && o.getCustomerPhone().length() < 7) {throw new OrderException("Order ID: "+o.getId()+" has Error = Customer number is faulty. ("+o.getCustomerPhone()+"). Must contains more than 7 digits");} 
			
						
// and mode and more more validation we can add here 
// for all fields of Order object.
			
			}
		finally{}
					
			
	}
	

}
