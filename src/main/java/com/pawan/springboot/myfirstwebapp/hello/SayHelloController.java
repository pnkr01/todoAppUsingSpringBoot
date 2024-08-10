package com.pawan.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {

    @ResponseBody
    @RequestMapping("/say-hello")
    public String sayHello(){
        return "Hello How are you?";
    }

    @ResponseBody
    @RequestMapping("/say-hello-html")
    public String sayHelloHtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Pawan Resume</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>Pawan in a Hero</h1>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }

//    @RequestMapping("/login")
//    public String login(){
//        return "login";
//    }

}
