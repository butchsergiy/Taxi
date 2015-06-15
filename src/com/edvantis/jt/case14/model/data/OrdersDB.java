package com.edvantis.jt.case14.model.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;





public class OrdersDB implements OrdersDBInterface{

	private static OrdersDB s=new OrdersDB();			// Singleton 
	
	private List<Order> orders=new LinkedList<>();
		
		
// constructor #1 - If created object of this class without parameters it meens that
// will be created object in RAM with all records from OrdersDB.
	private OrdersDB(){
				
	}
	
	
// constructor #2 - for that case when we need to work 
// with data of specific period
//	public OrdersDB(LocalDate Date1, LocalDate Date2) {
//				
//	}
	
	public static OrdersDB getReference(){
		return s;
	}
	
	
	public int getOrdersDBSize(){
		return s.orders.size();
	}
	
	
	
	
	
	public void orderAdd(Order order) {
		orders.add(order);
//		System.out.println("orders.indexOf(order) "+ orders.indexOf(order)); 
		orders.get(orders.indexOf(order)).setOrderNum(orders.indexOf(order));			// orderNumber = indexOf that object
		// here need to add command to save new order to DB 
	}

	public void orderDel(int number) {
				
	}


	@Override
	public Order orderGet(int number) {
		return null;	
	}


	@Override
	public Order orderSet(int number) {
		return null;		
	}

	
	
	
	public Order newOrder() {

		Order o = new Order();

		// input of the data

		o.setDateAndTime(LocalDateTime.now());
//		o.setOrderNum((int) (Math.random() * 1000));
		o.setAddr1("From: Volodymyra " + ((int)(Math.random() * 200)));
		o.setAddr2("To: Chernivetska " + ((int)(Math.random() * 200)));
		o.setDistance((int) (Math.random() * 1000));
		o.setOrderCost((int) (Math.random() * 1000));
		o.setCustomerphone(Integer.toString((int)(Math.random() * 10000000)));
		o.setCarNumber(Integer.toString((int)(Math.random() * 100000)));
		o.setCarDriver("Vasil_" + ((int)(Math.random() * 100)));
		o.setIsDone(true);

		// Scanner inp = new Scanner(System.in);
		// while (true) {
		// try {
		// System.out.println("** Please enter unique Order number ");
		// o.setOrderNum(inp.nextInt());
		// break;
		// } catch (Exception e) {
		// System.out.println(e.getMessage()+
		// "\n** Please enter correct number");
		// }
		// }
		// inp.close();

		return o;
	}

	
	public void printAll(){
		
		
		for(int i=0; i<orders.size(); i++){
			System.out.println();
			System.out.println("N= "+orders.get(i).getOrderNum());
			System.out.println(orders.get(i).getDateAndTime());
			System.out.println(orders.get(i).getAddr1());
			System.out.println(orders.get(i).getAddr2());
			System.out.println(" km:\t"+orders.get(i).getDistance());
			System.out.println(" grn: \t"+orders.get(i).getOrderCost());
			System.out.println(" (phone) \t"+orders.get(i).getCustomerphone());
			System.out.println(" car driver: \t"+orders.get(i).getCarDriver()); 
			System.out.println(" car number: \t"+orders.get(i).getCarNumber());
			System.out.println(" is done: \t"+orders.get(i).getIsDone());
			
		}
	}
	
	
	

	
}
