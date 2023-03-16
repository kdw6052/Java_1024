package kr.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.test.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/comment/insert", method = RequestMethod.POST)
	public Map<String, Object> comment(HashMap<String,Object> obj) {
		Map<String,Object> map = new HashMap <String,Object>();
		return map;
	}
}
