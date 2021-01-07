package com.devdong.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.devdong.api.bean.Todo;
import com.devdong.api.repository.TodoRepository;

@Service
public class TodoService {
	
	static final int PAGE_VIEWER = 10;
	
	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> getTodoPage(int page){
		List<Todo> list = todoRepository.findByDeleted(false,PageRequest.of(page-1, PAGE_VIEWER));
		return list;
	}
	
	public Todo insertTodo(String content) {
		Todo todo = new Todo(content);
		todoRepository.save(todo);
		return todo;
	}
	
	public Todo updateTodo(Todo todo) {
		Todo resultTodo = todoRepository.findById(todo.getSeq());
		resultTodo.setContent(todo.getContent());
		todoRepository.save(resultTodo);
		
		return resultTodo;
	}
	
	public Todo doneTodo(int seq) {
		Todo resultTodo = todoRepository.findById(seq);
		resultTodo.setDone(true);
		todoRepository.save(resultTodo);
		return resultTodo;
	}
	
	public Todo deleteTodo(int seq) {
		Todo resultTodo = todoRepository.findById(seq);
		resultTodo.setDeleted(true);
		todoRepository.save(resultTodo);
		return resultTodo;
	}
	
	
}
