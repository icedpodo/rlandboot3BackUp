package kr.co.rland.web.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Program {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		String hello= (String) context.getBean("hello");
		System.out.println(hello);
		
		
//		MenuRepository menuRepository= context.getBean(MenuRepository.class);
//		List<Menu> list = menuRepository.fidnAll();
		
		
		
		
//		MenuService service =context.getBean(MenuService.class);
		
//		MenuService service =(MenuService)context.getBean("service");
//		List<Menu> list = service.getList();
//		
//		
//		System.out.println(list);
	
		/*
		Menu menu = new Menu();
		menu.setId(1);
		menu.setName("아메리카노");
		menu.setPrice(3000);
//		menu.setRegDate(new Date("2023-11-23"));
		
		JSONParser parser = new JSONParser(menu);
		String json = parser.toJSON();
		
		//{"id":1, "name":"아메리카노", ...}
		
	
		
		System.out.println(json);
		*/
		
		
	}

}
