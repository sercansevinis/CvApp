package cvApp.MainApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cvApp.MainApp.model.Admin;
import cvApp.MainApp.model.Applicant;
import cvApp.MainApp.model.Cv;
import cvApp.MainApp.service.CVApplicationApplicantService;
import cvApp.MainApp.validator.CVApplicationAdminValidator;
import cvApp.MainApp.validator.CVApplicationValidator;

@Controller
public class CVApplicationController {
	
	@Autowired
	CVApplicationValidator applicantValidator;
	
	@Autowired
	CVApplicationAdminValidator adminValidator;
	
	@Autowired
	CVApplicationApplicantService service;
	
	@RequestMapping(value="/display-form", method=RequestMethod.GET)
	public ModelAndView displayForm()
	{
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("applicant", new Applicant());
		
		return mv;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView processForm(@Valid @ModelAttribute("applicant") Applicant applicant,BindingResult result)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("applicant", applicant);
		mv.addObject("cv", new Cv());
		
		applicantValidator.validate(applicant, result);
		if(result.hasErrors())
		{
			mv.setViewName("login");
		}
		else
		{
			mv.setViewName("user");
			Applicant enteredUser=applicantValidator.getApplicant();
			service.createPerson(enteredUser);
			mv.addObject("user", service.findPersonById(enteredUser.getId()));
		}
		
		return mv;
		
	}
	
	@RequestMapping(value="/display-admin-form", method=RequestMethod.GET)
	public ModelAndView displayAdminForm()
	{
		ModelAndView mv=new ModelAndView("login-admin");
		mv.addObject("admin", new Admin());
		
		return mv;
	}
	
	@RequestMapping(value="/login-admin", method=RequestMethod.POST)
	public ModelAndView processAdminForm(@Valid @ModelAttribute("admin") Admin admin,BindingResult result)
	{
		ModelAndView mv=new ModelAndView("adminPage");
		mv.addObject("admin", admin);
		mv.addObject("applicant", new Applicant());
		
		adminValidator.validate(admin, result);
		if(result.hasErrors())
		{
			mv.setViewName("login-admin");
		}
		else
		{
			Admin enteredAdmin=adminValidator.getAdmin();
			service.createAdmin(enteredAdmin);
			Applicant.numberOfApplicants++;
			mv.addObject("applicants", service.findAllUsers());
		}
		
		return mv;
		
	}
	
	@RequestMapping(value="/applicant/{id}", method = RequestMethod.GET)
	public ModelAndView viewCvByAdmin(@PathVariable long id)
	{
			ModelAndView mv=new ModelAndView("admin-view-cv");
			Applicant applicant=service.findPersonById(id);
			mv.addObject("applicant",applicant);
			
			return mv;
}
	
	
	@RequestMapping(value="/applicant/cv/{id}", method=RequestMethod.GET)
	public ModelAndView cvForm(@PathVariable long id)
	{
		ModelAndView mv=new ModelAndView("create-cv");
		mv.addObject("cv", new Cv());
		Applicant a=service.findPersonById(id);
		mv.addObject("applicant",a);
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/applicant/cv/add", method=RequestMethod.POST)
	public ModelAndView addCV(@Valid @ModelAttribute Cv cv,BindingResult result)
	{
		ModelAndView mv=new ModelAndView("user");
		
		if(result.hasErrors())
		{
			mv.setViewName("create-cv");
			mv.addObject("cv",cv);
		}
		else
		{
			service.createCv(cv);
			mv.addObject("cv", new Cv());
		}
		
		Applicant applicant=service.findPersonById(cv.getApplicant().getId());
		mv.addObject("user",applicant);
		
		return mv;
	}
	@RequestMapping(value="/applicant/cv/delete/{uid}/{cid}")
	public ModelAndView deleteCv(@PathVariable long uid, @PathVariable long cid)
	{
		ModelAndView mv=new ModelAndView("user");
		
		service.deleteCv(cid);
		Applicant applicant=service.findPersonById(uid);
		mv.addObject("user",applicant);
		
		return mv;
	}
	
	@RequestMapping(value="/applicant/cv/update/{uid}/{cid}")
	public ModelAndView updateCv(@PathVariable long uid, @PathVariable long cid)
	{
		ModelAndView mv=new ModelAndView("update-cv");
		
		Cv cv=service.findCvById(cid);
		
		Applicant applicant=service.findPersonById(uid);
		
		mv.addObject("cv",cv);
		
		mv.addObject("applicant",applicant);
		
		
		return mv;
	}
	
	@RequestMapping(value="/update/Cv/{id}", method=RequestMethod.POST)
	public ModelAndView processUpdateForm(@Valid @ModelAttribute("cv") Cv cv,BindingResult result,@PathVariable long id)
	{
		ModelAndView mv=new ModelAndView("user");
		mv.addObject("cv", cv);
		
		if(result.hasErrors())
		{
			mv.setViewName("update-cv");
		}
		else
		{
			mv.setViewName("user");
			service.updateCv(cv);
			Applicant updatedUser=cv.getApplicant();
			mv.addObject("user", service.findPersonById(updatedUser.getId()));
		}
		
		return mv;
		
	}
	
	@RequestMapping(value="/view/cv/{id}", method=RequestMethod.GET)
	public ModelAndView viewCv(@PathVariable long id)
	{
		ModelAndView mv=new ModelAndView("view-cv");
		
		Cv cv=service.findCvById(id);
		mv.addObject("cv",cv);
		Applicant applicant=cv.getApplicant();
		mv.addObject("applicant",applicant);
		
		return mv;
	}
	
	@RequestMapping(value="/create-user", method=RequestMethod.GET)
	public ModelAndView displayCreateUser()
	{
		ModelAndView mv=new ModelAndView("create-user");
		
		mv.addObject("applicant", new Applicant());
		
		return mv;
	}
	
	@RequestMapping(value="/create/user", method=RequestMethod.POST)
	public ModelAndView createUser(@Valid @ModelAttribute("applicant") Applicant applicant, BindingResult result)
	{
		ModelAndView mv=new ModelAndView("login");

		
		if(result.hasErrors())
		{
			mv.setViewName("create-user");
		}
		else
		{
			service.createPerson(applicant);
			mv.addObject("applicant",new Applicant());
		}
				
		return mv;
	}
	
	
	
	
	
	
	

}
