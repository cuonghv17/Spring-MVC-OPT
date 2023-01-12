package cuong.fa.repository;

import java.util.List;

import cuong.fa.entities.ToaNha;
import cuong.fa.page.PageAble;

/**
 * @author hocuong
 *@since 1999/08/18
 *sdsds
 */
public interface ToaNhaRepository {

	List<ToaNha> findAll();

	void saveOrUpdate(ToaNha toaNha);

	void delete(ToaNha toaNha);

	ToaNha findById(String maToaNha);

	List<ToaNha> findWithPageAble(PageAble pageAble);

	long count();

	List<ToaNha> search(String searchKey);

}