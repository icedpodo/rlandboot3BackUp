package kr.co.rland.web.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;


@Mapper
public interface MenuRepository {
	//데이터를 제공하는쪽에 포커스. 업무로직이 아니라 정말 데이터서비스만 추구
	//@Select("select * from menu")
	//근데 하다보면 쿼리문 길어지고 덕지덕지 붙어서 너무 보기 힘들어져서 안쓰게됨
	
//	List<Menu> findAll();
//	List<Menu> findAll(Integer offset, Integer size);
	
	List<Menu> findAll();
	List<Menu> findAll(Integer offset, 
						Integer size, 
						String  query,
						Integer categoryId,
						Integer price,
						String orderField,
						String orderDir);
	
	List<MenuView> findViewAll();
	List<MenuView> findViewAll(
			Integer offset, 
			Integer size, 
			String  query,
			Integer categoryId,
			Integer price,
			String orderField,
			String orderDir);
	
	// #과 $의 차이 아이디가 문자열이면 ""가 있어야한데 #쓰면 자동포함됨 
	//$는 절대 안붙여줌. 그럼 정수는 $나 #나 똑같겠지
	List<Menu> findAllByIds(List<Long> ids);
	Menu findById(long id);
	int count(
			String query, 
			Integer categoryId, 
			Integer price);
	
	int insert(Menu menu);
	@Transactional(propagation = Propagation.NEVER)
	int update(Menu menu);
	void delete(long id);

	


	

	

}
