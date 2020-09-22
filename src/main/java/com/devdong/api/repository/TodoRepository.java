package com.devdong.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devdong.api.bean.TodoVo;


@Repository
public interface TodoRepository extends JpaRepository<TodoVo, Integer>{
	
	public TodoVo findById(int seq);
	
}
