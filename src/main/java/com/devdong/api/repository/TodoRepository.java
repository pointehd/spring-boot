package com.devdong.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devdong.api.bean.TodoVo;


@Repository
public interface TodoRepository extends JpaRepository<TodoVo, Integer>{
	
	static final int PAGE_VIEWER = 10;
	
	public TodoVo findById(int seq);
	
	public TodoVo findByIAndIsDone(int seq);
	
	
}
