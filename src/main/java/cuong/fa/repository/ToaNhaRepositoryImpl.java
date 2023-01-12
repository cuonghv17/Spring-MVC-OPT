package cuong.fa.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cuong.fa.entities.ToaNha;
import cuong.fa.page.PageAble;

@Repository
public class ToaNhaRepositoryImpl implements ToaNhaRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ToaNha> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<ToaNha> toaNhas = session.createQuery("SELECT p FROM ToaNha p", ToaNha.class).getResultList();
		return toaNhas;
	}

	@Override
	public void saveOrUpdate(ToaNha toaNha) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(toaNha);
	}

	@Override
	public void delete(ToaNha toaNha) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(toaNha);
	}

	@Override
	public ToaNha findById(String maToaNha) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(ToaNha.class, maToaNha);
	}

	@Override
	public List<ToaNha> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<ToaNha> toaNhas = session.createQuery("SELECT p FROM ToaNha p ", ToaNha.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return toaNhas;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM ToaNha p", Long.class).getSingleResult();
	}
	@Override
	public List<ToaNha> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<ToaNha> createQuery = session.createQuery("SELECT p FROM ToaNha p where p.tenToaNha like :searchKey",
				ToaNha.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<ToaNha> toaNhas = createQuery.getResultList();
		return toaNhas;
	}
}
