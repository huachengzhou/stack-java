<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .dropdown-toggle {
            height: 34px;
        }
    </style>
</head>
<body>
<div class="container">

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <h4 class="text-center"><label class="label label-primary">导航</label></h4>
        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel" id="methodObj">

        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <div class="row">
                <div class="col-md-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample()">基本实例</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testPillsExample()">胶囊式标签页</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testDropDownExample()">添加下拉菜单</button>
                </div>
            </div>
        </div>
        <div class="col-md-12 panel-body panel">
            <div class="row">

            </div>
        </div>
    </div>


    <div class="row" style="margin-top:50px;">
        <div class="col-sm-12 col-lg-12 col-md-12">
            <div style="text-align: center;">
                <a href="${pageContext.request.contextPath}/sys/bootstrapHome" class="btn btn-primary">返回</a>
            </div>
        </div>
    </div>

</div>
</body>

<script type="text/html" id="testBaseExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">基本实例</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>
                Bootstrap 中的导航组件都依赖同一个 <code>.nav</code> 类，状态类也是共用的。改变修饰类可以改变样式。
            </blockquote>
        </div>
        <div class="col-md-12">
            <blockquote>
                注意 <code>.nav-tabs</code> 类依赖 <code>.nav</code> 基类。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="row">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#">Home</a></li>
                    <li role="presentation"><a href="#">Profile</a></li>
                    <li role="presentation"><a href="#">Messages</a></li>
                </ul>
            </div>
        </div>
    </div>
</script>


<script type="text/html" id="testPillsExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">胶囊式标签页</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>
                HTML 标记相同，但使用 <code>.nav-pills</code> 类：

                Home
            </blockquote>
        </div>
        <div class="col-md-12">
            <ul class="nav nav-pills" role="tablist">
                <li role="presentation" class="active"><a href="#">Home</a></li>
                <li role="presentation"><a href="#">Profile</a></li>
                <li role="presentation"><a href="#">Messages</a></li>
            </ul>
            <hr/>
            <ul class="nav nav-pills nav-stacked" role="tablist">
                <li role="presentation" class="active"><a href="#">Home</a></li>
                <li role="presentation"><a href="#">Profile</a></li>
                <li role="presentation"><a href="#">Messages</a></li>
            </ul>
        </div>
    </div>
</script>

<script type="text/html" id="testDropDownExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">添加下拉菜单</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>
                用一点点额外 HTML 代码并加入下拉菜单插件的 JavaScript 插件即可。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="bs-example">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#">Home</a></li>
                    <li role="presentation"><a href="#">Help</a></li>
                    <li role="presentation" class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                            Dropdown <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <hr/>
            <div class="bs-example">
                <ul class="nav nav-pills" role="tablist">
                    <li role="presentation" class="active"><a href="#">Home</a></li>
                    <li role="presentation"><a href="#">Help</a></li>
                    <li role="presentation" class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            Dropdown <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</script>


<script>

    var methodObj = {};

    methodObj.testBaseExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample").html());
    };

    methodObj.testPillsExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testPillsExample").html());
    };

    methodObj.testDropDownExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testDropDownExample").html());
    };
</script>