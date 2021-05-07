package cvApp.MainApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cvApp.MainApp.model.Applicant;
import cvApp.MainApp.model.Cv;

@Repository
public class CvRepository implements ICv {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Cv> findAll() {
		return entityManager.createQuery("from Cv",Cv.class).getResultList();
	}

	@Override
	public Cv findById(long id) {
		return entityManager.find(Cv.class, id);
	}

	@Override
	public List<Cv> findByApplicant(long id) {
		return entityManager.createQuery("from Cv WHERE applicant.id = :id", Cv.class).setParameter("id", id).getResultList();
	}

	@Override
	public void create(Cv cv) {
		entityManager.persist(cv);
		
	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Cv.class, id));
		
	}

	@Override
	public void deleteByPersonId(long id) {
		entityManager.createQuery("DELETE FROM Cv WHERE applicant.id = :id").setParameter("id", id).executeUpdate();
		
	}
	
	@Override
	public void update(Cv cv) {
		entityManager.merge(cv);
	}

}
