package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edvantis.jt.case14.dao.OrderDAOabstract;
import com.edvantis.jt.case14.dao.factory.OrderDAOFactory;
import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.model.data.Order;
import com.edvantis.jt.case14.model.data.OrdersDB;
import com.edvantis.jt.case14.model.workers.OperatorSimple;

public class OrdersDBDAOTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void speedTestAddOrderToMySQLDB() throws OrderException {
		final String ORM_TYPE = "JDBC";
		final String DB_TYPE = "MySQL";
		OrderDAOabstract ordersDBDAO = OrderDAOFactory.getOrdersDbDAO(
				ORM_TYPE, DB_TYPE);

		
		for (int i = 0; i<100; i++){
		Order order = OperatorSimple.orderCreateTemp();
		ordersDBDAO.addToOrdersDB(order);
		}
	}
	
	/*
	 *  So working with DB in RAM is more than 10 times faster that 
	 *  adding 10 workers to DB
	 */
	@Test
	public void testAddOrderToRAMDB() throws OrderException {
		for (int i = 0; i<100; i++){
		Order order = OperatorSimple.orderCreateTemp();
		OrdersDB.getReference().orderAdd(order);
		}
	}

}


