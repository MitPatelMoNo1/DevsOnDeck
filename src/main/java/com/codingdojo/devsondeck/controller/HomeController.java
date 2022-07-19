package com.codingdojo.devsondeck.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.devsondeck.models.Devs;
import com.codingdojo.devsondeck.models.Job;
import com.codingdojo.devsondeck.models.LoginUser;
import com.codingdojo.devsondeck.models.Org;
import com.codingdojo.devsondeck.models.OrgUser;
import com.codingdojo.devsondeck.models.User;
import com.codingdojo.devsondeck.service.DevService;
import com.codingdojo.devsondeck.service.JobService;
import com.codingdojo.devsondeck.service.OrgService;
import com.codingdojo.devsondeck.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ;
	@Autowired
	private DevService devServ;
	@Autowired
	private OrgService orgServ;
	@Autowired
	private JobService jobServ;
	
	
	@GetMapping("/devs/register")
	public String devs(Model model) {
		model.addAttribute("newUser", new User());
		 model.addAttribute("newLogin", new LoginUser());
	     return "Register.jsp";
	}
	
	@GetMapping("/devs/login")
	public String devslogin(Model model) {
		model.addAttribute("newUser", new User());
		 model.addAttribute("newLogin", new LoginUser());
	     return "LoginDevs.jsp";
	}
	@PostMapping("/devs/register")
	public String devRegister(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		System.out.println("Hello");
		User user = userServ.register(newUser, result);
	     
	     if(result.hasErrors()) {
	    	 System.out.println(result.getAllErrors());
	         model.addAttribute("newLogin", new LoginUser());
	         return "Register.jsp";
	     }
	     
	     session.setAttribute("userId", user.getId());
	 
	     return "redirect:/devs/login";
	 }
	
	@PostMapping("/devs/login")
	public String devLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
	     
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "LoginDevs.jsp";
	     }
	     
	     session.setAttribute("userId", user.getId());
	 
	     return "redirect:/devs/skills";
	 }
	
	@GetMapping("/orgs/register")
	public String orgs(Model model) {
		model.addAttribute("newOrg", new Org());
		model.addAttribute("newLogin", new OrgUser());
		return "OrgRegister.jsp";
	}
	
	@GetMapping("/orgs/login")
	public String orgslogin(Model model) {
		model.addAttribute("newOrg", new Org());
		 model.addAttribute("newLogin", new OrgUser());
	     return "OrgLogin.jsp";
	}
	
	@PostMapping("/orgs/register")
	public String orgRegister(@Valid @ModelAttribute("newOrg") Org newOrg, BindingResult result, Model model, HttpSession session) {
		Org org = orgServ.register(newOrg, result);
	     
	     if(result.hasErrors()) {
	    	 System.out.println(result.getAllErrors());
	         model.addAttribute("newLogin", new OrgUser());
	         return "OrgRegister.jsp";
	     }
	     
	     session.setAttribute("userId", org.getId());
	 
	     return "redirect:/orgs/login";
	 }
	
	@PostMapping("/orgs/login")
	public String orgLogin(@Valid @ModelAttribute("newLogin") OrgUser newOrgLogin, BindingResult result, Model model, HttpSession session) {
		Org org = orgServ.login(newOrgLogin, result);
	     
	     if(result.hasErrors()) {
	         model.addAttribute("newOrg", new Org());
	         return "OrgsLogin.jsp";
	     }
	     
	     session.setAttribute("userId", org.getId());
	 
	     return "redirect:/orgs/dashboard";
	 }
	
	 @GetMapping("/orgs/dashboard")
	 public String welcome(HttpSession session, Model model) {
		 if(session.getAttribute("userId") == null) {
			 return "redirect:/login";
		 }
		 Long userId = (Long) session.getAttribute("userId");
		 model.addAttribute("org", orgServ.findById(userId));
		 model.addAttribute("jobService", jobServ.all());
		 model.addAttribute("devService", devServ.all());
		 
		 return "dashboard.jsp";
	 }
	 
	 @GetMapping("/jobs/new")
	 	public String createJob(@ModelAttribute("job") Job job, Model model, HttpSession session) {
		
		 User user= userServ.findById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user)	;	 
		
		return "NewJob.jsp";
	 }
	 
	 @PostMapping("/jobs")
	    public String createJob(@Valid @ModelAttribute("job") Job job, BindingResult result, HttpSession session) {

    	if (result.hasErrors()) {
 		return "NewJob.jsp";
    	}
    	User user = userServ.findById((Long)session.getAttribute("userId"));
    	job.setUser(user);
	    	jobServ.create(job);
	    	
	    	return "redirect:/orgs/dashboard";
	    } 
	
	 @GetMapping("/jobs/{id}")
	 public String showJob(Model model, @PathVariable("id") Long id, HttpSession session) {
		 if(session.getAttribute("userId")== null) {
			 return "redirect:/orgs/dashboard";
		 }
		 
		 Job job = jobServ.findById(id);
		 model.addAttribute("job", job);
		 model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
		 model.addAttribute("devService", devServ.all());
		 
		 return "job.jsp";
	 }
	 
	  @GetMapping("/jobs/{id}/edit")
	    public String edit(Model model, @PathVariable("id") Long id, HttpSession session) {
	    	if(session.getAttribute("userId") == null) {
	    		return "redirect:/orgs/dashboard";
	    	}
	    	Job job = jobServ.findById(id);
	    	model.addAttribute("job", job);
	    	
	    	return "jobEdit.jsp";
	    }
	 
	 @PutMapping("/jobs/{id}")
	    public String editShow(@Valid @ModelAttribute("job") Job job, BindingResult result, Model model) {
	    	if (result.hasErrors()) {
	    		return "jobEdit.jsp";
	    	}
	    	jobServ.update(job);
	    	return "redirect:/orgs/dashboard";
	    }
	    
	    @DeleteMapping("/jobs/{id}")
	    public String destroy(@PathVariable("id") Job job, HttpSession session) {
	    	
	    	if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
	        jobServ.deleteJob(job);
	        return "redirect:/orgs/dashboard";
	    }
	    
	    @GetMapping("/devs/skills")
	    public String createDev(@ModelAttribute("dev") Devs dev, Model model, HttpSession session) {
			
			 User user= userServ.findById((Long)session.getAttribute("userId"));
			model.addAttribute("user", user);	 
			
			return "NewDev.jsp";
		 }
	    
	    @PostMapping("/devs")
	    public String createDev(@Valid @ModelAttribute("dev") Devs dev, BindingResult result, HttpSession session) {

    	if (result.hasErrors()) {
 		return "NewDev.jsp";
    	}
    	User user = userServ.findById((Long)session.getAttribute("userId"));
    	dev.setUser(user);
	    	devServ.create(dev);
	    	
	    	return "redirect:/orgs/login";
	    } 
	    
	    @GetMapping("/devs/{id}")
	 public String showDev(Model model, @PathVariable("id") Long id, HttpSession session) {
		 if(session.getAttribute("userId")== null) {
			 return "redirect:/orgs/dashboard";
		 }
		 
		 Devs dev = devServ.findById(id);
		 model.addAttribute("dev", dev);
		 model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
		 return "dev.jsp";
	 }
	    
@DeleteMapping("/devs/{id}")
	    public String destroyDev(@PathVariable("id") Devs dev, HttpSession session) {
	    	
	    	if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
	        devServ.deleteDev(dev);
	        return "redirect:/orgs/dashboard";
	    }
	 
	 @GetMapping("/logout")
	public String logout(HttpSession session) {
	 
	 session.invalidate();
	    return "redirect:/orgs/login";
	}
 
	
}

