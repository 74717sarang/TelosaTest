package com.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entities.ToDo;
import com.todo.repository.Todorepository;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {

	// service layer contain All Business Logic

//	The @Autowired annotation is used in Spring to enable dependency injection,
//	which allows the Spring framework to automatically inject an instance of a bean 
//	(in this case, Todorepository) into your class.
//	This helps manage dependencies and reduces the need for manual wiring.

	@Autowired
	private Todorepository todorepository;

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "rest";
	}

	@Override
	public void addTodo(ToDo doToDo) {
		todorepository.save(doToDo);

	}

	@Override
	public Optional<ToDo> getbyid(long id) {
		return todorepository.findById(id);
	}

	@Override
	public List<ToDo> getall() {
		List<ToDo> list = new ArrayList<>();
		list = todorepository.findAll();
		return list;
	}

	@Override
	public boolean delete(long id) {
		Optional<ToDo> optionalTodo = getbyid(id);
		if (optionalTodo != null) {
			todorepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public String update(long id,ToDo todo1 ) {
		Optional<ToDo> optionalTodo = getbyid(id);
		if (optionalTodo.isPresent()) {
			ToDo newtodo = optionalTodo.get();

			newtodo.setCompleted(todo1.isCompleted());
			newtodo.setName(todo1.getName());

			todorepository.save(newtodo);
			return " update Done...";
		}
		return "Id Not Found..";
	}

}
