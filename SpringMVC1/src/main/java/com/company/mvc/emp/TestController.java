package com.company.mvc.emp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	//View와 Model을 합친게 ModelAndView
	@RequestMapping("/parameter2")
	public ModelAndView parameter2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("parameter");
		mv.addObject("", "");
		return mv;
	}
	
	@RequestMapping("/parameter")
	public String parameter(Model model) {
		model.addAttribute("param1", "test");
		return "parameter";
	}
	
	@RequestMapping("/req1") //넘겨주는 파라미터,네임속성과 일치하면 값을 담아준다
	public void req1(HttpServletResponse response, @RequestParam(required = false, defaultValue = "park") String id) { // Integer id를 받을경우 타입때문에 숫자만가능 값이 스트링이면 값을 담을수없다 .
		try {
			PrintWriter out;
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			out.print(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	   @RequestMapping("/req2")//List<String>
	   public void req2(HttpServletResponse response,
	                @RequestParam List<String> ids) throws IOException {
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.print(ids);
	   }

	
	   @RequestMapping("/req3")//String[]
	   public void req3(HttpServletResponse response,
	             @RequestParam Map<String, Object> map) throws IOException {
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.print(map);
	   }
	   
	   @RequestMapping("/req4")
	   public void req4(HttpServletResponse response,
			   ReqVO vo) throws IOException {
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.print(vo);
	   }
	   
	   @RequestMapping("/req5")
	   public void req5(HttpServletResponse response,
			   ListReqVO vo) throws IOException {
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.print(vo);
	   }
	   
		/*
		 * //첨부파일
		 * 
		 * @RequestMapping("/req6") public void req6(HttpServletResponse response, ReqVO
		 * vo, MultipartFile pic) { response.setContentType("text/html; charset=UTF-8");
		 * PrintWriter out; try { out = response.getWriter();
		 * 
		 * if(pic != null && pic.getSize() > 0) { pic.transferTo(new File("c:/upload",
		 * pic.getOriginalFilename())); out.print(pic.getOriginalFilename() + "<br>");
		 * out.print(pic.getSize()); } } catch (IOException e) { e.printStackTrace(); }
		 * }
		 */
	   
	   //첨부파일
	   @RequestMapping("/req6")
	   public void req6(HttpServletResponse response, ReqVO vo, MultipartFile[] pic) {
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out;
	      try {
	         out = response.getWriter();
	         
	         for(MultipartFile temp : pic)
	         if(pic != null && temp.getSize() > 0) {
	            File file = new File("c:/upload", temp.getOriginalFilename());
	            temp.transferTo(file);
	            out.print(temp.getOriginalFilename() + "<br>");
	            out.print(temp.getSize() + "<br>");
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	

	   @RequestMapping("/req7/{id}/{age}")
	   public void req5(HttpServletResponse response,
			   @PathVariable String id, @PathVariable int age) throws IOException {
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.print(id);
	      out.print(age);
	   }
	//스트링[] request.getParameterValuse() request.getParameter()
	
	@GetMapping("/array")
	public void array(@RequestParam String id, @RequestParam List<String> ids, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		out.print(id);
		out.print(ids);
	}
}
