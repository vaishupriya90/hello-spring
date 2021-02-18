package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
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
    @ResponseBody

    public String goodBye() {
        return "Good Bye, Spring!";
    }

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloGoodBye(@RequestParam String name, Model model) {
        String greetingString = "Welcome, "+ name + "!";
        model.addAttribute("greeting",greetingString);
        return "hello";
    }

    //handles query parameters in the form of /hello?name=value-->this value can be anything
    @GetMapping()
    @ResponseBody
    public String helloQueryParameter(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles path parameter in the form of /hello/name-->name is a variable which should match the parameter's variable name
    @GetMapping("{name}")
    public String helloPathParameter(@PathVariable String name,Model model) {
        //this name variable should match the path variable
        String greetingString = "Hollla, " + name + "!";
        model.addAttribute("greeting",greetingString);
        return "hello";
    }
    //Handles a form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }
    @GetMapping("hello-forLoop")
    public String helloForLoop(Model model){
        List<String> namesList = new ArrayList<>();
        namesList.add("vaishu");
        namesList.add("kalai");
        namesList.add("aaradhya");
        namesList.add("arav");
        model.addAttribute("names",namesList);
        return "hello-forLoop";
    }
}
