package com.todo.service;

import java.util.List;
import java.util.Optional;

import com.todo.entities.ToDo;

public interface ToDoService {

	
	public String test() ;
	
	public void addTodo(ToDo doToDo);
	
	public Optional<ToDo> getbyid(long id);
	
	public List<ToDo>getall();
	
	public boolean delete(long id);
	
	public String update(long id,ToDo do1);

	
	
	
}
