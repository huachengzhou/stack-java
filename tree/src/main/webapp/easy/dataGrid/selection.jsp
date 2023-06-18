<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <!-- easyUI -->
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/easyloader.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/plugins/jquery.validatebox.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/plugins/jquery.treegrid.js"></script>
    <link href="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/themes/default/easyui.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/themes/icon.css"
          rel="stylesheet">
</head>
<body class="container">
<div class="row">

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="easyui-panel">
            <a href="#" class="easyui-linkbutton" onclick="dataGridObj.getSelected()">GetSelected (获取单个选择的)</a>
            <a href="#" class="easyui-linkbutton" onclick="dataGridObj.getSelections()">GetSelections (获取选择的所有)</a>
        </div>
    </div>

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="easyui-panel">
            <ul id="treeId" class="easyui-tree">

            </ul>
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
<script>
    var dataGridObj = {};

    dataGridObj.loadInit = function () {
        var data = JSON.parse('${treeDtoA}');
        $('#treeId').datagrid({
            data: data,
            columns: [[
                {field: 'itemid', title: 'Item ID', width: '15%'},
                {field: 'productid', title: 'Product', width: '15%'},
                {field: 'listprice', title: 'List Price', width: '25%', align: 'right'},
                {field: 'unitcost', title: 'Unit ', width: '15%', align: 'right'},
                {field: 'attribute', title: 'Attribute', width: '15%', align: 'right'},
                {field: 'status', title: 'Status', width: '15%', align: 'right'}
            ]]
        });
    };

    dataGridObj.getSelected = function () {
        var row = $('#treeId').datagrid('getSelected');
        if (row) {
            $.messager.alert('Info', row.itemid + ":" + row.productid + ":" + row.attribute);
        }
    };

    dataGridObj.getSelections = function () {
        var ss = [];
        var rows = $('#treeId').datagrid('getSelections');
        for (var i = 0; i < rows.length; i++) {
            var row = rows[i];
            ss.push('<span>' + row.itemid + ":" + row.productid + ":" + row.attribute + '</span>');
        }
        $.messager.alert('Info', ss.join('<br/>'));
    };

    $(document).ready(function () {
        dataGridObj.loadInit();
    });
</script>
</body>
</html>
