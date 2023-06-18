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
            <h4 class="text-center"><label class="label label-primary">进度条</label></h4>
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
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample()">默认样式的进度条</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample2()">带有提示标签的进度条</button>
                </div>
                <div class="col-md-1 col-md-offset-2">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample3()">根据情境变化效果</button>
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
            <h4 class="text-center"><label class="label label-primary">默认样式的进度条</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>
                默认样式的进度条
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="progress">
                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                    <span class="sr-only">60% Complete</span>
                </div>
            </div>
        </div>
    </div>
</script>


<script type="text/html" id="testBaseExample2">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">带有提示标签的进度条</label></h4>
        </div>
        <div class="col-md-10">
            <p>将设置了 <code>.sr-only</code> 类的 <code>&lt;span&gt;</code> 标签从进度条组件中移除 类，从而让当前进度显示出来。</p>
        </div>
        <div class="col-md-12">
            <div class="progress">
                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                    60%
                </div>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testBaseExample3">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">根据情境变化效果</label></h4>
        </div>
        <div class="col-md-10">
            <blockquote>
                进度条组件使用与按钮和警告框相同的类，根据不同情境展现相应的效果。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="progress">
                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                    <span class="sr-only">40% Complete (success)</span>
                </div>
            </div>
            <div class="progress">
                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                    <span class="sr-only">20% Complete</span>
                </div>
            </div>
            <div class="progress">
                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                    <span class="sr-only">60% Complete (warning)</span>
                </div>
            </div>
            <div class="progress">
                <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                    <span class="sr-only">80% Complete (danger)</span>
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

    methodObj.testBaseExample2 = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample2").html());
    };

    methodObj.testBaseExample3 = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample3").html());
    };
</script>