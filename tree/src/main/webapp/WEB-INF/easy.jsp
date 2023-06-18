<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/bootstrap4.jsp" %>
<html>
<head>
    <title>easy ui home</title>
</head>
<body class="container" style="text-align: center">
<div class="row">

    <div class="col-xl-12 col-sm-12">
        <div class="card" style="margin-top: 20px;">

            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/hello">hello</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/staticTree">静态方式生成 Tree</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/dynamicTree">动态方式生成 Tree</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/lineTree">树线</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/beginEdit">开启编辑</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/contextMenu">树的上下文菜单</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/checkBox">复选框</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/dragDropTree">可拖拉树节点</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/formattingTree">格式化树节点</a></li>
            </ul>

            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/dataGrid/hello">hello</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/dataGrid/basic">基础数据表格</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/dataGrid/transform">数据表格 变换</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/dataGrid/selection">数据表格 获取选择的数据</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/dataGrid/editing">数据表格 单元格编辑</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/easy/dataGrid/treeEditing">数据表格树 单元格编辑</a></li>
            </ul>

            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/home">返回</a></li>
            </ul>

        </div>
    </div>

</div>
</body>
</html>
