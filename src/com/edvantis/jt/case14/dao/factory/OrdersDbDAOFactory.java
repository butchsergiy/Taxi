package com.edvantis.jt.case14.dao.factory;

import com.edvantis.jt.case14.dao.OrdersDdDAOabstract;
import com.edvantis.jt.case14.dao.mysql.OrdersDBDAOJBDC;

public class OrdersDbDAOFactory {

	public static OrdersDdDAOabstract getOrdersDbDAO(String ormType, String dbType){
		
		if(ormType.equalsIgnoreCase("jdbc"))	 return OrdersDBDAOJBDC.getReference();
		
		if(ormType.equalsIgnoreCase("hibernate")) return null;	// need to create here object of OrdersDBDAOHibernate class	 
		
		return null;
	}
	
}
