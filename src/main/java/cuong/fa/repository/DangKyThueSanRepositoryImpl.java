package cuong.fa.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cuong.fa.entities.TTDangKyThue;
import cuong.fa.page.PageAble;

@Repository
public class DangKyThueSanRepositoryImpl implements DangKyThueSanRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TTDangKyThue> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<TTDangKyThue> tTDangKyThues = session.createQuery("SELECT p FROM TTDangKyThue p", TTDangKyThue.class)
				.getResultList();
		return tTDangKyThues;
	}

	@Override
	public void saveOrUpdate(TTDangKyThue tTDangKyThue) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tTDangKyThue);
	}

	@Override
	public void delete(TTDangKyThue tTDangKyThue) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(tTDangKyThue);
	}

	@Override
	public TTDangKyThue findById(String maDK) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(TTDangKyThue.class, maDK);
	}

	@Override
	public List<TTDangKyThue> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<TTDangKyThue> tTDangKyThues = session.createQuery("SELECT p FROM TTDangKyThue p ", TTDangKyThue.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return tTDangKyThues;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM TTDangKyThue p", Long.class).getSingleResult();
	}

	@Override
	public List<TTDangKyThue> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<TTDangKyThue> createQuery = session
				.createQuery("SELECT p FROM TTDangKyThue p where p.tenKH like :searchKey", TTDangKyThue.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<TTDangKyThue> tTDangKyThues = createQuery.getResultList();
		return tTDangKyThues;
	}

	@Override
	public List<TTDangKyThue> findSearchTenSan(String searchKey, PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		Query<TTDangKyThue> createQuery = session
				.createQuery("SELECT p FROM TTDangKyThue p JOIN LoaiSan s ON p.loaiSan.maLoaiSan = s.maLoaiSan where s.tenLoaiSan like :searchKey", TTDangKyThue.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<TTDangKyThue> tTDangKyThues = createQuery
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return tTDangKyThues;
	}

}
