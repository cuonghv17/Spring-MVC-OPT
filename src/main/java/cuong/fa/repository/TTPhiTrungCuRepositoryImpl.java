package cuong.fa.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cuong.fa.entities.TTPhiTrungCu;
import cuong.fa.page.PageAble;

@Repository
public class TTPhiTrungCuRepositoryImpl implements TTPhiTrungCuRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TTPhiTrungCu> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<TTPhiTrungCu> tTPhiTrungCus = session.createQuery("SELECT p FROM TTPhiTrungCu p", TTPhiTrungCu.class)
				.getResultList();
		return tTPhiTrungCus;
	}

	@Override
	public void saveOrUpdate(TTPhiTrungCu tTPhiTrungCu) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tTPhiTrungCu);
	}

	@Override
	public void delete(TTPhiTrungCu tTPhiTrungCu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(tTPhiTrungCu);
	}

	@Override
	public TTPhiTrungCu findById(String maDK) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(TTPhiTrungCu.class, maDK);
	}

	@Override
	public List<TTPhiTrungCu> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<TTPhiTrungCu> tTPhiTrungCus = session.createQuery("SELECT p FROM TTPhiTrungCu p ", TTPhiTrungCu.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return tTPhiTrungCus;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM TTPhiTrungCu p", Long.class).getSingleResult();
	}

	@Override
	public List<TTPhiTrungCu> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<TTPhiTrungCu> createQuery = session
				.createQuery("SELECT p FROM TTPhiTrungCu p where p.hoTenChuHo like :searchKey", TTPhiTrungCu.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<TTPhiTrungCu> tTPhiTrungCus = createQuery.getResultList();
		return tTPhiTrungCus;
	}

	@Override
	public List<TTPhiTrungCu> findSearchTenSan(String searchKey, PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		Query<TTPhiTrungCu> createQuery = session
				.createQuery("SELECT p FROM TTPhiTrungCu p JOIN ToaNha s ON p.toaNha.maToaNha = s.maToaNha where s.maToaNha like :searchKey", TTPhiTrungCu.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<TTPhiTrungCu> tTPhiTrungCus = createQuery
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return tTPhiTrungCus;
	}

}
