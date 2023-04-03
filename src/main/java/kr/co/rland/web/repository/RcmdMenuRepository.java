package kr.co.rland.web.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.rland.web.entity.RcmdMenu;
import kr.co.rland.web.entity.RcmdMenuView;


@Mapper
public interface RcmdMenuRepository {
	//데이터를 제공하는쪽에 포커스. 업무로직이 아니라 정말 데이터서비스만 추구
	//@Select("select * from menu")
	//근데 하다보면 쿼리문 길어지고 덕지덕지 붙어서 너무 보기 힘들어져서 안쓰게됨
	
//	List<Menu> findAll();
//	List<Menu> findAll(Integer offset, Integer size);
	
	
	List<RcmdMenuView> findViewAllByMenuId(int menuId);
	int insert(RcmdMenu rcmdMenu);
	void delete(RcmdMenu rcmdMenu);
	

	


	

	

}
