package com.lalit.Garages;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
@Entity
@Component
public class Garages {
	@Id
	private String Contact;
	private String Name;
	private String Address;
	private double Pin;
	private String Email;
	private String Password;
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getPin() {
		return Pin;
	}
	public void setPin(double pin) {
		Pin = pin;
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
	public Garages(String contact, String name, String address, double pin, String email, String password) {
		super();
		Contact = contact;
		Name = name;
		Address = address;
		Pin = pin;
		Email = email;
		Password = password;
	}
	public Garages() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Garages [Contact=" + Contact + ", Name=" + Name + ", Address=" + Address + ", Pin=" + Pin + ", Email="
				+ Email + ", Password=" + Password + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}