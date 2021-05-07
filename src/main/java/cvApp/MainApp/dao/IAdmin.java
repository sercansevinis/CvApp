package cvApp.MainApp.dao;

import java.util.List;

import cvApp.MainApp.model.Admin;

public interface IAdmin 
{
	public Admin findById(long id);
	
	public void create(Admin applicant);
	
	public List<Admin> findAll();
	
	public void delete(long id);
	
	public void update(Admin applicant);
}


