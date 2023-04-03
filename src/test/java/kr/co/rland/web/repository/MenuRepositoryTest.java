package kr.co.rland.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.rland.web.entity.Menu;

@AutoConfigureTestDatabase(replace =Replace.NONE )
@MybatisTest
//@AutoConfigureMybatis
//@SpringBootTest//나머지 설정도 읽어서 test할수있도록 해야함 근데 mbtest와 같이키면
//test어노테이션 중복으로 충돌생기니 mb는 연결하되 test를 빼면됨
class MenuRepositoryTest {
	
	@Autowired
	private MenuRepository repository;
	
//	@Test
//	void testFindAll() {
//	List<Menu> list =	repository.findAll(0,10);
//		System.out.println(list);
//	}
//	

	
	
//	@Test
	void testFindAllByIds() {
		List<Long> ids = new ArrayList<>();
		ids.add(616L);
		ids.add(617L);
		ids.add(713L);
		ids.add(737L);
		List<Menu> list =	repository.findAllByIds(ids);
		System.out.println(list);
	}
	

//	@Test
	void testUpdate() {
		Menu menu = new Menu();
		menu.setId(856);
		menu.setName("뜨거운아이스아메리카노");
		
		int m = repository.update(menu);
		System.err.println(m);
	}
	
	@Test
	void testCount() {
		int count = repository.count(null, null, null);
		System.out.println(count);
		
	}
}

