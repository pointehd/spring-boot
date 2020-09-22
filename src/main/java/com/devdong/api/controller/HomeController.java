package com.devdong.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devdong.api.bean.TodoVo;
import com.devdong.api.service.TodoService;

@RestController
public class HomeController {
	@Autowired
	TodoService todoService;
	
	@GetMapping("/")
	public String home() {
		return "Hello World";
	}
	
	@GetMapping("/insert/{content}")
	public TodoVo insertTodo(@PathVariable String content) {
		return todoService.insertTodo(content);
	}
}
