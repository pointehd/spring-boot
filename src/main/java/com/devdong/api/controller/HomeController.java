package com.devdong.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devdong.api.bean.TodoVo;
import com.devdong.api.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
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
	
	@PutMapping(value = "/update")
	public TodoVo updateTodo(@RequestBody TodoVo todo){
		System.out.println("dsldfa");
		log.debug("todo.seq : {}", todo.getSeq());
		log.debug("todo.seq : {}", todo.getContent());
		log.debug("todo : {}", todo);
		
		return todoService.updateTodo(todo);
//		return todoService.updateTodo(todo);
	}
}
