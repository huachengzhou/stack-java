<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/bootstrap4.jsp" %>
<html>
<head>
    <title>ztree</title>
</head>
<body class="container" style="text-align: center">
<div class="row">

    <div class="col-xl-12 col-sm-12 col-lg-12 col-md-12">
        <div class="card" style="margin-top: 20px;">

            <ul style="margin-top:20px;margin-right:30px;">

                <li class="list-group-item"><a href="${pageContext.request.contextPath}/ztree/baseHandle">ztree 基本操作</a></li>

                <li class="list-group-item"><a href="${pageContext.request.contextPath}/ztree/select_menu_radio">带 radio 的单选</a></li>

                <li class="list-group-item"><a href="${pageContext.request.contextPath}/ztree/select_menu_checkbox">带 checkbox 的多选</a></li>

                <li class="list-group-item"><a href="${pageContext.request.contextPath}/ztree/fuzzySearch">根据关键字模糊查找节点</a></li>
            </ul>

            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/home">返回</a></li>
            </ul>

        </div>
    </div>

</div>
</body>
</html>
