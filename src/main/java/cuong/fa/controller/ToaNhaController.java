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

import cuong.fa.entities.ToaNha;
import cuong.fa.page.PageAble;
import cuong.fa.service.ToaNhaService;

@Controller
@RequestMapping("/toaNha")
public class ToaNhaController {
	@Autowired
	private ToaNhaService ToaNhaService;
	
	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<ToaNha> toaNhas = ToaNhaService.findWithPageAble(pageAble);
		model.addAttribute("toaNhas", toaNhas);
		model.addAttribute("totalPages", ToaNhaService.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/toaNha/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("toaNhaForm", new ToaNha());
		return "/toaNha/add";
	}

	@PostMapping("/save")
	public String addNewTTDangKyThue(@ModelAttribute(name = "toaNhaForm") @Valid ToaNha toaNha,
			BindingResult result) {
		
		
		if (result.hasErrors()) {
			return "/toaNha/add";
		}
		
		ToaNhaService.saveOrUpdate(toaNha);
		return "redirect:/toaNha/list";
	}
	
	
	

	
	@GetMapping("/delete")
	public String delete(@RequestParam(name = "maToaNha") String maToaNha) {
		ToaNhaService.delete(maToaNha);
		return "redirect:/toaNha/list";
	}

	@RequestMapping("/update/{maToaNha}")
	public String update(@PathVariable(name = "maToaNha") String maToaNha, Model model) {
		ToaNha toaNha = ToaNhaService.findById(maToaNha);
		model.addAttribute("toaNhaForm", toaNha);
		return "/toaNha/edit";
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<ToaNha> toaNhas = ToaNhaService.search(searchKey);
		model.addAttribute("toaNhas", toaNhas);
		model.addAttribute("searchKey", searchKey);

		return "/toaNha/list";
	}

}
