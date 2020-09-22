package com.devdong.api.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="todo")
public class TodoVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	private String content;
	private boolean isDone;
	private boolean deleted;
	private Timestamp create_dt;
	
	@Builder
	public TodoVo(String content) {
		this.content = content;
		this.isDone = false;
		this.deleted = false;
	}
}
