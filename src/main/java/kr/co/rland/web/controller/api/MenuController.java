package kr.co.rland.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;

@RestController("apiMenuController")//기존 메뉴컨트롤러와 이름 충돌을 피하기위해 이름지정-안하면 충돌나서 뻗는다
@RequestMapping("menus") 
public class MenuController {
//	@Controller -> 문서명
//	/menu/list 이런 주소 방식이었음 =메뉴를 이용해 list라는 페이지줘
//	/menu/edit : GET    /menu/edit : POST
//	/menu/del?id=3
//	@RestController -> 데이터
//	/menus     method:GET   메뉴목록 전체를줌
//  /menus/3   method:GET  페이지를 이런방식으로 요청 get
//	/menus/3   method:DELETE  delete
//	/menus/3   method:PUT   edit
//	/menus     method:POST   insert
	
	//얘네는 모두 자스로 요청하는것-근데 만들기전에 테스트해보고싶을때 쓰는것=postman
	//레스트컨트롤러에게 요청하면 사용자가 받는정보가 스트링이 아니고 데이터임.객체가 아니고 제이슨/xml로 원하는대로 반환가능
	
	@Autowired
	private MenuService service;
	
	
	@GetMapping
	 public List<MenuView> getList(
			 @RequestParam(name="p", defaultValue ="1")int page,
			 @RequestParam(name="c", required= false)Integer categoryId,
			 @RequestParam(name="q", required= false)String query){
		
		 
		 List<MenuView> list = service.getViewList(page, categoryId, query);
		
		 
		 return list;
	 }
	
	//{} 안의 이름은 쿼리스트링이 우선순위를 갖고있다. 그럼 인자와 매핑하려면?@pathvariable
	@GetMapping("{id}")
	 public Menu get(
			 @PathVariable("id")int id){
		
		Menu menu = service.getById(id);
		
		 return menu;
	 }
	
	@PutMapping("{id}")
	 public String edit(
			 @PathVariable("id")int id){
		 return "menu edit: "+id;
	 }
	
	@DeleteMapping("{id}")
	 public String delete(
			 @PathVariable("id")int id){
		 return "menu delete: "+id;
	 }
	
	@PostMapping
	 public String insert(@RequestBody Menu menu){
		
		menu.setCategoryId(1);
		service.add(menu);
		//성능도 좋지만 일관된, 정형화된 방법을 쓰는것도 유지보수에 낫다. 
		//거기에 문제점이있다면 다른 꼼수를 쓰는게 나을지도(물론 거기에 타당한 이유있어야됨)
		//int id = service.lastMenuId();
		//Menu lastMenu = service.last();
		 return "ok";
	 }
	
	
	
}
