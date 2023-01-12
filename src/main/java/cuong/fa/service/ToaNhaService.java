package cuong.fa.service;

import java.util.List;

import cuong.fa.entities.ToaNha;
import cuong.fa.page.PageAble;

/**
 * @author hocuong
 *@since 1999/08/18
 *sdsds
 */
public interface ToaNhaService {

	List<ToaNha> findAll();

	void saveOrUpdate(ToaNha toaNha);

	void delete(String maToaNha);

	ToaNha findById(String maToaNha);

	List<ToaNha> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<ToaNha> search(String searchKey);

}