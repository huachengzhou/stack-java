<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">


    <div class="row">

        <div class="col-md-12" style="margin-top: 20px;">
            <blockquote>
                页头组件能够为 h1 标签增加适当的空间，并且与页面的其他部分形成一定的分隔。它支持 h1 标签内内嵌 small 元素的默认效果，还支持大部分其他组件（需要增加一些额外的样式）。
            </blockquote>
        </div>

        <div class="col-md-12">
            <div class="page-header">
                <h1>Example page header
                    <small>Subtext for header</small>
                </h1>
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
