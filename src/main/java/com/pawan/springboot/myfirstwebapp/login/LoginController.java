package com.pawan.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String goToLogin() {
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String goToWelcome(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        if (authenticationService.isValidUser(name, password)) {
            modelMap.put("name", name);
            modelMap.put("password", password);
            return "Welcome";
        } else {
            modelMap.put("error", "Invalid username or password");
            return "login";
        }
    }
}
