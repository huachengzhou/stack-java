
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/bootstrap4.jsp" %>
<html>
<head>
    <title>jquery home</title>
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
        <div id="sss" class="card">
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"> <a href="${pageContext.request.contextPath}/c++/helloWorld"> 函数 与 IDE 学习 </a> </li>

            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"> <a href="${pageContext.request.contextPath}/sys/home">返回</a> </li>
            </ul>
        </div>
    </div>

</div>
<script>
</script>
</body>
</html>
