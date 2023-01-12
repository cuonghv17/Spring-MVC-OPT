package cuong.fa.controller;

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

import cuong.fa.entities.TTPhiTrungCu;
import cuong.fa.entities.ToaNha;
import cuong.fa.page.PageAble;
import cuong.fa.service.TTPhiTrungCuService;
import cuong.fa.service.ToaNhaService;

@Controller
@RequestMapping("/ttPhiTrungCu")
public class TTPhiTrungCuController {
	
	@Autowired
	private TTPhiTrungCuService ttPhiTrungCuService;

	@Autowired
	private ToaNhaService toaNhaService;

	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<TTPhiTrungCu> tTPhiTrungCus = ttPhiTrungCuService.findWithPageAble(pageAble);
		model.addAttribute("tTPhiTrungCus", tTPhiTrungCus);
		model.addAttribute("totalPages", ttPhiTrungCuService.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/ttPhiTrungCu/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("ttPhiTrungCuForm", new TTPhiTrungCu());
		return "/ttPhiTrungCu/add";
	}

	@PostMapping("/save")
	public String addNewTTPhiTrungCu(@ModelAttribute(name = "ttPhiTrungCuForm") @Valid TTPhiTrungCu tTPhiTrungCu,
			BindingResult result,Model model) {

		if (result.hasErrors()) {
			return "/ttPhiTrungCu/add";
		}
		
		
		tTPhiTrungCu.setTongTien((int) TongTien(tTPhiTrungCu));
		ttPhiTrungCuService.saveOrUpdate(tTPhiTrungCu);
		return "redirect:/ttPhiTrungCu/list";
	}

	@GetMapping("/edit")
	public String showEditForm(Model model) {
		model.addAttribute("ttPhiTrungCuForm", new TTPhiTrungCu());
		
		return "/ttPhiTrungCu/edit";
	}

	@PostMapping("/editSave")
	public String addEditTTPhiTrungCu(@ModelAttribute(name = "ttPhiTrungCuForm") @Valid TTPhiTrungCu tTPhiTrungCu,
			BindingResult result ,RedirectAttributes redirectAttributes , Model model) {

		if (result.hasErrors()) {
			return "/ttPhiTrungCu/edit";
		}
		
		 TTPhiTrungCu tTDangKyThueSL = ttPhiTrungCuService.findById(tTPhiTrungCu.getMaTT());
			if(tTPhiTrungCu.getSoThang()< tTDangKyThueSL.getSoThang()) {
				
				model.addAttribute("qq","so thang update phai >= "+ tTDangKyThueSL.getSoThang());
				
				return "/ttPhiTrungCu/edit";
			}
			
		redirectAttributes.addFlashAttribute("tt","“Update thong tin thu phi chung cu thanh cong");

		tTPhiTrungCu.setTongTien((int) TongTien(tTPhiTrungCu));
		ttPhiTrungCuService.saveOrUpdate(tTPhiTrungCu);
	
		return "redirect:/ttPhiTrungCu/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "maTT") String maTT) {
		ttPhiTrungCuService.delete(maTT);
		return "redirect:/ttPhiTrungCu/list";
	}

	@RequestMapping("/update/{maTT}")
	public String update(@PathVariable(name = "maTT") String maTT, Model model) {
		TTPhiTrungCu tTPhiTrungCu = ttPhiTrungCuService.findById(maTT);
		model.addAttribute("ttPhiTrungCuForm", tTPhiTrungCu);
		return "/ttPhiTrungCu/edit";
	}

	@GetMapping("/search")
	public String search(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<TTPhiTrungCu> tTPhiTrungCus = ttPhiTrungCuService.search(searchKey);
		model.addAttribute("tTPhiTrungCus", tTPhiTrungCus);
		model.addAttribute("searchKey", searchKey);

		return "/ttPhiTrungCu/list";
	}

	@GetMapping("/searchTenSan")
	public String searchTen(Model model, @RequestParam(name = "searchKey") String searchKey,@RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		
			List<TTPhiTrungCu> tTPhiTrungCus = ttPhiTrungCuService.findSearchTenSan(searchKey, pageAble);

			model.addAttribute("tTPhiTrungCus", tTPhiTrungCus);
			model.addAttribute("searchKey", searchKey);
			model.addAttribute("totalPages", ttPhiTrungCuService.totalPages(pageAble));
			model.addAttribute("currentPage", page);

			return "/ttPhiTrungCu/list";
		

	}

	@ModelAttribute("toaNhas")
	public List<ToaNha> showLoaiSan(Model model) {
//		List<LoaiSan> loaiSans = toaNhaServiceImpl.findAll();
//		model.addAttribute("loaiSans",loaiSans);
		return toaNhaService.findAll();
	}

	public double TongTien(TTPhiTrungCu ttPhiTrungCu) {
		
		

		int TienTT = 0;
		
		if(ttPhiTrungCu.getSoThang()<=3) {
			TienTT = ttPhiTrungCu.getDienTich() * ttPhiTrungCu.getSoThang() * 11000 ;
			if ((ttPhiTrungCu.getngayDong()).compareTo(ttPhiTrungCu.getThangBD())>0 ) {
				TienTT=TienTT+100000;
				return TienTT;
			}
		return TienTT;
		}
		TienTT = ttPhiTrungCu.getDienTich() * 3 * 11000 ;
		if (ttPhiTrungCu.getSoThang() > 3 ) {
			for (int i = 4; i <= ttPhiTrungCu.getSoThang(); i++) {
				int TienTT2 =(int)( ttPhiTrungCu.getDienTich() * ttPhiTrungCu.getSoThang() * 11000 * 90/100);
				
				TienTT = (int) TienTT + TienTT2;
				

			}
			if ((ttPhiTrungCu.getngayDong()).compareTo(ttPhiTrungCu.getThangBD())>0 ) {
				TienTT=TienTT+100000 ;
				return TienTT;
			}
			return TienTT;
		}
		
		
		
		
		

		return TienTT;

		
	}

	

}
