package cuong.fa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cuong.fa.entities.LoaiSan;
import cuong.fa.page.PageAble;
import cuong.fa.repository.LoaiSanRepository;


@Service
public class LoaiSanServiceImpl implements LoaiSanService  {
	
	@Autowired
	private LoaiSanRepository loaiSanRepository;
	

	@Override
	@Transactional
	public List<LoaiSan> findAll() {
		return loaiSanRepository.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(LoaiSan loaiSan) {
		loaiSanRepository.saveOrUpdate(loaiSan);
	}

	@Override
	@Transactional
	public void delete(String maLoaiSan) {
		LoaiSan loaiSan = findById(maLoaiSan);
		if (loaiSan != null) {
			loaiSanRepository.delete(loaiSan);
		}
	}

	@Override
	@Transactional
	public LoaiSan findById(String maLoaiSan) {
		return loaiSanRepository.findById(maLoaiSan);
	}

	@Override
	@Transactional
	public List<LoaiSan> findWithPageAble(PageAble pageAble) {
		return loaiSanRepository.findWithPageAble(pageAble);
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = loaiSanRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

	@Override
	@Transactional
	public List<LoaiSan> search(String searchKey) {
		return loaiSanRepository.search(searchKey);
	}
}
