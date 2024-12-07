package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="todsList")
public class ToDoList {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long todoId;
	@Column(name="name")
	private String name;
	private boolean completed;
	private boolean incomplete;
	@JsonIgnore
	private LocalDate date;
	
	
	public ToDoList() {
		
	}
	

	public ToDoList(long todoId, String name, Boolean completed) {
		super();
		this.todoId = todoId;
		this.name = name;
		this.completed = completed;
	
	}
	
	
	
	
	public ToDoList(long todoId, String name, Boolean completed, Boolean incomplete, LocalDate date) {
		super();
		this.todoId = todoId;
		this.name = name;
		this.completed = completed;
		this.incomplete = incomplete;
		this.date = date;
	}
	public long getTodoId() {
		return todoId;
	}
	public void setTodoId(long todoId) {
		this.todoId = todoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public boolean getIncomplete() {
		return incomplete;
	}
	public void setIncomplete(Boolean incomplete) {
		this.incomplete = incomplete;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	@Override
	public String toString() {
		return "ToDoList [todoId=" + todoId + ", name=" + name + ", completed=" + completed + ", incomplete="
				+ incomplete + ", date=" + date + "]";
	}
	
}
