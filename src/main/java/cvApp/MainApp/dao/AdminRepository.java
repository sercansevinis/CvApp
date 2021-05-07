package cvApp.MainApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cvApp.MainApp.model.Admin;

@Repository
public class AdminRepository implements IAdmin
{
	@Autowired
	EntityManager entityManager;

	@Override
	public Admin findById(long id) {
		return entityManager.find(Admin.class, id);
	}

	@Override
	public void create(Admin admin) {
		entityManager.persist(admin);
		
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Admin",Admin.class).getResultList();

	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Admin.class, id));
		
	}

	@Override
	public void update(Admin applicant) {
		entityManager.merge(applicant);		
	}
}
