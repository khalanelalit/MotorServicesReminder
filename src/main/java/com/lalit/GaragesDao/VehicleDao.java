package com.lalit.GaragesDao;


import com.lalit.GaragesDao.VehicleDao;

import com.lalit.Garages.Vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component
public class VehicleDao {
	
	

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Transactional
	public String addVehicle(Vehicle vehicle) {
		
		String i = (String) hibernateTemplate.save(vehicle);	
		return i;
	}
	
	
	
	
	@Transactional
	public void  updateVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(vehicle);
		
	}
	
	
	
	@Transactional

	public void deleteVehicle(String VehicleNo)
	{
		Vehicle ac=hibernateTemplate.get(Vehicle.class, VehicleNo);
		hibernateTemplate.delete(ac);

		 
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	public List<Vehicle> getAllVehicle()
	{
		return hibernateTemplate.loadAll(Vehicle.class);
	}

	
	public Vehicle getvehicle(String VehicleNo) {
		
		Vehicle acc=hibernateTemplate.get(Vehicle.class, VehicleNo);
		return acc;
		
	}
	
	
	
	
	
	
	
	

}
