package kr.co.rland.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.entity.RcmdMenuView;
import kr.co.rland.web.service.CategoryService;
import kr.co.rland.web.service.MenuService;
import kr.co.rland.web.service.RcmdMenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService service;//얘가 메인이라 이름이 service
	
	@Autowired
	private CategoryService categoryService; //다른 곳에서
	
	@Autowired
	private RcmdMenuService rcmdMenuService;
	
	@RequestMapping("list")
	public String list(
			@RequestParam(name = "p", defaultValue = "1")int page,
			@RequestParam(name = "c", required=false) Integer categoryId,
			@RequestParam(name = "q", required=false) String query,
			
			Model model) {
		
		List<Category> categoryList = categoryService.getList();
		List<MenuView> list = service.getViewList(page, categoryId, query);
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("list", list);
		
//		service.getList();// 1,query:"",category:null
//		service.getList(1);
//		service.getList(1, "아");
//		service.getList(1, 1);
//		service.getList(1, 1, "아");
		
		
		return "menu/list2"; //타일즈에게 조립해달라는 조합에 대한 이름을 반환
		
	}
	
	//http://localhost:8080/menu/detail?id=617
	@RequestMapping("detail")
	public String detail(int id,Model model) {
		
		int cartCount = 10; //no table yet
//		String categoryName =categoryService.getNameByMenuId(id);
		Menu menu = service.getById(id);	
		String categoryName =categoryService.getNameById(menu.getCategoryId());
		List<RcmdMenuView> rcmdMenuList = rcmdMenuService.getViewListByMenuId(id);
		
		model.addAttribute("categoryName", categoryName);
		model.addAttribute("menu",menu);
		model.addAttribute("rcmdMenuList",rcmdMenuList);
		
		return "menu/detail2";
	}


}
