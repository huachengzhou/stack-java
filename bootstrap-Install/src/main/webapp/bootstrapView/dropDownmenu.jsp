<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <h4 class="text-center"><label class="label label-primary">下拉菜单</label></h4>
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
                    <button class="btn-default btn btn-lg" onclick="methodObj.testTileExample()">标题</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testDividerExample()">分割线</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testAlignExample()">对齐</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testDisabledExample()">禁用</button>
                </div>
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
        <div class="col-md-12">
            <blockquote>
                将下拉菜单触发器和下拉菜单都包裹在 <code>.dropdown</code> 里，或者另一个声明了 <code>position: relative;</code>; 的元素。然后加入组成菜单的 HTML
                代码。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                    Dropdown
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-12">
            <blockquote>
                通过为下拉菜单的父元素设置 <code>.dropup</code> 类，可以让菜单向上弹出（默认是向下弹出的）。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="dropup">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropup
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                </ul>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testTileExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">标题</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                在任何下拉菜单中均可通过添加标题来标明一组动作。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                    Dropdown
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li role="presentation" class="dropdown-header">Dropdown header</li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
                    <li role="presentation" class="dropdown-header">Dropdown header</li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
                </ul>
            </div>
        </div>
    </div>
</script>


<script type="text/html" id="testDividerExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">分割线</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                为下拉菜单添加一条分割线，用于将多个链接分组。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="dropdown" style="width: 250px">
                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                    Dropdown
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenuDivider">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
                    <li role="presentation" class="divider"></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
                </ul>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testAlignExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">对齐</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                默认情况下，下拉菜单自动沿着父元素的上沿和左侧被定位为 100% 宽度。 为 <code>.dropdown-menu</code> 添加 <code>.dropdown-menu-right</code>
                类可以让菜单右对齐。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="dropdown" style="width: 250px">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1EEEE"
                        data-toggle="dropdown">
                    Dropdown
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu1EEEE">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
                </ul>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testDisabledExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">禁用的菜单项</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                为下拉菜单中的 &lt;li&gt; 元素添加 <code>.disabled</code> 类，从而禁用相应的菜单项。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="dropdown" style="width: 250px">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1RYYRER"
                        data-toggle="dropdown">
                    Dropdown
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1RYYRER">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Regular link</a></li>
                    <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Disabled link</a>
                    </li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another link</a></li>
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

    methodObj.testTileExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testTileExample").html());
    };

    methodObj.testDividerExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testDividerExample").html());
    };

    methodObj.testAlignExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testAlignExample").html());
    };

    methodObj.testDisabledExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testDisabledExample").html());
    };

</script>

</html>
