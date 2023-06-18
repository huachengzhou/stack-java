package com.blue.spring.controller.core;

import com.blue.HttpResult;
import com.blue.entity.BookExample;
import com.blue.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: zch
 * @Date: 2018/8/26 09:59
 * @Description:
 */
@RequestMapping(value = "/data")
@Controller
public class HttpDataController {

    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/httpDataPage", name = "分页数据",method = {RequestMethod.GET})
    public HttpResult page(@RequestParam(defaultValue = "5")int pageSize, @RequestParam(defaultValue = "1")int page){
        try {
            List<BookExample> bookExamples = messageService.bookExampleList(pageSize,page);
            return HttpResult.newCorrectResult(bookExamples);
        } catch (Exception e1) {
            return HttpResult.newErrorResult(e1.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getPageTotal", name = "获取数据记录总数",method = {RequestMethod.GET})
    public HttpResult getPageTotal(){
        try {
            return HttpResult.newCorrectResult(messageService.getTotal());
        } catch (Exception e1) {
            return HttpResult.newErrorResult(e1.getMessage());
        }
    }
}
