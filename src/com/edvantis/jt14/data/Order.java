package com.edvantis.jt14.data;

import java.time.LocalDateTime;


public class Order {

// all fields of object of class Order:
	
	private int orderNum;
	private LocalDateTime dateAndTime;
	private String addr1, addr2, addr34;
	private float distance;
	private float orderCost;
	private String customerphone;
	private String customerName;
	private String carNumber;
	private String carDriver;
	private Boolean isDone;
	
	
	
	
	public int getOrderNum() {
		return orderNum;
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}
	
	public void setDateAndTime(LocalDateTime dateAndTime) {
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
