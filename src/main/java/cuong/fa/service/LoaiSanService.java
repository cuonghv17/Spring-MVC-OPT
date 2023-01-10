package cuong.fa.service;

import java.util.List;

import cuong.fa.entities.LoaiSan;
import cuong.fa.page.PageAble;

public interface LoaiSanService {

	List<LoaiSan> findAll();

	void saveOrUpdate(LoaiSan loaiSan);

	void delete(String maLoaiSan);

	LoaiSan findById(String maLoaiSan);

	List<LoaiSan> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<LoaiSan> search(String searchKey);

}