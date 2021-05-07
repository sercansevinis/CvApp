package cvApp.MainApp.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cvApp.MainApp.model.Applicant;
import cvApp.MainApp.service.CVApplicationApplicantService;

@Component
public class CVApplicationValidator implements Validator {
	private boolean success=true;
	private Applicant applicant;
		
	public Applicant getApplicant() {
		return applicant;
	}


	@Autowired
	CVApplicationApplicantService service;
	@Override
	public boolean supports(Class<?> clazz) {

		return Applicant.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Applicant a=(Applicant)target;
		
		List<Applicant> list=service.findAllUsers();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getUserName().equals(a.getUserName()) && list.get(i).getPassword().equals(a.getPassword()))
			{
				applicant=list.get(i);
				success=true;
				break;
			}
			else {
				success=false;
				continue;	
			}
		}
		if(!success)
		{
			errors.rejectValue("password", "login.err");
		}
		
		
	}

}
