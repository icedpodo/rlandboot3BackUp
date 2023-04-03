package kr.co.rland.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.repository.MenuRepository;

@Service
public class DefaultMenuService implements MenuService {
	
	@Autowired
	private MenuRepository repository;

	public void setRepository(MenuRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Menu> getList() {
		// TODO Auto-generated method stub
		return repository.findAll(0,10,"",1,3000,"regDate","desc");
	}


	@Override
	public List<Menu> getList(int page) {
		// TODO Auto-generated method stub
		int size=10;
		List<Menu> list = repository.findAll(page, size, null, null, null, null, null);
		
		return list;
	}

	@Override
	public List<Menu> getList(int page, String query) {
		// TODO Auto-generated method stub
		int size=10;
		List<Menu> list = repository.findAll(page, size, query, null, null, null, null);
		
		return list;
	}

	@Override
	public List<Menu> getList(int page, Integer categoryId) {
		// TODO Auto-generated method stub
		int size=10;
		List<Menu> list = repository.findAll(page, size, null, categoryId, null, null, null);
		
		return list;
	}

	@Override
	public List<Menu> getList(int page, Integer categoryId, String query) {
		// TODO Auto-generated method stub
		int size=10;
		List<Menu> list = repository.findAll(page, size, query, categoryId, null, null, null);
		
		return list;
	}

	@Override
	public List<MenuView> getViewList() {
		// TODO Auto-generated method stub
		int page=0;
		int size=10;
		List<MenuView> list = repository.findViewAll(page, size, null, null, null, null, null);

		return list;
	}

	@Override
	public List<MenuView> getViewList(int page) {
		// TODO Auto-generated method stub
		int size=10;
		List<MenuView> list = repository.findViewAll(page, size, null, null, null, null, null);
		
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, String query) {
		// TODO Auto-generated method stub
		int size=10;
		List<MenuView> list = repository.findViewAll(page, size, query, null, null, null, null);
		
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, Integer categoryId) {
		// TODO Auto-generated method stub
		int size=10;
		List<MenuView> list = repository.findViewAll(page, size, null, categoryId, null, null, null);

		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, Integer categoryId, String query) {
		
		int size=9;
		int offset = (page-1)*size;
		String orderField = "reg_date";
		String order = "desc";
		
		List<MenuView> list = repository.findViewAll(offset, size, query, categoryId, null, orderField, order);
		
		return list;
	}
	
	@Transactional
	@Override
	public void pointUp() {
		Menu menu = new Menu();
		menu.setId(917L);
		menu.setPrice(7777);
		repository.update(menu);
		
		menu.setId(917L);
		menu.setPrice(999999);
		repository.update(menu);
	}

	@Override
	public Menu getById(long id) {
		
		Menu menu = repository.findById(id);
		
		
		
		return menu;
	}

	@Override
	public void add(Menu menu) {
		repository.insert(menu);
		
	}
}
