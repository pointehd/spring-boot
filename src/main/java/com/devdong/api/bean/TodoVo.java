package com.devdong.api.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity 
@Table(name="todo")
public class TodoVo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	private String content;
	private boolean done;
	private boolean deleted;
	private Timestamp createDt;
	
	@Builder
	public TodoVo(String content) {
		this.content = content;
		this.done = false;
		this.deleted = false;
	}
}
