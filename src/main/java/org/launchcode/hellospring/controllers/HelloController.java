package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }
// lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

    //Handles request of the form /hello?name=LaunchCode
// lives at /hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles request of the form /hello/LaunchCode
// lives at /hello/name
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // lives at hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type= 'text' name='name'>" +
                "<select name='language'>" +
                "<option value='1'>English</option>" +
                "<option value='2'>Chinese</option>" +
                "<option value='3'>Korean</option>" +
                "<option value='4'>French</option>" +
                "<option value='5'>Spanish</option>" +
                "</select>" +
                "<input type='submit' value='Great me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method = RequestMethod.POST, value = "hello")
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam int language){
        return createMessage(name, language);
    }

    public static String createMessage(String name, int language){
        String greeting = "";

        if (language == 1){
            greeting = "<h1>Helllo " + name +"</h1>";
        }
        if (language == 2){
            greeting = "<h1>Ni Hao " + name +"</h1>";
        }
        if (language == 3){
            greeting = "<h2>Ahn young haseyo " + name+"</h2>";
        }
        if (language == 4){
            greeting = "<h2>Bonjour " + name+"</h2>";
        }
        if (language == 5){
            greeting = "<h3>Hola " + name+"</h3>";
        }

        return greeting;
    }
}