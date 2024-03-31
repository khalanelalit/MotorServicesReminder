package com.lalit.Controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
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

import com.lalit.Garages.Vehicle;
import com.lalit.Garages.WorkLog;
import com.lalit.GaragesDao.VehicleDao;
import com.lalit.GaragesDao.WorkLogDao;
@Controller
public class HomeVehicleController {
	
	
	ApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
	
		 Vehicle vehicle=(Vehicle) context.getBean("vehicle");
		 VehicleDao vehicleDao=(VehicleDao) context.getBean("vehicleDao");
		 WorkLog workLog=(WorkLog) context.getBean("workLog");
		 WorkLogDao workLogDao=(WorkLogDao) context.getBean("workLogDao");
		
	 @RequestMapping("/addVehicle")
		public String addVehicle()
		{
			return "addVehicle";
		}

		@RequestMapping(path="/afterAddVehicle",method=RequestMethod.POST)
		public String afterAddVehicle(HttpServletRequest request )
		{
			
			String VehicleNo=request.getParameter("VehicleNo");
			String ChassisNo=request.getParameter("ChassisNo");
			String Name=request.getParameter("Name");
			String OwnerName=request.getParameter("OwnerName");
			String Contact=request.getParameter("Contact");
			String Address=request.getParameter("Address");
			String Email=request.getParameter("Email");
			String Password=request.getParameter("Password");
		
		//set the data
			vehicle.setVehicleNo(VehicleNo);
			vehicle.setChassisNo(ChassisNo);
			vehicle.setName(Name);
			vehicle.setOwnerName(OwnerName);
			vehicle.setContact(Contact);
			vehicle.setAddress(Address);
			vehicle.setEmail(Email);
			vehicle.setPassword(Password);
			
			String r= vehicleDao.addVehicle(vehicle);
			if(r.equals(VehicleNo)){
				return "success";
				
			}else
			{
				return "error";
			}

		}
		
		
		
		@RequestMapping("/viewAllVehicle")
		public String viewAllVehicle(Model m)

		{
			List<Vehicle>allAccount=vehicleDao.getAllVehicle();
			m.addAttribute("list",allAccount);
			return"viewAllVehicle";
		}
		
		@RequestMapping(path="/deletes/{accids}",method=RequestMethod.GET)
		public RedirectView deleteVehicle(@PathVariable("accids") String VehicleNo,HttpServletRequest request)
	
		{
			vehicleDao.deleteVehicle(VehicleNo);
			
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/viewAllVehicle");
			return redirectView;
		}
		
		
		
		

		@RequestMapping("/viewOneVehicle")
		public String viewOne()
		{
			return"viewOneVehicle";
		}

		@RequestMapping(path="/afterViewOneVehicle",method=RequestMethod.POST)
		public String afterViewOneVehicle(Model model,HttpServletRequest request)

		{
			String VehicleNo=request.getParameter("vehicleNo");
			System.out.println(VehicleNo);
			vehicle =vehicleDao.getvehicle(VehicleNo);
			model.addAttribute("vehicle",vehicle);
			
			return"viewsOneVehicle";
			
		}

		
		
		
		
		@RequestMapping("/userLogin")
		public String userLogin()
		{
			return"userLogin";
			
		}
		
	@RequestMapping(path="/afterUserLogin",method=RequestMethod.POST)
	public String afterUserLogin(HttpServletRequest request)
	{
		String VehicleNo=request.getParameter("VehicleNo");
		String Password=request.getParameter("password");
		vehicle=vehicleDao.getvehicle(VehicleNo);
		String ab=vehicle.getVehicleNo();
		String bc=vehicle.getPassword();
		// if else condition for Login
		if(VehicleNo.equals(ab)&&Password.equals(bc))
		{
	
		return "userDash";
			
		}
		
		else
		{
			return"userLogin";
		}
			
		
	}
	
	
	
	

	@RequestMapping("/searchWorkLog")		
	public String searchWorkLog()
	
	{
		return"searchWorkLog";
		
	}
	
	@RequestMapping(path="/afterSearchWorkLog",method=RequestMethod.POST)
	
			public String afterSearchWorkLog(Model model,HttpServletRequest request)
	{   System.out.println("hi");
		String VehicleNo=request.getParameter("VehicleNo");
		List<WorkLog> worklog=workLogDao.searchWorkLog(VehicleNo);
		for(WorkLog c:worklog){}
		model.addAttribute("workLog", worklog);
		return"viewOneWorkLog";
	
	}
	
	
	
