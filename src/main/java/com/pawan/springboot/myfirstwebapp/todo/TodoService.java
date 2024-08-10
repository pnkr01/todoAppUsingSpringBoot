package com.pawan.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
   private static List<Todo> todos = new ArrayList<>();

   private static int todoCounter = 0;
    static {
        todos.add(
                new Todo(++todoCounter, "pawan","Learn Spring",false,
                        LocalDate.now().plusYears(1)));

        todos.add(new Todo(++todoCounter, "Rahul","Learn AWS",false,LocalDate.now().plusYears(2)));
        //generate more
        todos.add(new Todo(++todoCounter,"Pinki","Learn JPA",true,LocalDate.now().plusYears(3)));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addNewTodo(String name,String description, LocalDate date, boolean done) {
        Todo todo = new Todo(++todoCounter,name,description,done,date);
        todos.add(todo);
    }

    public void deleteTodoById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
