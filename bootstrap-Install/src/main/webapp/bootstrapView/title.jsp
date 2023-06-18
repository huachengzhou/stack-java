<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 table-bordered">
            <h4 class="text-center"><label class="label label-primary">标题</label></h4>
        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 table-bordered">
            <h1>h1. Bootstrap heading <small>Secondary text</small></h1>
            <h2>h2. Bootstrap heading <small>Secondary text</small></h2>
            <h3>h3. Bootstrap heading <small>Secondary text</small></h3>
            <h4>h4. Bootstrap heading <small>Secondary text</small></h4>
            <h5>h5. Bootstrap heading <small>Secondary text</small></h5>
            <h6>h6. Bootstrap heading <small>Secondary text</small></h6>
        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 table-bordered">
            <h1 class="h1">h1. Bootstrap heading</h1>
            <h2 class="h2">h2. Bootstrap heading</h2>
            <h3 class="h3">h3. Bootstrap heading</h3>
            <h4 class="h4">h4. Bootstrap heading</h4>
            <h5 class="h5">h5. Bootstrap heading</h5>
            <h6 class="h6">h6. Bootstrap heading</h6>
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
</html>