	@RequestMapping("/viewAllWorkLog")
	public String viewWorkLog(Model m) { //1 months expire
	    List<WorkLog> allWorkLog = workLogDao.getAllWorkLog();

	    LocalDate currentDate = LocalDate.now();
	    LocalDate nextMonth = currentDate.plusMonths(1);

	    // Iterate through allWorkLog to filter by due date
	    Iterator<WorkLog> iterator = allWorkLog.iterator();
	    while (iterator.hasNext()) {
	        WorkLog workLog = iterator.next();
	        String dueDate = workLog.getDueDate();
	        LocalDate dueDateLocal = LocalDate.parse(dueDate);
	        long daysDifference = ChronoUnit.DAYS.between(currentDate, dueDateLocal);
	        System.out.println("difference: " + daysDifference);
	        
	        // Check if the due date is within the range of next month or 30 days before
	        if (!(daysDifference >= 1 && daysDifference <= 30)) {
	            // Remove the work log from the list if it doesn't meet the criteria
	            iterator.remove();
	        }
	    }

	    m.addAttribute("list", allWorkLog);
	    return "viewAllWorkLog";
	}

	

	
		@RequestMapping("/viewAllWorkLogToUser") //view all work log at user dashbord
		public String viewAllWorkLog(Model m){
			
			String vno = vehicle.getVehicleNo();
			List<WorkLog>allworkLog=workLogDao.getAllWorkLog();
			List<WorkLog> filteredWorkLogs = new ArrayList<WorkLog>();
			 for (WorkLog workLog : allworkLog)
			 {
				if(workLog.getVehicleNo().equals(vno))
		    	{
		    		filteredWorkLogs.add(workLog);
		    	}
			 }
			
			m.addAttribute("list",filteredWorkLogs);
			return "viewAllWorkLogToUser";
	}
	
		@RequestMapping("/viewWorkLogToUser")
		public String viewOneWorkLog(Model m){   //  at user Dashbord workLog
			
			
			String vno = vehicle.getVehicleNo();
			List<WorkLog>allworkLog=workLogDao.getAllWorkLog();
		    List<WorkLog> filteredWorkLogs = new ArrayList<WorkLog>();
			 for (WorkLog workLog : allworkLog)
			 {
				if(workLog.getVehicleNo().equals(vno))
		    	{
		    		filteredWorkLogs.add(workLog);
		    	}
			 }
			//if(workLogDao.getVehicleNo()==allworkLog)
			m.addAttribute("list",filteredWorkLogs);
			return "viewAllWorkLogToUser";
	    	
		}
		
			 
	
	@RequestMapping("/viewExpiryWorkLog")   //View All expiry workLog
	 public String viewExpiryWorkLog(Model m)
	 {
		 
		String vno = vehicle.getVehicleNo();
		 List<WorkLog>allworkLog=workLogDao.getAllWorkLog();
		 
		 List<WorkLog> filteredWorkLogs = new ArrayList<WorkLog>();
		 for (WorkLog workLog : allworkLog)
		 {
			if(workLog.getVehicleNo().equals(vno))
	    	{
	    		filteredWorkLogs.add(workLog);
	    	}
		 }
		 
		    		m.addAttribute("list",filteredWorkLogs);
		   		 return"viewExpiryWorkLog";
		    		
		    	}

		 
				 
	
	@RequestMapping("/viewAllOneMonthWorkLog")
	public String viewAllOneMonthWorkLog(Model m) {                  //1 months expire at user dashboard
	    String vno = vehicle.getVehicleNo(); // Assuming vehicle object is available
	    List<WorkLog> allWorkLog = workLogDao.getAllWorkLog();
	    List<WorkLog> filteredWorkLogs = new ArrayList<WorkLog>();

	  

	    // Iterate through allWorkLog to filter by garage contact and due date
	    for (WorkLog workLog : allWorkLog) {
	        if (workLog.getVehicleNo().equals(vno)) {
	            // Check if the due date is within the range of next month or 30 days before
	        	 LocalDate currentDate = LocalDate.now();
	      	    LocalDate nextMonth = currentDate.plusMonths(1);
	            LocalDate dueDateLocal = LocalDate.parse(workLog.getDueDate());
	            long daysDifference = ChronoUnit.DAYS.between(currentDate, dueDateLocal);
	            if ((daysDifference >= 1  && daysDifference <= 30)) {
	            	 
	            
	            	 filteredWorkLogs.add(workLog);
	            }
	        }
	    }

	    m.addAttribute("list", filteredWorkLogs);
	    return "viewAllOneMonthWorkLog";
	}

	

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
	
	

	 
	 

	 
	


