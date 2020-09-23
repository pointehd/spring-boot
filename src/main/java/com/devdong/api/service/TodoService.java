package com.devdong.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devdong.api.bean.TodoVo;
import com.devdong.api.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
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
	
	
}
