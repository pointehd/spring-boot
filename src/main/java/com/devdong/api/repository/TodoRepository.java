package com.devdong.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devdong.api.bean.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	

	
	public Todo findById(int seq);
	
	public List<Todo> findByDeleted(boolean deleted, Pageable pageable); 
	
//	public TodoVo findByIAndIsDone(int seq, boolean isDone);
	
	
}
