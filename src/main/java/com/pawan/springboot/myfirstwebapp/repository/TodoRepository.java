package com.pawan.springboot.myfirstwebapp.repository;

import com.pawan.springboot.myfirstwebapp.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {

    List<Todo> findByUsername(String username);
}
