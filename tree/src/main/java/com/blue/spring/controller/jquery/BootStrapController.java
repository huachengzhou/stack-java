package com.blue.spring.controller.jquery;

import com.blue.common.ViewEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/bootstrap")
@RestController
public class BootStrapController {

    @GetMapping(value = "/treeview",name = "bootstrap tree")
    public ModelAndView treeview(){
        return new ModelAndView(String.format("%s%s", ViewEnum.Bootstrap.getKey(),  "treeview"));
    }


}
