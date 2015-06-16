package com.edvantis.jt.case14.controller;

import java.sql.*;

import com.edvantis.jt.case14.model.data.Order;
import com.edvantis.jt.case14.model.data.OrdersDB;



public class WorkWithMySql {
	
//JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost/taxiservice";

//  Database credentials
static final String USER = "root";
static final String PASS = "root";
	
	public static void ReadAllFromMySQLordersDB(){
		Connection conn = null;
		Statement stmt = null;
		OrdersDB orderDB=OrdersDB.getReference();
		Order order;
		
		 try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT id, dateAndTime, addr1, addr2, addr34, distance, orderCost, customerPhone, customerName, carNumber, carDriver, isDone FROM ordersdb";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		    	  order = new Order();
		    	  
		    	  order.setOrderID(rs.getInt("id"));
//		    	  order.setDateAndTime(rs.getString("dateAndTime"));			/// ToDo from string YYYY-MM-DD HH:MM:SS to DateAndTime
		    	  order.setAddr1(rs.getString("addr1"));
		    	  order.setAddr2(rs.getString("addr2"));
		    	  order.setAddr34(rs.getString("addr34"));
		    	  order.setDistance(rs.getFloat("distance"));
		    	  order.setOrderCost(rs.getFloat("orderCost"));
		    	  order.setCustomerphone(rs.getString("customerPhone"));
		    	  order.setCustomerName(rs.getString("customerName"));
		    	  order.setCarNumber(rs.getString("carNumber"));
		    	  order.setCarDriver(rs.getString("carDriver"));
		    	  order.setIsDone( ((rs.getInt("isDone"))!=0) );
//		    	  order.setIsDone( ((rs.getInt("isDone"))!=0)?true:false );
		    	    	  
		    	  orderDB.orderAdd(order);
		      }
		      
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		   System.out.println("\n==Thats All. Read operation from DB done.==");
		   
	}
	
	
	

	
	


//public static void WriteOrderToMySQLordersDB(Order o){  				// NOT done
//	Connection conn = null;
//	Statement stmt = null;
//	
//	 try{
//	      //STEP 2: Register JDBC driver
//	      Class.forName("com.mysql.jdbc.Driver");
//
//	      //STEP 3: Open a connection
//	      System.out.println("Connecting to database...");
//	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//	      //STEP 4: Execute a query
//	      System.out.println("Creating statement...");
//	      stmt = conn.createStatement();
//	      String sql;
//	      sql = "SELECT id, dateAndTime, addr1, addr2, distance, orderCost, customerPhone, customerName, carNumber, carDriver, isDone FROM ordersdb";
//	      ResultSet rs = stmt.executeQuery(sql);
//
//	      //STEP 5: Extract data from result set
//	      while(rs.next()){
//	    	  
//	         //Retrieve by column name
////	         int id  = rs.getInt("id");
////	         int age = rs.getInt("age");
////	         String first = rs.getString("first");
////	         String last = rs.getString("last");
////
//
//	      }
//	      //STEP 6: Clean-up environment
//	      rs.close();
//	      stmt.close();
//	      conn.close();
//	   }catch(SQLException se){
//	      //Handle errors for JDBC
//	      se.printStackTrace();
//	   }catch(Exception e){
//	      //Handle errors for Class.forName
//	      e.printStackTrace();
//	   }finally{
//	      //finally block used to close resources
//	      try{
//	         if(stmt!=null)
//	            stmt.close();
//	      }catch(SQLException se2){
//	      }// nothing we can do
//	      try{
//	         if(conn!=null)
//	            conn.close();
//	      }catch(SQLException se){
//	         se.printStackTrace();
//	      }
//	   }
//	   System.out.println("\n==Thats All. Read operation from DB done.==");
//	}



}


// CREATE TABLE `taxiservice`.`ordersdb` (
//		  `id` INT NOT NULL,
//		  `dateAndTime` DATETIME NULL,
//		  `addr1` VARCHAR(45) NULL,
//		  `addr2` VARCHAR(45) NULL,
//		  `addr34` VARCHAR(45) NULL,
//		  `distance` FLOAT NULL,
//		  `orderCost` FLOAT NULL,
//		  `customerPhone` VARCHAR(45) NULL,
//		  `customerName` VARCHAR(45) NULL,
//		  `carNumber` VARCHAR(45) NULL,
//		  `carDriver` VARCHAR(45) NULL,
//		  `isDone` INT NULL,
//		  PRIMARY KEY (`id`));

// INSERT INTO `taxiservice`.`ordersdb` (`id`, `addr1`, `addr2`, `addr34`, `distance`, `orderCost`, `customerPhone`, `customerName`, `carNumber`, `carDriver`, `isDone`) VALUES ('1', 'aaaa1', 'sss2', 'ddd3', '35', '66', '2223344', 'Serg', 'cc1111cc', 'vova', '0');
// UPDATE `taxiservice`.`ordersdb` SET `distance`='11', `orderCost`='111', `customerPhone`='1112233', `isDone`='1' WHERE `id`='1';


