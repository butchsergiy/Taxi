package com.edvantis.jt.case14.model.data;

import java.sql.Timestamp;



public class Order implements java.io.Serializable{

// all fields of object of class Order:
	
	
	private static final long serialVersionUID = 3714126590731329262L;
	

	private int orderID;
	private Timestamp dateAndTime;
	private String addr1, addr2, addr34;
	private float distance;
	private float orderCost;
	private String customerphone;
	private String customerName;
	private String carNumber;
	private String carDriver;
	private Boolean isDone;
	
	
	public Order() {
	}

	public Order(int orderID) {
		this.orderID = orderID;
	}

	public Order(int orderID, Timestamp dateAndTime, String addr1, String addr2,
			String addr34, float distance, float orderCost,
			String customerphone, String customerName, String carNumber,
			String carDriver, Boolean isDone) {
		this.orderID = orderID;
		this.dateAndTime = dateAndTime;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr34 = addr34;
		this.distance = distance;
		this.orderCost = orderCost;
		this.customerphone = customerphone;
		this.customerName = customerName;
		this.carNumber = carNumber;
		this.carDriver = carDriver;
		this.isDone = isDone;
	}
	
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderID(int orderNum) {
		this.orderID = orderNum;
	}
	
	public Timestamp getDateAndTime() {
		return dateAndTime;
	}
	
	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	public String getAddr1() {
		return addr1;
	}
	
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	public String getAddr2() {
		return addr2;
	}
	
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	public String getAddr34() {
		return addr34;
	}
	
	public void setAddr34(String addr34) {
		this.addr34 = addr34;
	}
	
	public float getDistance() {
		return distance;
	}
	
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public float getOrderCost() {
		return orderCost;
	}
	
	public void setOrderCost(float orderCost) {
		this.orderCost = orderCost;
	}
	
	public String getCustomerphone() {
		return customerphone;
	}
	
	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCarNumber() {
		return carNumber;
	}
	
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	public String getCarDriver() {
		return carDriver;
	}
	
	public void setCarDriver(String carDriver) {
		this.carDriver = carDriver;
	}
	
	public Boolean getIsDone() {
		return isDone;
	}
	
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	
}
