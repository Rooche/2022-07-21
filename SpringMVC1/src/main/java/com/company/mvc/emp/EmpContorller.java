package com.company.mvc.emp;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpContorller {

	Logger logger = LoggerFactory.getLogger(EmpContorller.class);
	
	@Autowired EmpMapper mapper;
	
	//단건조회
	@RequestMapping("/emp")
	public String emp(EmpVO vo, Model model, HttpServletRequest request) {
		logger.info("파라미터:" + vo.toString());
	//	model.addAttribute("emp", mapper.getEmp(vo));
		request.setAttribute("emp", mapper.getEmp(vo));
		return "emp/emp";
	}
	
	//목록
	@RequestMapping("/empList")
	   public String empList(Model model, EmpReqVO vo) {
	      model.addAttribute("empList", mapper.getEmpList(vo));
	      return "emp/empList";
	   }
	
	//등록페이지 이동
	@RequestMapping("/empInsert")
	public String empInsert() {
		return "emp/empInsert";
	}
	
	//등록처리
	//@PostMapping("/empInsertProc")
	@RequestMapping(value = "/empInsert", method = RequestMethod.POST)
	public String empInsertProc(EmpVO vo) {
		//커맨드 객체
		logger.debug(vo.toString());
		System.out.println(vo);
		mapper.insert(vo);
		System.out.println(vo.getEmployeeId() + "사번등록");
		return "redirect:empList";
	}
	
	//수정페이지
	@RequestMapping("/empUpdate")
	public String empUpdateForm(Model model, EmpVO vo) {
		model.addAttribute("emp", mapper.getEmp(vo));
		return "emp/empUpdate";
	}
	
	//수정처리
	  @RequestMapping("/empUpdateProc")
	  public String empUpdate(EmpVO vo) {
	  mapper.update(vo);
	  return "redirect:empList";
	  
	  }
}
