<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .dropdown-toggle{
            height: 34px;
        }
    </style>
</head>
<body>
<div class="container">

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <h4 class="text-center"><label class="label label-primary">输入框组</label></h4>
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
                    <button class="btn-default btn btn-lg" onclick="methodObj.testButtonExample()">作为额外元素的按钮</button>
                </div>
                <div class="col-md-1 col-md-offset-2">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testDropDownExample()">作为额外元素的按钮式下拉菜单
                    </button>
                </div>
                <div class="col-md-1 col-md-offset-4">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testSplitExample()">
                        作为额外元素的分裂式按钮下拉菜单
                    </button>
                </div>
            </div>
        </div>
        <div class="col-md-12 panel-body panel">
            <div class="row">
                <div class="col-md-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testCheckExample()">作为额外元素的多选框和单选框</button>
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
                通过在文本输入框 <input> 前面、后面或是两边加上文字或按钮，可以实现对表单控件的扩展。为 <code>.input-group</code> 赋予
                <code>.input-group-addon</code> 或 <code>.input-group-btn</code>
                类，可以给 <code>.form-control</code> 的前面或后面添加额外的元素。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="row">
                <form class="form-horizontal">
                    <div class="col-md-10 form-group col-md-offset-2">
                        <div class="input-group">
                            <span class="input-group-addon">@</span>
                            <input type="text" class="form-control" placeholder="Username">
                        </div>
                    </div>
                    <div class="col-md-10 form-group col-md-offset-2">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-addon">.00</span>
                        </div>
                    </div>
                    <div class="col-md-10 form-group col-md-offset-2">
                        <div class="input-group">
                            <span class="input-group-addon">$</span>
                            <input type="text" class="form-control">
                            <span class="input-group-addon">.00</span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</script>


<script type="text/html" id="testButtonExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">作为额外元素的按钮</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                为输入框组添加按钮需要额外添加一层嵌套，不是 <code>.input-group-addon</code>，
                而是添加 <code>.input-group-btn</code> 来包裹按钮元素。由于不同浏览器的默认样式无法被统一的重新赋值，所以才需要这样做。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6">
                    <div class="input-group">
                          <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                          </span>
                        <input type="text" class="form-control">
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
                <div class="col-md-6">
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Go!</button>
                        </span>
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
            </div>
        </div>
    </div>
</script>


<script type="text/html" id="testDropDownExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">作为额外元素的按钮式下拉菜单</label></h4>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-lg-6">
                    <div class="input-group">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Action
                                <span class="caret"></span></button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div><!-- /btn-group -->
                        <input type="text" class="form-control">
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
                <div class="col-lg-6">
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Action
                                <span class="caret"></span></button>
                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div><!-- /btn-group -->
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
            </div><!-- /.row -->

        </div>
    </div>
</script>


<script type="text/html" id="testSplitExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">作为额外元素的分裂式按钮下拉菜单</label></h4>
        </div>
        <div class="col-md-12">

            <div class="row">
                <div class="col-lg-6">
                    <div class="input-group">
                        <div class="input-group-btn open">
                            <button type="button" class="btn btn-default" tabindex="-1">Action</button>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" tabindex="-1" aria-expanded="true">
                                <span class="caret"></span>
                                <span class="sr-only">Toggle Dropdown</span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                        <input type="text" class="form-control">
                    </div><!-- /.input-group -->
                </div><!-- /.col-lg-6 -->
                <div class="col-lg-6">
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default" tabindex="-1">Action</button>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" tabindex="-1">
                                <span class="caret"></span>
                                <span class="sr-only">Toggle Dropdown</span>
                            </button>
                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                    </div><!-- /.input-group -->
                </div><!-- /.col-lg-6 -->
            </div><!-- /.row -->

        </div>
    </div>
</script>

<script type="text/html" id="testCheckExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">作为额外元素的多选框和单选框</label></h4>
        </div>
        <div class="col-md-12">

            <div class="row">
                <div class="col-lg-6">
                    <div class="input-group">
                      <span class="input-group-addon">
                        <input type="checkbox">
                      </span>
                        <input type="text" class="form-control">
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
                <div class="col-lg-6">
                    <div class="input-group">
                      <span class="input-group-addon">
                        <input type="radio">
                      </span>
                        <input type="text" class="form-control">
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
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

    methodObj.testButtonExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testButtonExample").html());
    };

    methodObj.testDropDownExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testDropDownExample").html());
    };

    methodObj.testSplitExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testSplitExample").html());
    };

    methodObj.testCheckExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testCheckExample").html());
    };


</script>

</html>
