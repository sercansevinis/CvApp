package cvApp.MainApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cvApp.MainApp.model.Applicant;

@Repository
public class ApplicantRepository implements IApplicant
{
	@Autowired
	private EntityManager entityManager;

	@Override
	public Applicant findById(long id) {	
		return entityManager.find(Applicant.class, id);
	}

	@Override
	public void create(Applicant applicant) {
		entityManager.persist(applicant);
	}

	@Override
	public List<Applicant> findAll() {
		return entityManager.createQuery("from Applicant",Applicant.class).getResultList();

	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Applicant.class, id));
		
	}

	@Override
	public void update(Applicant applicant) {
		
		entityManager.merge(applicant);
	}

}
