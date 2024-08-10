package com.pawan.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
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

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap){
        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0,username,"",false,LocalDate.now());
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        todoService.addNewTodo((String) modelMap.get("name"),todo.getDescription(), LocalDate.now().plusYears(1),todo.getDone());
        return "redirect:/list-all-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
       //delete todo
        //redirect to all todo
        todoService.deleteTodoById(id);
        return "redirect:/list-all-todos";
    }
}
