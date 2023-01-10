package cuong.fa.service;

import java.util.List;

import cuong.fa.entities.TTDangKyThue;
import cuong.fa.page.PageAble;

public interface DangKyThueSanService {

	List<TTDangKyThue> findAll();

	void saveOrUpdate(TTDangKyThue tTDangKyThue);

	void delete(String maDK);

	TTDangKyThue findById(String maDK);

	List<TTDangKyThue> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<TTDangKyThue> search(String searchKey);

	List<TTDangKyThue> findSearchTenSan(String searchKey, PageAble pageAble);

}