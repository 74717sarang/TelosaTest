package com.todo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="todo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToDo {

	@Id                    //Compulsory
	@GeneratedValue(strategy = GenerationType.AUTO)  // for auto update
	private long id;
	
    
	@Column(name="name")
	private String name;
	
	private boolean completed;
	
	@CreationTimestamp //adds current date when the entity is created(only once!)
	private LocalDate date;

	

	
//	
//
	public ToDo( String name, boolean completed, LocalDate date) {
		super();
		this.name = name;
		this.completed = completed;
		this.date = date;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	 
	
	
	
	
}
