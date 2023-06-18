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
            <h4 class="text-center"><label class="label label-primary">面板</label></h4>
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
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample2()">带标题的面版</button>
                </div>
                <div class="col-md-1 col-md-offset-2">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample3()">带脚注的面版</button>
                </div>
                <div class="col-md-1 col-md-offset-2">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample4()">情境效果</button>
                </div>
            </div>
        </div>
        <div class="col-md-12 panel-body panel">
            <div class="row">
                <div class="col-md-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample5()">带表格的面版</button>
                </div>
                <div class="col-md-1 col-md-offset-2">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample6()">带列表组的面版</button>
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
        <div class="col-md-10">
            <blockquote>
                基本实例
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    Basic panel example
                </div>
            </div>
        </div>
    </div>
</script>


<script type="text/html" id="testBaseExample2">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">带标题的面版</label></h4>
        </div>
        <div class="col-md-10">

        </div>
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">Panel heading without title</div>
                <div class="panel-body">
                    Panel content
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Panel title</h3>
                </div>
                <div class="panel-body">
                    Panel content
                </div>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testBaseExample3">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">带脚注的面版</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>

            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    Panel content
                </div>
                <div class="panel-footer">Panel footer</div>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testBaseExample4">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">情境效果</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>

            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="bs-example">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel title</h3>
                    </div>
                    <div class="panel-body">
                        Panel content
                    </div>
                </div>
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel title</h3>
                    </div>
                    <div class="panel-body">
                        Panel content
                    </div>
                </div>
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel title</h3>
                    </div>
                    <div class="panel-body">
                        Panel content
                    </div>
                </div>
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel title</h3>
                    </div>
                    <div class="panel-body">
                        Panel content
                    </div>
                </div>
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel title</h3>
                    </div>
                    <div class="panel-body">
                        Panel content
                    </div>
                </div>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testBaseExample5">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">带表格的面版</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>

            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Panel heading</div>
                <div class="panel-body">
                    <p>Some default panel content here. Nulla vitae elit libero, a pharetra augue. Aenean lacinia bibendum nulla sed consectetur. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </div>

                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Username</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Larry</td>
                        <td>the Bird</td>
                        <td>@twitter</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <hr/>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Panel heading</div>

                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Username</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Larry</td>
                        <td>the Bird</td>
                        <td>@twitter</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testBaseExample6">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">带列表组的面版</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>

            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Panel heading</div>
                <div class="panel-body">
                    <p>Some default panel content here. Nulla vitae elit libero, a pharetra augue. Aenean lacinia bibendum nulla sed consectetur. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </div>

                <!-- List group -->
                <ul class="list-group">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Morbi leo risus</li>
                    <li class="list-group-item">Porta ac consectetur ac</li>
                    <li class="list-group-item">Vestibulum at eros</li>
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

    methodObj.testBaseExample2 = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample2").html());
    };

    methodObj.testBaseExample3 = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample3").html());
    };

    methodObj.testBaseExample4 = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample4").html());
    };

    methodObj.testBaseExample5 = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample5").html());
    };

    methodObj.testBaseExample6 = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample6").html());
    };
</script>