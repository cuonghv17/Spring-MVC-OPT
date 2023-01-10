package cuong.fa.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cuong.fa.entities.LoaiSan;
import cuong.fa.page.PageAble;


@Repository
public class LoaiSanRepositoryImpl implements LoaiSanRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<LoaiSan> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<LoaiSan> loaiSans = session.createQuery("SELECT p FROM LoaiSan p", LoaiSan.class).getResultList();
		return loaiSans;
	}

	@Override
	public void saveOrUpdate(LoaiSan loaiSan) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(loaiSan);
	}

	@Override
	public void delete(LoaiSan loaiSan) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(loaiSan);
	}

	@Override
	public LoaiSan findById(String maLoaiSan) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(LoaiSan.class, maLoaiSan);
	}

	@Override
	public List<LoaiSan> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<LoaiSan> loaiSans = session.createQuery("SELECT p FROM LoaiSan p ", LoaiSan.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return loaiSans;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM LoaiSan p", Long.class).getSingleResult();
	}
	@Override
	public List<LoaiSan> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<LoaiSan> createQuery = session.createQuery("SELECT p FROM LoaiSan p where p.tenLoaiSan like :searchKey",
				LoaiSan.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<LoaiSan> loaiSans = createQuery.getResultList();
		return loaiSans;
	}
	
	
}
