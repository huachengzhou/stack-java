<%--
  Created by IntelliJ IDEA.
  User: 13426
  Date: 2018/8/26
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>jquery validation home</title>
    <style>
        body {
            text-align: center;
        }

        #sss {
            margin-top: 20px;
        }
    </style>
</head>
<body class="container">
<div class="row">

    <div class="col-xl-12 col-sm-12">
        <div id="sss" class="panel">
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"> <a href="${pageContext.request.contextPath}/jqueryValidation/validationForm">validationForm</a> </li>
                <li class="list-group-item"> <a href="${pageContext.request.contextPath}/jqueryValidation/testA">testA</a> </li>
                <li class="list-group-item"> <a href="${pageContext.request.contextPath}/jqueryValidation/initForm">initForm</a> </li>
                <li class="list-group-item"> <a href="${pageContext.request.contextPath}/sys/home">返回</a> </li>
            </ul>
        </div>
    </div>

</div>
<script>
</script>
</body>
</html>
