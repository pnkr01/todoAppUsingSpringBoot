package com.pawan.springboot.myfirstwebapp.todo;

import com.pawan.springboot.myfirstwebapp.repository.TodoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJpa {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    @RequestMapping("/list-all-todos")
    public String listAllTodo(ModelMap modelMap){
        String userName = getLoggedInUserName(modelMap);
        List<Todo> todoList = todoRepository.findByUsername(userName);
        modelMap.addAttribute("todoList", todoList);
        return "listAllTodos";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap){
        String username = getLoggedInUserName(modelMap);
        Todo todo = new Todo(0,username,"",false,LocalDate.now());
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        todo.setUsername(getLoggedInUserName(modelMap));
        todoRepository.save(todo);
        return "redirect:/list-all-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
       //delete todo
        //redirect to all todo
        todoRepository.deleteById(id);
        return "redirect:/list-all-todos";
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap){
        //update todo
        Todo todo = todoRepository.findById(id).get();
        modelMap.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.POST)
    public String updateTodoPage(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        //update the description
        String username = getLoggedInUserName(modelMap);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:/list-all-todos";
    }


    private static String getLoggedInUserName(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
