package com.lalit.GaragesDao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lalit.Garages.WorkLog;
import com.sun.corba.se.spi.orbutil.threadpool.Work;





@Component
public class WorkLogDao {
	
	
	
	private Date dueDate;
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Date getDueDate() {
	    return this.dueDate;
	}



	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Transactional
	
	public int addWorkLog(WorkLog workLog)
	{
		int i =(Integer) hibernateTemplate.save(workLog);
		return i;
	}
	
public List <WorkLog> searchWorkLog(String VehicleNo)

		{   	List<WorkLog> result = (List<WorkLog>) hibernateTemplate.findByCriteria(
		        DetachedCriteria.forClass(WorkLog.class)
		        .add(Restrictions.eq("VehicleNo", VehicleNo)));
		for(WorkLog c: result){
		System.out.println(c);
		}
		return result;
		
}










	
public List <WorkLog> getAllWorkLog()
{
	return hibernateTemplate.loadAll(WorkLog.class);
}
	
	


// Other constructors and methods


	
	
	
	
	
	
	
	
	
	
	

}
