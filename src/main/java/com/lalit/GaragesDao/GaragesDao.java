package com.lalit.GaragesDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.lalit.Garages.Garages;


@Component
public class GaragesDao {
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Transactional
	public String addGarages(Garages garages) {
		
		String i = (String) hibernateTemplate.save(garages);	
		return i;
	}
	
	
	
	public Garages getgarages(String Contact) {
		
		Garages acc=hibernateTemplate.get(Garages.class, Contact);
		return acc;
		// TODO Auto-generated method stub
		
	}
	
	
	@Transactional
	public void  updateGarages(Garages garages) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(garages);
		
	}
	
	
	
	@Transactional

	public void deletegarages(String contact)
	{
		Garages ac=hibernateTemplate.get(Garages.class, contact);
		hibernateTemplate.delete(ac);

		 
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	public List<Garages> getAllGarages()
	{
		return hibernateTemplate.loadAll(Garages.class);
	}

	

	
	
	

}
