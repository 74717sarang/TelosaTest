package com.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entities.ToDo;
import com.todo.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private ToDoService doService;;

	@GetMapping("/test")
	public String testDpto() {
		doService.test();
		return "Hello test 1";
	}

//	@PostMapping("/test2")
//	public ResponseEntity<?> addTodo2(@RequestBody ToDo do1) {
//		if (do1 != null) {            
//			doService.addTodo(do1);
//			return new ResponseEntity<>(HttpStatus.CREATED);
//		}
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}

//	@PostMapping("/test3")
//	public String addTodo3(@RequestBody ToDo do1) {
//
//		System.out.println("**********--------*****");
////		  System.out.println(do1.getName());
//		if (do1 != null) {
//			doService.addTodo(do1);
//			return "added  done ...";
//		}
//
//		return " Not done";
//	}

	@PostMapping("/test4")
	public ResponseEntity<String> addTodo4(@RequestBody ToDo do1) {
		
		if (do1 != null) {
			doService.addTodo(do1);
//		return new ResponseEntity.s
			return ResponseEntity.status(HttpStatus.OK).body("Todo Inserted");

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Inserted...");
	}

	@GetMapping("/getTodo/{id}")
	public ResponseEntity<ToDo> getById(@PathVariable long id) {
		Optional<ToDo> optionalTodo = doService.getbyid(id);

		if (optionalTodo.isPresent()) {
			return new ResponseEntity<>(optionalTodo.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ToDo>> getAll() {
		List<ToDo> list = doService.getall();

		if (list != null) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable long id) {

		boolean delete = doService.delete(id);
		if (delete)
			return new ResponseEntity<>("delete done", HttpStatus.OK);
		return new ResponseEntity<>("Id Not Found", HttpStatus.BAD_REQUEST);

	}

	
	@PutMapping("/update")
	public ResponseEntity<String>updateTodo(@RequestBody int id,ToDo do1){
		if(do1!=null) { 
		doService.update(do1.getId(), do1.getName(),do1.isCompleted());
		return new ResponseEntity<>("update done", HttpStatus.OK);
		}
		return new ResponseEntity<>("Id Not found...", HttpStatus.BAD_REQUEST);

	}
	
}
