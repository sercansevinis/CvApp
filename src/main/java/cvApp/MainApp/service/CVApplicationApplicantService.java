package cvApp.MainApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvApp.MainApp.dao.AdminRepository;
import cvApp.MainApp.dao.ApplicantRepository;
import cvApp.MainApp.dao.CvRepository;
import cvApp.MainApp.model.Admin;
import cvApp.MainApp.model.Applicant;
import cvApp.MainApp.model.Cv;


@Service
@Transactional
public class CVApplicationApplicantService 
{
	@Autowired
	ApplicantRepository applicantRepo;
	
	@Autowired
	CvRepository cvRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	public List<Applicant> findAllUsers()
	{
		return applicantRepo.findAll();
	}
	
	public Applicant findPersonById(long id)
	{
		return applicantRepo.findById(id);
	}
	
	public List<Cv> findAllCvs()
	{
		return cvRepo.findAll();
	}
	
	public Cv findCvById(long id)
	{
		return cvRepo.findById(id);
	}
	
	public void createPerson(Applicant person)
	{
		applicantRepo.create(person);
	}
	
	public void deleteUser(long id)
	{
		cvRepo.deleteByPersonId(id);
		applicantRepo.delete(id);
	}
	
	public void createCv(Cv cv)
	{
		cvRepo.create(cv);
	}
	
	public void deleteCv(long id)
	{
		cvRepo.delete(id);
	}
	
	public void updateApplicant(Applicant applicant)
	{
		applicantRepo.update(applicant);
	}
	
	public void updateCv(Cv cv)
	{
		cvRepo.update(cv);
	}
	
	public Admin findAdminByID(long id)
	{
		return adminRepo.findById(id);
	}
	
	public void createAdmin(Admin admin)
	{
		adminRepo.create(admin);
	}
	public List<Admin> findAllAdmins()
	{
		return adminRepo.findAll();
	}
	
	public void deleteAdmin(long id)
	{
		adminRepo.delete(id);
	}
	public void updateAdmin(Admin admin)
	{
		adminRepo.update(admin);
	}
	
	
	
	
	
}
