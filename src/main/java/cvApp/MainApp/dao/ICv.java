package cvApp.MainApp.dao;



import java.util.List;

import cvApp.MainApp.model.Applicant;
import cvApp.MainApp.model.Cv;

public interface ICv
{
	public List<Cv> findAll();
	
	public Cv findById(long id);
	
	public List<Cv> findByApplicant(long id);
	
	public void create(Cv cv);
	
	public void delete(long id);
	
	public void deleteByPersonId(long id);
	
	public void update(Cv cv);
	

}
