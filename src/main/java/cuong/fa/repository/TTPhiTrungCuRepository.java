package cuong.fa.repository;

import java.util.List;

import cuong.fa.entities.TTPhiTrungCu;
import cuong.fa.page.PageAble;

/**
 * @author hocuong
 *@since 1999/08/18
 *sdsds
 */
public interface TTPhiTrungCuRepository {

	/**
	 * @return
	 */
	List<TTPhiTrungCu> findAll();

	void saveOrUpdate(TTPhiTrungCu tTPhiTrungCu);

	void delete(TTPhiTrungCu tTPhiTrungCu);

	TTPhiTrungCu findById(String maDK);

	List<TTPhiTrungCu> findWithPageAble(PageAble pageAble);

	long count();

	List<TTPhiTrungCu> search(String searchKey);

	List<TTPhiTrungCu> findSearchTenSan(String searchKey, PageAble pageAble);

}