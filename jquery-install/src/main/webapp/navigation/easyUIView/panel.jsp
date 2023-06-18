<%--
  Created by IntelliJ IDEA.
  User: 13426
  Date: 2018/8/8
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
</head>
<body class="container">
<div class="row">
    <div class="col-xl-12 col-sm-12">
        <h2>基础面板 (流式)
            <a href="#" class="easyui-linkbutton" onclick="javascript:$('#pA').panel('open')">Open</a>
            <a href="#" class="easyui-linkbutton" onclick="javascript:$('#pA').panel('close')">Close</a>
        </h2>
        <div id="pA" class="easyui-panel" title="Basic Panel" style="width:100%;height:200px;padding:10px;">
            <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
            <ul>
                <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
                <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
                <li>complete framework for HTML5 web page.</li>
                <li>easyui save your time and scales while developing your products.</li>
                <li>easyui is very easy but powerful.</li>
            </ul>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <h2>面板工具 panel tool
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#pB').panel('open')">Open</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#pB').panel('close')">Close</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#pB').panel('expand',true)">Expand</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#pB').panel('collapse',true)">Collapse</a>
        </h2>
        <div class="easyui-panel" style="height:350px;padding:5px;">
            <div id="pB" class="easyui-panel" title="Panel Tools" style="width:600px;height:200px;padding:10px;"
                 data-options="iconCls:'icon-save',collapsible:true,minimizable:true,maximizable:true,closable:true">
                <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
                <ul>
                    <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                    <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
                    <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
                    <li>complete framework for HTML5 web page.</li>
                    <li>easyui save your time and scales while developing your products.</li>
                    <li>easyui is very easy but powerful.</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <h2>用户面板工具 Custom Panel Tools
            <div id="p_Tool">
                <a href="javascript:void(0)" class="icon-add" onclick="javascript:alert('add')"></a>
                <a href="javascript:void(0)" class="icon-edit" onclick="javascript:alert('edit')"></a>
                <a href="javascript:void(0)" class="icon-cut" onclick="javascript:alert('cut')"></a>
                <a href="javascript:void(0)" class="icon-help" onclick="javascript:alert('help')"></a>
            </div>
        </h2>
        <div class="easyui-panel" title="Custom Panel Tools" style="width:700px;height:200px;padding:10px;"
             data-options="iconCls:'icon-save',closable:true,tools:'#p_Tool'">
            <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
            <ul>
                <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
                <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
                <li>complete framework for HTML5 web page.</li>
                <li>easyui save your time and scales while developing your products.</li>
                <li>easyui is very easy but powerful.</li>
            </ul>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <h2>面板嵌套Nested Panel</h2>
        <div class="easyui-panel" title="Nested Panel" style="width:700px;height:200px;padding:10px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'west',split:true" style="width:100px;padding:10px">
                    Left Content
                </div>
                <div data-options="region:'east'" style="width:100px;padding:10px">
                    Right Content
                </div>
                <div data-options="region:'center'" style="padding:10px">
                    Right Content
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/easyUiHome">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
