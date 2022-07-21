package com.company.mvc;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mvc.emp.EmpMapper;
import com.company.mvc.emp.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperTest {

	@Autowired EmpMapper mapper;
	
	@Test
	public void test() {
		EmpVO param = new EmpVO();
		param.setEmployeeId("100");
		Map<String, Object> result = mapper.getEmp(param);
		System.out.println(result);
		System.out.println(result.get("FIRST_NAME")); // 첫번째 이름만 나오게 하는것
	}
	
	@Test
	   public void list() {
		EmpVO param = new EmpVO();
		//param.setEmployeeId("30");
	    List<EmpVO> result = mapper.getEmpList(param);
	      System.out.println(result);
	   }
	
}
