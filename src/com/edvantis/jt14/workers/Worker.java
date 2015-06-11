package com.edvantis.jt14.workers;

import java.time.LocalDate;



public class Worker  {

	private long 	idNumber;
	private String 	name;
	private String 	position;
	private LocalDate birthDate;
	private int 	accessLevel;
	private String 	carNumber;
	private String 	password;
	private Boolean logget;
	
	
	
	
	public long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public int getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public String getCarNumber() {
		return carNumber;
	}
	
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getLogget() {
		return logget;
	}
	
	public void setLogget(Boolean logget) {
		this.logget = logget;
	}
	
	
	
	
}
