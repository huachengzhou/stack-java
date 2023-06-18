package com.blue.spring.controller.model;

import com.blue.common.enums_common.Views;
import com.blue.service.ModelAndViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: zch
 * @Date: 2018/12/5 09:30
 * @Description:
 */
@RequestMapping(value = "/map")
@Controller
public class MapController {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Autowired
    private ModelAndViewService modelAndViewService;

    @RequestMapping(value = "/helloWorld", method = {RequestMethod.GET}, name = "地图 加载")
    public ModelAndView helloWorld() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "helloWorld"));
    }

    @RequestMapping(value = "/lifeCycle", method = {RequestMethod.GET}, name = "地图 生命周期 (创建 加载 销毁 异步)")
    public ModelAndView lifeCycle() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "lifeCycle"));
    }

    @RequestMapping(value = "/property", method = {RequestMethod.GET}, name = "地图 属性")
    public ModelAndView property() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "property"));
    }

    @RequestMapping(value = "/propertyCenter", method = {RequestMethod.GET}, name = "地图 属性(地图中心点)")
    public ModelAndView propertyCenter() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "propertyCenter"));
    }

    @RequestMapping(value = "/usePlugin", method = {RequestMethod.GET}, name = "地图 插件使用")
    public ModelAndView usePlugin() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "usePlugin"));
    }

    @RequestMapping(value = "/location", method = {RequestMethod.GET}, name = "地图 定位")
    public ModelAndView location() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "location"));
    }

    @RequestMapping(value = "/marker", method = {RequestMethod.GET}, name = "地图 点标记 (简单覆盖物的添加与移除)")
    public ModelAndView marker() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "marker"));
    }

    @RequestMapping(value = "/intermediateMarker", method = {RequestMethod.GET}, name = "地图 覆盖物的添加与移除 (中)")
    public ModelAndView intermediateMarker() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "intermediateMarker"));
    }

    @RequestMapping(value = "/seniorMarker", method = {RequestMethod.GET}, name = "地图 覆盖物的添加与移除 (高级)")
    public ModelAndView seniorMarker() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "seniorMarker"));
    }

    @RequestMapping(value = "/markerClusterer", method = {RequestMethod.GET}, name = "地图 覆盖物聚合 (高级)")
    public ModelAndView markerClusterer() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "markerClusterer"));
    }

    @RequestMapping(value = "/markerMyClusterer2", method = {RequestMethod.GET}, name = "地图 2 (高级 聚合)")
    public ModelAndView markerMyClusterer2() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "markerMyClusterer2"));
    }

    @RequestMapping(value = "/markerMyClusterer", method = {RequestMethod.GET}, name = "地图 覆盖物聚合 (高级本地经度和纬度)")
    public ModelAndView markerMyClusterer() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "markerMyClusterer"));
    }

    @RequestMapping(value = "/markerImg", method = {RequestMethod.GET}, name = "地图 覆盖物 (图片)")
    public ModelAndView markerImg() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "markerImg"));
    }

    @RequestMapping(value = "/block", method = {RequestMethod.GET}, name = "地图 楼块")
    public ModelAndView block() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "block"));
    }

    @RequestMapping(value = "/layer", method = {RequestMethod.GET}, name = "地图 图层")
    public ModelAndView layer() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "layer"));
    }

    @RequestMapping(value = "/dataLayer", method = {RequestMethod.GET}, name = "地图 数据图层")
    public ModelAndView dataLayer() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "dataLayer"));
    }

    @RequestMapping(value = "/custom", method = {RequestMethod.GET}, name = "地图 自定义图层")
    public ModelAndView background() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "custom"));
    }

    @RequestMapping(value = "/video", method = {RequestMethod.GET}, name = "地图 视频图层")
    public ModelAndView video() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "video"));
    }

    @RequestMapping(value = "/keywords-search", method = {RequestMethod.GET}, name = "地图 关键字搜索")
    public ModelAndView keywords_search() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "keywords-search"));
    }

    @RequestMapping(value = "/mouseTool", method = {RequestMethod.GET}, name = "鼠标工具-绘制覆盖物")
    public ModelAndView mouseTool() {
        return modelAndViewService.changeModelAndView(String.format("%s%s", Views.GaoDe.getVar(), "mouseTool"));
    }

}
