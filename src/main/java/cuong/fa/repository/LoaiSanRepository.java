package cuong.fa.repository;

import java.util.List;

import cuong.fa.entities.LoaiSan;
import cuong.fa.page.PageAble;

public interface LoaiSanRepository {

	List<LoaiSan> findAll();

	void saveOrUpdate(LoaiSan loaiSan);

	void delete(LoaiSan loaiSan);

	LoaiSan findById(String maLoaiSan);

	List<LoaiSan> findWithPageAble(PageAble pageAble);

	long count();

	List<LoaiSan> search(String searchKey);

	

}