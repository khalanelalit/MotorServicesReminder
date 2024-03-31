package com.lalit.Garages;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Vehicle {
	
	@Id
	private String VehicleNo;
	private String ChassisNo;
	private String Name;
	private String OwnerName;
	private String Contact;
	private String Address;
	private String Email;
	private String Password;
	
	
	
	public String getVehicleNo() {
		return VehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}
	public String getChassisNo() {
		return ChassisNo;
	}
	public void setChassisNo(String chassisNo) {
		ChassisNo = chassisNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Vehicle [VehicleNo=" + VehicleNo + ", ChassisNo=" + ChassisNo + ", Name=" + Name + ", OwnerName="
				+ OwnerName + ", Contact=" + Contact + ", Address=" + Address + ", Email=" + Email + ", Password="
				+ Password + "]";
	}
	public Vehicle(String vehicleNo, String chassisNo, String name, String ownerName, String contact, String address,
			String email, String password) {
		super();
		VehicleNo = vehicleNo;
		ChassisNo = chassisNo;
		Name = name;
		OwnerName = ownerName;
		Contact = contact;
		Address = address;
		Email = email;
		Password = password;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	

}
