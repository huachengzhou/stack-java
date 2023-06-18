package com.blue.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.blue.common.page.PageRequest;
import com.blue.dal.entity.UserBoot;
import com.blue.service.UserBootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tool.utils.FormatUtils;
import tool.web.BootstrapTableVo;
import tool.web.HttpResult;


/**
 * @createDate 2018/12/12
 **/
@RequestMapping(value = "/api/user")
@RestController
public class RestfulController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserBootService userBootService;

    @RequestMapping(value = "/index",method = {RequestMethod.GET})
    public ModelAndView index(){
        return new ModelAndView(String.format("%s%s","restful/","index"));
    }

    @GetMapping(value = "/get/{id}", name = "get")
    public HttpResult get(@PathVariable(name = "id") Integer id) {
        try {
            UserBoot userBoot = userBootService.getUserBoot(id);
            return HttpResult.newCorrectResult(200, userBoot);
        } catch (Exception e) {
            logger.error("error", e);
            return HttpResult.newErrorResult(500, e);
        }
    }

    @PostMapping(value = "/save", name = "save")
    public HttpResult save(String formData) {
        try {
            UserBoot userBoot= JSONObject.parseObject(formData,UserBoot.class) ;
            userBootService.saveUserBoot(userBoot);
            return HttpResult.newCorrectResult(200,userBoot);
        } catch (Exception e) {
            logger.error("error", e);
            return HttpResult.newErrorResult(500, e);
        }
    }

    @DeleteMapping(value = "/delete/{id}", name = "delete")
    public HttpResult delete(@PathVariable(name = "id") String id) {
        try {
            FormatUtils.transformString2List(id).forEach(s -> userBootService.deleteUserBoot(Integer.parseInt(s)));
            return HttpResult.newCorrectResult(200);
        } catch (Exception e) {
            logger.error("error", e);
            return HttpResult.newErrorResult(500, e);
        }
    }

    @PutMapping(value = "/put/{id}", name = "put")
    public HttpResult update(@PathVariable(name = "id") String formData) {
        try {
            UserBoot userBoot= JSONObject.parseObject(formData,UserBoot.class) ;
            userBootService.updateUserBoot(userBoot);
            return HttpResult.newCorrectResult(200,userBoot);
        } catch (Exception e) {
            logger.error("error", e);
            return HttpResult.newErrorResult(500, e);
        }
    }

    @GetMapping(value="/getBootstrapTableVo")
    public BootstrapTableVo getBootstrapTableVo(PageRequest pageQuery) {
        return userBootService.getBootstrapTableVoTo(pageQuery);
    }


}
