package cuong.fa.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cuong.fa.entities.LoaiSan;
import cuong.fa.entities.TTDangKyThue;
import cuong.fa.page.PageAble;
import cuong.fa.service.DangKyThueSanService;
import cuong.fa.service.LoaiSanService;

@Controller
@RequestMapping("/dangKyThueSan")
public class DangKyThueSanController {

	@Autowired
	private DangKyThueSanService dangKyThueSanService;

	@Autowired
	private LoaiSanService loaiSanServiceImpl;

	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<TTDangKyThue> tTDangKyThues = dangKyThueSanService.findWithPageAble(pageAble);
		model.addAttribute("tTDangKyThues", tTDangKyThues);
		model.addAttribute("totalPages", dangKyThueSanService.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/dangKyThueSan/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("dangKyThueForm", new TTDangKyThue());
		return "/dangKyThueSan/add";
	}

	@PostMapping("/save")
	public String addNewTTDangKyThue(@ModelAttribute(name = "dangKyThueForm") @Valid TTDangKyThue tTDangKyThue,
			BindingResult result) {

		if (result.hasErrors()) {
			return "/dangKyThueSan/add";
		}
		
		
		LocalDate localDate = LocalDate.now();
		tTDangKyThue.setNgayDatCoc(localDate);
		String maSB = tTDangKyThue.getLoaiSan().getMaLoaiSan();
		tTDangKyThue.setTienThanhToan((int) TTThanhToan(tTDangKyThue, maSB));
		dangKyThueSanService.saveOrUpdate(tTDangKyThue);
		return "redirect:/dangKyThueSan/list";
	}

	@GetMapping("/edit")
	public String showEditForm(Model model) {
		model.addAttribute("dangKyThueForm", new TTDangKyThue());
		
		return "/dangKyThueSan/edit";
	}

	@PostMapping("/editSave")
	public String addEditTTDangKyThue(@ModelAttribute(name = "dangKyThueForm") @Valid TTDangKyThue tTDangKyThue,
			BindingResult result ,RedirectAttributes redirectAttributes , Model model) {

		if (result.hasErrors()) {
			return "/dangKyThueSan/edit";
		}
		 TTDangKyThue tTDangKyThueSL = dangKyThueSanService.findById(tTDangKyThue.getMaDK());
			if(tTDangKyThue.getSoLuongSan()< tTDangKyThueSL.getSoLuongSan()) {
				
				model.addAttribute("qq","so luong update phai >= "+ tTDangKyThueSL.getSoLuongSan());
				
				return "/dangKyThueSan/edit";
			}
			
       

		if (tTDangKyThue.getTrangThai() == 1) {
			LocalDate localDate = LocalDate.now();
			tTDangKyThue.setNgayThanhToan(localDate);

		}
		if (tTDangKyThue.getTrangThai() == 2) {
			tTDangKyThue.setTienThanhToan(0);
			tTDangKyThue.setNgayThanhToan(null);

		}

		String maSB = tTDangKyThue.getLoaiSan().getMaLoaiSan();
		tTDangKyThue.setTienThanhToan((int) TTThanhToan(tTDangKyThue, maSB));
		redirectAttributes.addFlashAttribute("tt","update thanh cong");
		dangKyThueSanService.saveOrUpdate(tTDangKyThue);
	
		return "redirect:/dangKyThueSan/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "maDK") String maDK) {
		dangKyThueSanService.delete(maDK);
		return "redirect:/dangKyThueSan/list";
	}

	@RequestMapping("/update/{maDK}")
	public String update(@PathVariable(name = "maDK") String maDK, Model model) {
		TTDangKyThue tTDangKyThue = dangKyThueSanService.findById(maDK);
		model.addAttribute("dangKyThueForm", tTDangKyThue);
		return "/dangKyThueSan/edit";
	}

	@GetMapping("/search")
	public String search(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<TTDangKyThue> tTDangKyThues = dangKyThueSanService.search(searchKey);
		model.addAttribute("tTDangKyThues", tTDangKyThues);
		model.addAttribute("searchKey", searchKey);

		return "/dangKyThueSan/list";
	}

	@GetMapping("/searchTenSan")
	public String searchTen(Model model, @RequestParam(name = "searchKey") String searchKey,@RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		
			List<TTDangKyThue> tTDangKyThues = dangKyThueSanService.findSearchTenSan(searchKey, pageAble);

			model.addAttribute("tTDangKyThues", tTDangKyThues);
			model.addAttribute("searchKey", searchKey);
			model.addAttribute("totalPages", dangKyThueSanService.totalPages(pageAble));
			model.addAttribute("currentPage", page);

			return "/dangKyThueSan/list";
		

	}

	@ModelAttribute("loaiSans")
	public List<LoaiSan> showLoaiSan(Model model) {
//		List<LoaiSan> loaiSans = loaiSanServiceImpl.findAll();
//		model.addAttribute("loaiSans",loaiSans);
		return loaiSanServiceImpl.findAll();
	}

	public double TTThanhToan(TTDangKyThue tTDangKyThue, String maSB) {

		int TienTT = 0;
		LoaiSan loaiSan = loaiSanServiceImpl.findById(maSB);

		if (tTDangKyThue.getSoLuongSan() == 1) {
			TienTT = (int) ((loaiSan.getGiaThue() * tTDangKyThue.getSoLuongSan()) - tTDangKyThue.getTienDatCoc());
			return TienTT;
		}

		if (tTDangKyThue.getSoLuongSan() == 2) {
			TienTT = (int) (loaiSan.getGiaThue() - tTDangKyThue.getTienDatCoc() + (loaiSan.getGiaThue() * 90 / 100));
			return TienTT;
		}

		TienTT = (int) (loaiSan.getGiaThue() - tTDangKyThue.getTienDatCoc() + (loaiSan.getGiaThue() * 90 / 100));

		int TienTT1 = (int) (loaiSan.getGiaThue());
		if (tTDangKyThue.getSoLuongSan() == 3) {
			TienTT = (int) TienTT + (TienTT1 * 80 / 100);
			return TienTT;
		}

		TienTT = (int) (TienTT + (TienTT1 * 80 / 100));

		if (tTDangKyThue.getSoLuongSan() > 3) {
			for (int i = 4; i <= tTDangKyThue.getSoLuongSan(); i++) {
				int TienTT2 = (int) (TienTT1 * 80 / 100);
				TienTT = (int) TienTT + TienTT2;

			}
			return TienTT;
		}
		return TienTT;
	}

}
