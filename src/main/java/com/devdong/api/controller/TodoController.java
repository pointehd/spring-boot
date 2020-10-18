package com.devdong.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devdong.api.bean.TodoVo;
import com.devdong.api.service.TodoService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dhhwang
 * @date 20.09.24
 * */
@RestController
@Slf4j
public class TodoController {
	@Autowired
	TodoService todoService;
	
	@GetMapping("/")
	public String home() {
		
		return "Hello World";
	}
	
	/**
	 * 조회
	 * */
	@GetMapping("/todo/page/{page}")
	public List<TodoVo> getTodo(@PathVariable int page){
		return todoService.getTodoPage(page);
	}
	
	/**
	 * 삽입 
	 * */
	@PostMapping("/todo")
	public TodoVo insertTodo(@RequestBody TodoVo todo) {
		return todoService.insertTodo(todo.getContent());
	}
	
	/**
	 * 내용 변경 
	 * */
	@PutMapping(value = "/todo")
	public TodoVo updateTodo(@RequestBody TodoVo todo){
		return todoService.updateTodo(todo);
	}
	
	/**
	 * 완료처리 
	 * */
	@PutMapping(value= "/todo/done")
	public TodoVo doneTodo(@RequestBody TodoVo todo) {
		return todoService.doneTodo(todo.getSeq());
	}
	
	/**
	 * 삭제 처리 
	 * */
	@DeleteMapping("/todo")
	public TodoVo deleteTodo(@RequestBody TodoVo todo) {
		return todoService.deleteTodo(todo.getSeq());
	}
	
}
