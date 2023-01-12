package cuong.fa.service;

import java.util.List;

import cuong.fa.entities.TTPhiTrungCu;
import cuong.fa.page.PageAble;

/**
 * @author hocuong
 *@since 1999/08/18
 *sdsds
 */
public interface TTPhiTrungCuService {

	List<TTPhiTrungCu> findAll();

	void saveOrUpdate(TTPhiTrungCu tTPhiTrungCu);

	void delete(String maTT);

	TTPhiTrungCu findById(String maTT);

	List<TTPhiTrungCu> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<TTPhiTrungCu> search(String searchKey);

	List<TTPhiTrungCu> findSearchTenSan(String searchKey, PageAble pageAble);

}