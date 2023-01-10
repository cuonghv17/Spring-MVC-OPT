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

import cuong.fa.entities.LoaiSan;
import cuong.fa.page.PageAble;
import cuong.fa.service.LoaiSanService;




@Controller
@RequestMapping("/loaiSan")
public class LoaiSanController {
	@Autowired
	private LoaiSanService loaiSanService;
	
	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<LoaiSan> loaiSans = loaiSanService.findWithPageAble(pageAble);
		model.addAttribute("loaiSans", loaiSans);
		model.addAttribute("totalPages", loaiSanService.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/loaiSan/list";
	}

	@GetMapping("/addLoaiSan")
	public String showAddForm(Model model) {
		model.addAttribute("loaiSanForm", new LoaiSan());
		return "/loaiSan/addLoaiSan";
	}
	
//	@PostMapping("/save")
//	public String addNewLoaiSan(@ModelAttribute(name = "loaiSanForm") @Valid LoaiSan loaiSan,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			return "/loaiSan/addLoaiSan";
//		}
//		loaiSanService.saveOrUpdate(loaiSan);
//		return "redirect:/loaiSan/list";
//	}

	@PostMapping("/save")
	public String addNewTTDangKyThue(@ModelAttribute(name = "loaiSanForm") @Valid LoaiSan loaiSan,
			BindingResult result) {
		
		
		if (result.hasErrors()) {
			return "/loaiSan/addLoaiSan";
		}
		
		loaiSanService.saveOrUpdate(loaiSan);
		return "redirect:/loaiSan/list";
	}
	
	
	

	
	@GetMapping("/delete")
	public String delete(@RequestParam(name = "maLoaiSan") String maLoaiSan) {
		loaiSanService.delete(maLoaiSan);
		return "redirect:/loaiSan/list";
	}

	@RequestMapping("/update/{maLoaiSan}")
	public String update(@PathVariable(name = "maLoaiSan") String maLoaiSan, Model model) {
		LoaiSan loaiSan = loaiSanService.findById(maLoaiSan);
		model.addAttribute("loaiSanForm", loaiSan);
		return "/loaiSan/edit";
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<LoaiSan> loaiSans = loaiSanService.search(searchKey);
		model.addAttribute("loaiSans", loaiSans);
		model.addAttribute("searchKey", searchKey);

		return "/loaiSan/list";
	}

}
