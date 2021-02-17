package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    // responds to get requests at "/hello"
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello,Spring!";
//    }
    // responds to post requests at "/goodbye"
    //after refactoring this path will be hello/goodbye--> since we have declared the starting of the path in the top under requestMApping
    @GetMapping("goodbye")
    public String goodBye(){
        return "Good Bye, Spring!";
    }

    @RequestMapping(value = "hellogoodbye",method = {RequestMethod.GET,RequestMethod.POST} )
    public String helloGoodBye(@RequestParam String name){
        return "Hello, "+ name+"!!";
    }

    //handles query parameters in the form of /hello?name=value-->this value can be anything
    @GetMapping()
    public String helloQueryParameter(@RequestParam String name){
        return "Hello, "+ name + "!";
    }
    //Handles path parameter in the form of /hello/name-->name is a variable which should match the parameter's variable name
    @GetMapping("{name}")
    public String helloPathParameter(@PathVariable String name){
    //this name variable should match the path variable
        return "Hollla, "+name+"!";
    }
    //Handles a form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hellogoodbye' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
