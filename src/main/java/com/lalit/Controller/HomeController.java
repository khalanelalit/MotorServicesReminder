package com.lalit.Controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.lalit.Garages.Garages;
import com.lalit.Garages.Vehicle;
import com.lalit.Garages.WorkLog;
import com.lalit.Garages.Garages;
import com.lalit.GaragesDao.GaragesDao;
import com.lalit.GaragesDao.VehicleDao;
import com.lalit.GaragesDao.WorkLogDao;

@Controller
public class HomeController {
	
	
	ApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
	 
	Garages garages=(Garages) context.getBean("garages");
	 GaragesDao garagesDao=(GaragesDao) context.getBean("garagesDao");
	 WorkLog workLog=(WorkLog) context.getBean("workLog");
		WorkLogDao workLogDao=(WorkLogDao) context.getBean("workLogDao");
	 
	 @RequestMapping("/")
	 public String index()
	 {
	 	return"index";
	 }
	 
	@RequestMapping("/adminLogin")

	public String openLogin()
	{
		return"adminLogin";
		
	}


	@RequestMapping(path="/afterLogin",method=RequestMethod.POST)
	public String afterLogin(HttpServletRequest request)
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		if(email.equals("admin@gmail.com")&& password.equals("admin"))
				{
					 return"adminDash";
				}
		else
		{
			return"error";
		}
		
		
	}
	 

	
	@RequestMapping("/addGarages")
	public String addGarages()
	{
		return "addGarages";
	}

		 
	@RequestMapping(path="/afterAdd",method=RequestMethod.POST)
	public String afterAdd(HttpServletRequest request )
	{
		
		String Contact=request.getParameter("Contact");
		String Name=request.getParameter("Name");
		String Address=request.getParameter("Address");
		double Pin= Double.parseDouble(request.getParameter("Pin"));
		String Email=request.getParameter("Email");
		String Password=request.getParameter("Password");
	
		
		garages.setContact(Contact);
		garages.setName(Name);
		garages.setAddress(Address);
		garages.setPin(Pin);
		garages.setEmail(Email);
		garages.setPassword(Password);
		
		String r= garagesDao.addGarages(garages);
		if(r.equals(Contact)){
			return "success";
			
		}else
		{
			return "error";
		}

	}
	
	@RequestMapping("/viewAll")
	public String viewAccount(Model m)

	{
		List<Garages>allAccount=garagesDao.getAllGarages();
		m.addAttribute("list",allAccount);
		return"viewAll";
	}
	
	
	
	@RequestMapping(path="/delete/{accid}",method=RequestMethod.GET)
	public RedirectView deleteAccount(@PathVariable("accid") String contact,HttpServletRequest request)

	{
		garagesDao.deletegarages(contact);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewAll");
		return redirectView;
	}

//	@RequestMapping(path="/Approve/{accid}",method=RequestMethod.GET)
//	public RedirectView updateAccount(@PathVariable("accid") String contact ,HttpServletRequest request)
//
//	{
//		garagesDao.getgarages(contact);
//		garages =garagesDao.getgarages(contact);
//		String type =  garages.getStatus();
//		type = "Approve";
//		garages.setStatus(type);
//		garagesDao.updateGarages(garages);
////		accounts.setAccNo("Approve");
//		
//		
//		
//		garagesDao.updateGarages(garages);
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl(request.getContextPath()+"/viewAll");
//		return redirectView;
//	}




	
	
	@RequestMapping("/garagesLogin")

	public String garagesLogin()
	{
		return"garagesLogin";
		
	}
	
	
	@RequestMapping(path="/afterGaragesLogin",method=RequestMethod.POST)
	public String afterGaragesLogin(HttpServletRequest request)
	{
		String contact=request.getParameter("contact");
		String password=request.getParameter("password");
		 garages  =garagesDao.getgarages(contact);
		 String ac=garages.getContact();
		 String bc=garages.getPassword();
		
		 
		if(contact.equals(ac)&& password.equals(bc))
		
				{
					 return"garagesDash";
				}
		else
		{
			return"error";
		}
		
		
	}
	
	@RequestMapping("/garagesDash")

	public String garagesLogi()
	{
		return"garagesDash";
		
	}
	
	
	
	
	
	@RequestMapping("/viewExpiraryAtGarages")   //View All  at garages expiry workLog
	 public String viewExpiryWorkLog(Model m)
	 {
		 
		String con = garages.getContact();
		 List<WorkLog>allworkLog=workLogDao.getAllWorkLog();
		 
		 m.addAttribute("list",allworkLog);   
		 return"viewExpiraryAtGarages";
		 
		 
		 

//			@RequestMapping("/viewExpiryWorkLog")   //View All expiry workLog
//			 public String viewExpiryWorkLog(Model m)
//			 {
//				 
//				String vno = vehicle.getVehicleNo();
//				 List<WorkLog>allworkLog=workLogDao.getAllWorkLog();
//				 
//				 List<WorkLog> filteredWorkLogs = new ArrayList<WorkLog>();
//				 for (WorkLog workLog : allworkLog)
//				 {
//					if(workLog.getVehicleNo().equals(vno))
//			    	{
//			    		filteredWorkLogs.add(workLog);
//			    	}
//				 }
//				 
//				 
//				 
//				 
//				 
//				 
//				    		
//				    		
//				    		
//				    		m.addAttribute("list",filteredWorkLogs);
//				   		 return"viewExpiryWorkLog";
//				    		
//				    	}
//				    
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		    		
		    		
		    		
		    		
		    		
		    	}
			 
			 
			 
			 
		 
		 
		 
		 
		 
		    		
		    		
		    		
		    		
		    	}
		    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	


