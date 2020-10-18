package com.devdong.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devdong.api.bean.TodoVo;


@Repository
public interface TodoRepository extends JpaRepository<TodoVo, Integer>{
	

	
	public TodoVo findById(int seq);
	
	public List<TodoVo> findByDeleted(boolean deleted, Pageable pageable); 
	
//	public TodoVo findByIAndIsDone(int seq, boolean isDone);
	
	
}
