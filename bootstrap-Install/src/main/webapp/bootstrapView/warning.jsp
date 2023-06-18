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
            <div class="bs-example">
                <div class="alert alert-success" role="alert">
                    <strong>Well done!</strong> You successfully read this important alert message.
                </div>
                <div class="alert alert-info" role="alert">
                    <strong>Heads up!</strong> This alert needs your attention, but it's not super important.
                </div>
                <div class="alert alert-warning" role="alert">
                    <strong>Warning!</strong> Better check yourself, you're not looking too good.
                </div>
                <div class="alert alert-danger" role="alert">
                    <strong>Oh snap!</strong> Change a few things up and try submitting again.
                </div>
            </div>
            <hr/>
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <strong>Warning!</strong> Better check yourself, you're not looking too good.
            </div>
            <hr/>
            <div class="bs-example">
                <div class="alert alert-success" role="alert">
                    <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
                <div class="alert alert-info" role="alert">
                    <strong>Heads up!</strong> This <a href="#" class="alert-link">alert needs your attention</a>, but it's not super important.
                </div>
                <div class="alert alert-warning" role="alert">
                    <strong>Warning!</strong> Better check yourself, you're <a href="#" class="alert-link">not looking too good</a>.
                </div>
                <div class="alert alert-danger" role="alert">
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
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
