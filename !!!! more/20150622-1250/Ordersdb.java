// default package
// Generated Jun 22, 2015 11:12:57 AM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Ordersdb generated by hbm2java
 */
public class Ordersdb implements java.io.Serializable {

	private Integer id;
	
	private Date dateAndTime;
	
	private String addr1;
	private String addr2;
	private String addr34;
	private Float distance;
	private Float orderCost;
	private String customerPhone;
	private String customerName;
	private String carNumber;
	private String carDriver;
	private Integer isDone;

	public Ordersdb() {
	}

	public Ordersdb(Date dateAndTime, String addr1, String addr2,
			String addr34, Float distance, Float orderCost,
			String customerPhone, String customerName, String carNumber,
			String carDriver, Integer isDone) {
		this.dateAndTime = dateAndTime;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr34 = addr34;
		this.distance = distance;
		this.orderCost = orderCost;
		this.customerPhone = customerPhone;
		this.customerName = customerName;
		this.carNumber = carNumber;
		this.carDriver = carDriver;
		this.isDone = isDone;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateAndTime() {
		return this.dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr34() {
		return this.addr34;
	}

	public void setAddr34(String addr34) {
		this.addr34 = addr34;
	}

	public Float getDistance() {
		return this.distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public Float getOrderCost() {
		return this.orderCost;
	}

	public void setOrderCost(Float orderCost) {
		this.orderCost = orderCost;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCarNumber() {
		return this.carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarDriver() {
		return this.carDriver;
	}

	public void setCarDriver(String carDriver) {
		this.carDriver = carDriver;
	}

	public Integer getIsDone() {
		return this.isDone;
	}

	public void setIsDone(Integer isDone) {
		this.isDone = isDone;
	}

}