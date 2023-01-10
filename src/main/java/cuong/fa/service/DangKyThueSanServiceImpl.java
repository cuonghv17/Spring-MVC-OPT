package cuong.fa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cuong.fa.entities.TTDangKyThue;
import cuong.fa.page.PageAble;
import cuong.fa.repository.DangKyThueSanRepository;



@Service
public class DangKyThueSanServiceImpl implements DangKyThueSanService {
	
	@Autowired
	private DangKyThueSanRepository dangKyThueSanRepository;
	

	@Override
	@Transactional
	public List<TTDangKyThue> findAll() {
		return dangKyThueSanRepository.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(TTDangKyThue tTDangKyThue) {
		dangKyThueSanRepository.saveOrUpdate(tTDangKyThue);
	}

	@Override
	@Transactional
	public void delete(String maDK) {
		TTDangKyThue TTDangKyThue = findById(maDK);
		if (TTDangKyThue != null) {
			dangKyThueSanRepository.delete(TTDangKyThue);
		}
	}

	@Override
	@Transactional
	public TTDangKyThue findById(String maDK) {
		return dangKyThueSanRepository.findById(maDK);
	}

	@Override
	@Transactional
	public List<TTDangKyThue> findWithPageAble(PageAble pageAble) {
		return dangKyThueSanRepository.findWithPageAble(pageAble);
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = dangKyThueSanRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

	@Override
	@Transactional
	public List<TTDangKyThue> search(String searchKey) {
		return dangKyThueSanRepository.search(searchKey);
	}
	@Override
	@Transactional
	public List<TTDangKyThue> findSearchTenSan(String searchKey, PageAble pageAble) {
		return dangKyThueSanRepository.findSearchTenSan(searchKey ,pageAble);
	}
}
