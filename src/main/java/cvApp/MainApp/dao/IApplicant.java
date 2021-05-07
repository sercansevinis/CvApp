package cvApp.MainApp.dao;

import java.util.List;

import cvApp.MainApp.model.Applicant;

public interface IApplicant
{
	public Applicant findById(long id);
	
	public void create(Applicant applicant);
	
	public List<Applicant> findAll();
	
	public void delete(long id);
	
	public void update(Applicant applicant);
}
