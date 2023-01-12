package cuong.fa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cuong.fa.entities.ToaNha;
import cuong.fa.page.PageAble;
import cuong.fa.repository.ToaNhaRepository;

@Service
public class ToaNhaServiceImpl implements ToaNhaService {

	@Autowired
	private ToaNhaRepository ToaNhaRepository;
	

	@Override
	@Transactional
	public List<ToaNha> findAll() {
		return ToaNhaRepository.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(ToaNha toaNha) {
		ToaNhaRepository.saveOrUpdate(toaNha);
	}

	@Override
	@Transactional
	public void delete(String maToaNha) {
		ToaNha toaNha = findById(maToaNha);
		if (toaNha != null) {
			ToaNhaRepository.delete(toaNha);
		}
	}

	@Override
	@Transactional
	public ToaNha findById(String maToaNha) {
		return ToaNhaRepository.findById(maToaNha);
	}

	@Override
	@Transactional
	public List<ToaNha> findWithPageAble(PageAble pageAble) {
		return ToaNhaRepository.findWithPageAble(pageAble);
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = ToaNhaRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

	@Override
	@Transactional
	public List<ToaNha> search(String searchKey) {
		return ToaNhaRepository.search(searchKey);
	}
}
