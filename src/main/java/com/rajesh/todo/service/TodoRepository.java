package com.rajesh.todo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajesh.todo.model.Todo;


public interface TodoRepository extends JpaRepository<Todo, Integer>{
	List<Todo> findByUser(String User);
}
