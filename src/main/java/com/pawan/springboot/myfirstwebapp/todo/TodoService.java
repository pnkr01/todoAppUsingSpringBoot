package com.pawan.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addNewTodo(String name,String description, LocalDate date, boolean done) {
        Todo todo = new Todo(++todoCounter,name,description,done,date);
        todos.add(todo);
    }

    public void deleteTodoById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findTodoById(int id) {
        Todo todo1 = todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
        return todo1;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }

//    public void updateTodoById(String description){
//        todos.replaceAll();
//    }
}
