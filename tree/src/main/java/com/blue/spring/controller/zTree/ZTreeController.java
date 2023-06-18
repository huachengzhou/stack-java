package com.blue.spring.controller.zTree;

import com.blue.common.ViewEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/ztree")
@RestController
public class ZTreeController {

    @RequestMapping(value = "/baseHandle", method = {RequestMethod.GET}, name = "baseHandle")
    public ModelAndView baseHandle() {
        return new ModelAndView(String.join("", ViewEnum.ZTREE.getKey(), "baseHandle"));
    }

    @GetMapping(value = "/select_menu_radio", name = "带 radio 的单选")
    public ModelAndView select_menu_radio() {
        return new ModelAndView(String.join("", ViewEnum.ZTREE.getKey(), "select_menu_radio"));
    }

    @GetMapping(value = "/select_menu_checkbox", name = "带 checkbox 的多选")
    public ModelAndView select_menu_checkbox() {
        return new ModelAndView(String.join("", ViewEnum.ZTREE.getKey(), "select_menu_checkbox"));
    }

    @GetMapping(value = "/fuzzySearch", name = "根据关键字模糊查找节点")
    public ModelAndView fuzzySearch() {
        return new ModelAndView(String.join("", ViewEnum.ZTREE.getKey(), "fuzzySearch"));
    }

}
