package cuong.fa.repository;

import java.util.List;

import cuong.fa.entities.TTDangKyThue;
import cuong.fa.page.PageAble;

public interface DangKyThueSanRepository {

	List<TTDangKyThue> findAll();

	void saveOrUpdate(TTDangKyThue tTDangKyThue);

	void delete(TTDangKyThue tTDangKyThue);

	TTDangKyThue findById(String maDK);

	List<TTDangKyThue> findWithPageAble(PageAble pageAble);

	long count();

	List<TTDangKyThue> search(String searchKey);

	List<TTDangKyThue> findSearchTenSan(String searchKey, PageAble pageAble);

}