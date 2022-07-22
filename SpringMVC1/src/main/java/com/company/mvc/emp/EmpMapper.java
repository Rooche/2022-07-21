package com.company.mvc.emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpReqVO vo);
	public List<EmpVO> getEmpByDept(String[] dept);
	int insert(EmpVO vo);
	int update(EmpVO vo);
}
