package com.devdong.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.devdong.api.bean.TodoVo;
import com.devdong.api.repository.TodoRepository;

@Service
public class TodoService {
	
	static final int PAGE_VIEWER = 10;
	
	@Autowired
	private TodoRepository todoRepository;
	
	public List<TodoVo> getTodoPage(int page){
		List<TodoVo> list = todoRepository.findByDeleted(false,PageRequest.of(page-1, PAGE_VIEWER));
		return list;
	}
	
	public TodoVo insertTodo(String content) {
		TodoVo todo = new TodoVo(content);
		todoRepository.save(todo);
		return todo;
	}
	
	public TodoVo updateTodo(TodoVo todo) {
		TodoVo resultTodo = todoRepository.findById(todo.getSeq());
		resultTodo.setContent(todo.getContent());
		todoRepository.save(resultTodo);
		
		return resultTodo;
	}
	
	public TodoVo doneTodo(int seq) {
		TodoVo resultTodo = todoRepository.findById(seq);
		resultTodo.setDone(true);
		todoRepository.save(resultTodo);
		return resultTodo;
	}
	
	public TodoVo deleteTodo(int seq) {
		TodoVo resultTodo = todoRepository.findById(seq);
		resultTodo.setDeleted(true);
		todoRepository.save(resultTodo);
		return resultTodo;
	}
	
	
}
