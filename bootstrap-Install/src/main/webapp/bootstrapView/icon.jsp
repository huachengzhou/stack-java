<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">


    <div class="row">
        <div class="col-md-12">
            <div class="panel-body panel">
                <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-left"></span> <span class="sr-only">左对齐</span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-center"></span> <span class="sr-only">中间对齐</span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-right"></span> <span class="sr-only">右对齐</span></button>
                        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-align-justify"></span> <span class="sr-only">两端对齐</span></button>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-12">
            <div class="panel-body panel">
                <div class="btn-toolbar" role="toolbar">
                    <button type="button" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-star"></span> Star</button>
                    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-star"></span> Star</button>
                    <button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-star"></span> Star</button>
                    <button type="button" class="btn btn-default btn-xs"><span class="glyphicon glyphicon-star"></span> Star</button>
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
<script>


</script>
</html>
