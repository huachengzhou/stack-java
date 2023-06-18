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
            <h4 class="text-center"><label class="label label-primary">导航条</label></h4>
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
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testRouteNavBarExample()">路径导航</button>
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
                <h4 class="text-center"><label class="label label-primary">导航条的可访问性</label></h4>
            </blockquote>
        </div>
        <div class="col-md-12">
            <blockquote>
                务必使用 &lt;nav&gt; 元素，或者，如果使用的是通用的 &lt;div&gt; 元素的话，务必为导航条设置 role=&quot;navigation&quot;
                属性，这样能够让使用辅助设备的用户明确知道这是一个导航区域。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="row">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#">Brand</a>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                                <li><a href="#">Link</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                       aria-haspopup="true" aria-expanded="false">Dropdown <span
                                            class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">One more separated link</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <form class="navbar-form navbar-left">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Search">
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#">Link</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                       aria-haspopup="true" aria-expanded="false">Dropdown <span
                                            class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div><!-- /.navbar-collapse -->
                    </div><!-- /.container-fluid -->
                </nav>
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

<script type="text/html" id="testRouteNavBarExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">路径导航</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>
                在一个带有层次的导航结构中标明当前页面的位置。

                各路径间的分隔符已经自动通过 CSS 的 :before 和 content 属性添加了。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="bs-example" data-example-id="simple-breadcrumbs">
                <ol class="breadcrumb">
                    <li class="active">Home</li>
                </ol>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">Library</li>
                </ol>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Library</a></li>
                    <li class="active">Data</li>
                </ol>
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

    methodObj.testRouteNavBarExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testRouteNavBarExample").html());
    };
</script>