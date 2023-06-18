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
        <button class="btn-default btn" onclick="obj.loadA()">easyui 智能渲染</button>
    </div>
    <div class="col-xl-12 col-sm-12">
        <div id="box">
            <div class="easyui-dialog" title="标题" style="width:400px;height:200px">
                内容部分
            </div>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/easyUiHome">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
<script>
    var obj = new Object();
    obj.loadA = function () {
    };
    $(function () {
        $.parser.parse('#box');
    });
    $.parser.auto = false;
    $.parser.onComplete = function () {
        alert('UI解析完毕！');
    };
</script>
</html>
