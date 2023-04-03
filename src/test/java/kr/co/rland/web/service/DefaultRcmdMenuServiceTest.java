package kr.co.rland.web.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import kr.co.rland.web.entity.RcmdMenuView;
import kr.co.rland.web.repository.RcmdMenuRepository;

@AutoConfigureTestDatabase(replace =Replace.NONE )
@MybatisTest
class DefaultRcmdMenuServiceTest {
	
	@Autowired
	private RcmdMenuRepository repository;
	
	@Test
	void testGetViewListByMenuId() {
		List<RcmdMenuView> list = repository.findViewAllByMenuId(617);
				System.out.println(list);
	}

}
