
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>easy ui dataGrid 第一个例子</title>
    <!-- easyUI -->
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/easyloader.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/plugins/jquery.validatebox.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/plugins/jquery.treegrid.js"></script>
    <link href="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/themes/default/easyui.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/themes/icon.css" rel="stylesheet">
</head>
<body class="container">
<div class="row">

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="easyui-panel">
            <a href="#" class="easyui-linkbutton" onclick="javascript:$('#dg').datagrid()">Transform</a>
        </div>
    </div>

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="easyui-panel">

            <table id="dg" style="width:700px;height:auto;border:1px solid #ccc;">
                <thead>
                <tr>
                    <th data-options="field:'itemid'">Item ID</th>
                    <th data-options="field:'productid'">Product</th>
                    <th data-options="field:'listprice',align:'right'">List Price</th>
                    <th data-options="field:'attr1'">Attribute</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>EST-1</td><td>FI-SW-01</td><td>36.50</td><td>Large</td>
                </tr>
                <tr>
                    <td>EST-10</td><td>K9-DL-01</td><td>18.50</td><td>Spotted Adult Female</td>
                </tr>
                <tr>
                    <td>EST-11</td><td>RP-SN-01</td><td>28.50</td><td>Venomless</td>
                </tr>
                <tr>
                    <td>EST-12</td><td>RP-SN-01</td><td>26.50</td><td>Rattleless</td>
                </tr>
                <tr>
                    <td>EST-13</td><td>RP-LI-02</td><td>35.50</td><td>Green Adult</td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/easy">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
