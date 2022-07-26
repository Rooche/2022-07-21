package com.company.mvc.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 웹스토어 -> rest 검색 -> Boomerang - SOAP & REST Client 설치
@CrossOrigin(origins="*")
@RestController //	@ResponseBody + @Controller
public class TodoController {

	@Autowired TodoMapper mapper;
	
	@GetMapping(value = "/getText", produces = {MediaType.TEXT_PLAIN_VALUE})
	public String getText() {
		return "안녕하세요";
	}
	
	@GetMapping("/check")
	public List<TodoVO> check(TodoVO vo){
		int a = 5/0;
		return mapper.findAll(vo);
	}
	
	//조회 GET -> get -> Query String
	@GetMapping(value = "/todo", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TodoVO>> todoList(TodoVO vo) {
	//	int a = 5/0;
		List<TodoVO> list = mapper.findAll(vo);
		return new ResponseEntity<List<TodoVO>>(list, HttpStatus.OK);
	}
	
	//자원이름을 포스트로 Post -> body에서 form으로변경
	@PostMapping("/todo")
	public TodoVO todoInsert(TodoVO vo) {
		
		mapper.persist(vo);
		return vo;
	}
	
	//수정
	//파라미터가 json만 가능하여 파싱해서 VO에담으려면 @requestbody 가 필요하다
	// put 방식은 PUT -> JSON에서 json형식으로 값을 넣어 이용한다
	@PutMapping("/todo")
	public TodoVO todoUpdate(@RequestBody TodoVO vo) {
		
		mapper.merge(vo);
		return vo;
	}
	
	//삭제
	@DeleteMapping("/todo/{no}")
	public Integer todoDelete(@PathVariable Integer no) {
		
		mapper.remove(no);
		return no;
	}
	
	@GetMapping("/todo/{no}")
	public TodoVO todoSelect(@PathVariable Integer no) {
		
		return mapper.findById(no);
	}
	
}
