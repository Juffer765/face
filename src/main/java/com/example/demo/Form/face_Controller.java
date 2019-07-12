package com.example.demo.Form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class face_Controller {

    @RequestMapping("/")
    String test(){
        return "index";
    }
}
