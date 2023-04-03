package kr.co.rland.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;

@Controller("adminMenuController")
@RequestMapping("/admin/menu")
public class MenuController {
	
//	private MenuRepository menuRepository;
	
	@Autowired
	private MenuService service;
		
//	public MenuController() {
//		
//	}
//
//	public MenuController(MenuRepository menuRepository) {
//		super();
//		this.menuRepository = menuRepository;	
//	}
//
//	
//	@Autowired
//	public void setMenuRepository(MenuRepository menuRepository) {
//		System.out.println("setting 전에 해야 할 일");
//		this.menuRepository = menuRepository;
//		System.out.println("setting 후에 해야 할 일");
//	}

	@GetMapping("list")
	public String list(
			//요청한 값이 없어서 그냥 list로 들어가면 에러페이지가뜸. 그래서 기본값을 정해줘야함
			//q값도 같이 요청하고있는데 특별값이 없을때 false 값으로 넣어주면 오류없이 지나갈수있다
			@RequestParam(name ="p", defaultValue = "1") int page,
			@RequestParam(name ="c", required = false) Integer categoryId,
			@RequestParam(name ="q", required = false) String query,
			
			Model model) {
		
		
		List<MenuView> list = service.getViewList(page,categoryId,query);
		model.addAttribute("list",list);
		return "admin/menu/list";
	}
	
	@GetMapping("detail")
	public String detail(
			int id,
			Model model) {
		
		Menu menu = service.getById(id);
		model.addAttribute("menu",menu);
		return "admin/menu/detail";
	}
	@GetMapping("reg") //->service():get/post를 내가 다 처리하는 매핑
	public String reg() {
		return "/WEB-INF/view/admin/menu/reg.jsp";
	}
	//폼입력해서 제출이요
	@PostMapping("reg")
	public String reg(String title) {
		//등록하고
		System.out.println("메뉴 등록 완료");
		return "redirect:list";
	}
	
}
