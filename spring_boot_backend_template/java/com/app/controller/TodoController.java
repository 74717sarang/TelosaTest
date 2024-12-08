package com.app.controller;

import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.ToDoList;
import com.fasterxml.jackson.annotation.JsonIgnore;



@RestController
@RequestMapping("/ToDo")
public class TodoController {

	private ArrayList<ToDoList> todoList = new ArrayList<>();

	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("todo", todoList);

		return "index";
	}

//	@GetMapping("/")
//	public ResponseEntity<ArrayList<ToDoList>> index() {
//		return new ResponseEntity<>(todoList, HttpStatus.OK);
//	}

	@PostMapping("/addTodo")
	public String adddTodoList(Model model) {
		model.addAllAttributes(todoList);
		ToDoList obj = new ToDoList();
		obj.setTodoId(1);
		obj.setName("testName");
		obj.setCompleted(true);
		obj.setIncomplete(false);

		if (obj == null) {
			System.out.println("Model is Null...");

		}
		todoList.add(obj);

		return "redirct:/ "; // home page
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTodo(@PathVariable long id) {
		todoList.removeIf(i -> i.getTodoId() == id); // remove maching id

	}

	@PutMapping("/ChangeStatus")
	public String changeTodo(@RequestParam long id, Boolean no) {
		for (ToDoList todo : todoList) {
			if (todo.getTodoId() == id) {
				todo.setCompleted(no);
				break; // change is done

			}
		}
		return "redirect:/"; // home page
	}

	@PutMapping("/Changname")
	public String changeTodoName(@RequestParam long id, String name) {
		for (ToDoList todo : todoList) {
			if (todo.getTodoId() == id) {
				todo.setName(name);
				break; // Name change is done

			}
		}
		return "redirect:/"; // home page
	}

	@GetMapping("/getIncomlete")
	public void getIncomplete() {
		ArrayList<ToDoList> list = new ArrayList<>();
		for (ToDoList todo : todoList) {
			if (todo.getIncomplete()) {
				list.add(todo);

			}
		}
	}

	@GetMapping("/getcomlete")
	public void getComplete() {
		ArrayList<ToDoList> list = new ArrayList<>();
		for (ToDoList todo : todoList) {
			if (todo.getCompleted()) {
				list.add(todo);

			}
		}

	}
	@GetMapping("/sortByName") 
	@JsonIgnore()
	public ArrayList<ToDoList> sortByName() {
		todoList.add(new ToDoList(100, "xyz", true));
		todoList.add(new ToDoList(90, "pqr", false));
		todoList.add(new ToDoList(80, "abc", true));

		todoList.sort(Comparator.comparing(ToDoList::getName)); 
		return todoList ;
				}
}