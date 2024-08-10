package com.pawan.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;


@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("/list-all-todos")
    public String listAllTodo(ModelMap modelMap){
        List<Todo> todoList = todoService.findByUsername("pawan");
        modelMap.addAttribute("todoList", todoList);
        return "listAllTodos";
    }
}
