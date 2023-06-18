<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>jquery tree json方式展示</title>
    <%--<link href="${pageContext.request.contextPath}/assembly/plugins/bootstrap/bootstrap-treeview/bootstrap-treeview.min.css" rel="stylesheet">--%>
    <%--<script src="${pageContext.request.contextPath}/assembly/plugins/bootstrap/bootstrap-treeview/bootstrap-treeview.min.js"></script>--%>

    <%--<script src="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/js/jquery.treegrid.js"></script>--%>
    <%--<link href="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/css/jquery.treegrid.css" rel="stylesheet">--%>
</head>
<body class="container">
<div class="row">
    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div id="tree"></div>
    </div>
    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/jquery">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
<script>

    var data = JSON.parse('${trees}') ;

    $('#tree').treeview({
        data: data,
        levels: 5,
        icon: "fa fa-square",
        color: "#000000",
        backColor: "#FFFFFF" ,
        expandIcon: "fa fa-plus-square",
        collapseIcon: "fa fa-minus-square",
        nodeIcon: "fa fa-square",
        showIcon:true
    });
</script>
</html>
