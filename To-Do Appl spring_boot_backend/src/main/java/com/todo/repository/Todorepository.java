package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entities.ToDo;

@Repository
public interface Todorepository extends JpaRepository<ToDo, Long>{

	
}
