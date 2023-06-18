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
            <h4 class="text-center"><label class="label label-primary">按钮组</label></h4>
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
                    <button class="btn-default btn btn-lg" onclick="methodObj.testToolbarExample()">按钮工具栏</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testSizeExample()">尺寸</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testQiaoTaoExample()">嵌套</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testVerticalExample()">垂直排列</button>
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
                基本实例
                Wrap a series of buttons with <code>.btn</code> in <code>.btn-group</code>.
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="btn-group">
                <button type="button" class="btn btn-default">Left</button>
                <button type="button" class="btn btn-default">Middle</button>
                <button type="button" class="btn btn-default">Right</button>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testToolbarExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">按钮工具栏</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                把一组 <code>&lt;div class=&quot;btn-group&quot;&gt;</code> 组合进一个 <code>&lt;div class=&quot;btn-toolbar&quot;&gt;</code>
                中就可以做成更复杂的组件。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="btn-toolbar" role="toolbar" style="margin: 0;">
                <div class="btn-group">
                    <button type="button" class="btn btn-default">1</button>
                    <button type="button" class="btn btn-default">2</button>
                    <button type="button" class="btn btn-default">3</button>
                    <button type="button" class="btn btn-default">4</button>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-default">5</button>
                    <button type="button" class="btn btn-default">6</button>
                    <button type="button" class="btn btn-default">7</button>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-default">8</button>
                </div>
            </div>
        </div>
    </div>
</script>


<script type="text/html" id="testSizeExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">尺寸</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                只要给 <code>
                .btn-group
            </code> 加上 <code>
                .btn-group-*
            </code> 类，就省去为按钮组中的每个按钮都赋予尺寸类了，如果包含了多个按钮组时也适用。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="btn-toolbar col-md-3" role="toolbar">
                    <div class="btn-group btn-group-lg">
                        <button type="button" class="btn btn-default">Left</button>
                        <button type="button" class="btn btn-default">Middle</button>
                        <button type="button" class="btn btn-default">Right</button>
                    </div>
                </div>
                <div class="btn-toolbar col-md-3" role="toolbar">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default">Left</button>
                        <button type="button" class="btn btn-default">Middle</button>
                        <button type="button" class="btn btn-default">Right</button>
                    </div>
                </div>
                <div class="btn-toolbar col-md-3" role="toolbar">
                    <div class="btn-group btn-group-sm">
                        <button type="button" class="btn btn-default">Left</button>
                        <button type="button" class="btn btn-default">Middle</button>
                        <button type="button" class="btn btn-default">Right</button>
                    </div>
                </div>
                <div class="btn-toolbar col-md-3" role="toolbar">
                    <div class="btn-group btn-group-xs">
                        <button type="button" class="btn btn-default">Left</button>
                        <button type="button" class="btn btn-default">Middle</button>
                        <button type="button" class="btn btn-default">Right</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</script>


<script type="text/html" id="testQiaoTaoExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">嵌套</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                想要把下拉菜单混合到一系列按钮中，只须把 <code>.btn-group</code> 放入另一个 <code>.btn-group</code> 中。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="btn-group">
                <button type="button" class="btn btn-default">1</button>
                <button type="button" class="btn btn-default">2</button>

                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        Dropdown
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testVerticalExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">垂直排列</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                让一组按钮垂直堆叠排列显示而不是水平排列。分列式按钮下拉菜单不支持这种方式。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="btn-group-vertical">
                <button type="button" class="btn btn-default">Button</button>
                <button type="button" class="btn btn-default">Button</button>
                <div class="btn-group">
                    <button id="btnGroupVerticalDrop1" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        Dropdown
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="btnGroupVerticalDrop1">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>
                <button type="button" class="btn btn-default">Button</button>
                <button type="button" class="btn btn-default">Button</button>
                <div class="btn-group">
                    <button id="btnGroupVerticalDrop2" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        Dropdown
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="btnGroupVerticalDrop2">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>
                <div class="btn-group">
                    <button id="btnGroupVerticalDrop3" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        Dropdown
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="btnGroupVerticalDrop3">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>
                <div class="btn-group">
                    <button id="btnGroupVerticalDrop4" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        Dropdown
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="btnGroupVerticalDrop4">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>
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

    methodObj.testToolbarExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testToolbarExample").html());
    };

    methodObj.testSizeExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testSizeExample").html());
    };

    methodObj.testQiaoTaoExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testQiaoTaoExample").html());
    };

    methodObj.testVerticalExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testVerticalExample").html());
    };

</script>

</html>
