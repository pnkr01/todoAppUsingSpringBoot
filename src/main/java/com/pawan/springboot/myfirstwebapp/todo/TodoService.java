package com.pawan.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
   private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(
                new Todo(1, "pawan","Learn Spring",false,
                        LocalDate.now().plusYears(1)));

        todos.add(new Todo(2, "Rahul","Learn AWS",false,LocalDate.now().plusYears(2)));
        //generate more
        todos.add(new Todo(3,"Pinki","Learn JPA",true,LocalDate.now().plusYears(3)));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
