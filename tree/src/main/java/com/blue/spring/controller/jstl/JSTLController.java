package com.blue.spring.controller.jstl;


import com.blue.common.ViewEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/jstl")
@RestController
public class JSTLController {


    @RequestMapping(value = "/elHandle", method = {RequestMethod.GET}, name = "elHandle")
    public ModelAndView baseHandle() {
        return new ModelAndView(String.join("", ViewEnum.JSP.getKey(), "elHandle"));
    }

}
