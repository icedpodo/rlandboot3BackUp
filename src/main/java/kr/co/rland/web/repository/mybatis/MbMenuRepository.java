//package kr.co.rland.web.repository.mybatis;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import kr.co.rland.web.entity.Menu;
//import kr.co.rland.web.entity.MenuView;
//import kr.co.rland.web.repository.MenuRepository;
//
////@Repository
//public class MbMenuRepository implements MenuRepository {
//
////	private SqlSessionFactory factory;
//	
//	@Autowired
//	private SqlSession session;
//	private MenuRepository repository;
//	
//	
//	public MbMenuRepository() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	@Autowired
//	public MbMenuRepository(SqlSession session) {
//		super();
//		this.session = session;
//		this.repository = session.getMapper(MenuRepository.class);
//	}
//
////	@Override
////	public List<Menu> findAll() {
//////		return repository.findAll(0,10,null,null,null,null,null);
////		return session.selectList("kr.co.rland.web.repository.MenuRepository.findAll");
////	}
////	
////	@Override
////	public List<Menu> findAll(Integer offset, Integer size) {
//////		MenuRepository repository = session.getMapper(MenuRepository.class);
////		return repository.findAll(offset,size,null,null,null,null,null);
////	}
//
//	
//	@Override
//	public List<Menu> findAll(Integer offset, Integer size, String query, Integer categoryId, Integer price,
//			String orderField, String orderDir) {
////		MenuRepository repository = session.getMapper(MenuRepository.class);
//		return repository.findAll(null,null,null,null,null,null,null);
//	}
//
//	@Override
//	public List<Menu> findAllByIds(List<Long> ids) {
//		
////		MenuRepository repository = session.getMapper(MenuRepository.class);
////		List<Menu> list = session.selectList("kr.co.rland.web.repository.MenuRepository.findAllByIds",ids);
//		
//		return repository.findAllByIds(ids);
//	}
//
//	@Override
//	public Menu findById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int insert(Menu menu) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int update(Menu menu) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void delete(long id) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public int count(String query, Integer categoryId, Integer price) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public List<Menu> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<MenuView> findViewAll(Integer offset, Integer size, String query, Integer categoryId, Integer price,
//			String orderField, String orderDir) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<MenuView> findViewAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
