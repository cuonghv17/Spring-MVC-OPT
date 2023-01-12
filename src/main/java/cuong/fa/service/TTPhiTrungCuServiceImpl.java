package cuong.fa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cuong.fa.entities.TTPhiTrungCu;
import cuong.fa.page.PageAble;
import cuong.fa.repository.TTPhiTrungCuRepository;

@Service
public class TTPhiTrungCuServiceImpl implements TTPhiTrungCuService {
	
	@Autowired
	private TTPhiTrungCuRepository ttPhiTrungCuRepository;
	

	@Override
	@Transactional
	public List<TTPhiTrungCu> findAll() {
		return ttPhiTrungCuRepository.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(TTPhiTrungCu tTPhiTrungCu) {
		ttPhiTrungCuRepository.saveOrUpdate(tTPhiTrungCu);
	}

	@Override
	@Transactional
	public void delete(String maTT) {
		TTPhiTrungCu tTPhiTrungCu = findById(maTT);
		if (tTPhiTrungCu != null) {
			ttPhiTrungCuRepository.delete(tTPhiTrungCu);
		}
	}

	@Override
	@Transactional
	public TTPhiTrungCu findById(String maTT) {
		return ttPhiTrungCuRepository.findById(maTT);
	}

	@Override
	@Transactional
	public List<TTPhiTrungCu> findWithPageAble(PageAble pageAble) {
		return ttPhiTrungCuRepository.findWithPageAble(pageAble);
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = ttPhiTrungCuRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

	@Override
	@Transactional
	public List<TTPhiTrungCu> search(String searchKey) {
		return ttPhiTrungCuRepository.search(searchKey);
	}
	@Override
	@Transactional
	public List<TTPhiTrungCu> findSearchTenSan(String searchKey, PageAble pageAble) {
		return ttPhiTrungCuRepository.findSearchTenSan(searchKey ,pageAble);
	}

}
