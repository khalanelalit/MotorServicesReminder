package com.lalit.Garages;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component

public class WorkLog {
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int WorkLogId;
	
	private String VehicleNo;
	private String title;
	private String description;
	private String date;
	private String email;
	private String contact;
	private String address;
	private String garageContact;
	private String dueDate;
	
	
	
	public int getWorkLogId() {
		return WorkLogId;
	}
	public void setWorkLogId(int workLogId) {
		WorkLogId = workLogId;
	}
	public String getVehicleNo() {
		return VehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGarageContact() {
		return garageContact;
	}
	public void setGarageContact(String garageContact) {
		this.garageContact = garageContact;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	
	@Override
	public String toString() {
		return "WorkLog [WorkLogId=" + WorkLogId + ", VehicleNo=" + VehicleNo + ", title=" + title + ", description="
				+ description + ", date=" + date + ", email=" + email + ", contact=" + contact + ", address=" + address
				+ ", garageContact=" + garageContact + ", dueDate=" + dueDate + "]";
	}
	public WorkLog(int workLogId, String vehicleNo, String title, String description, String date, String email,
			String contact, String address, String garageContact, String dueDate) {
		super();
		WorkLogId = workLogId;
		VehicleNo = vehicleNo;
		this.title = title;
		this.description = description;
		this.date = date;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.garageContact = garageContact;
		this.dueDate = dueDate;
	}
	public WorkLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	

}
