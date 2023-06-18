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

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12 style="margin-top:10px;margin-bottom:10px;">
        <div class="easyui-panel">

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

    /*
    加载数据列表
     */
    dataGridObj.loadInit = function () {
        var data = JSON.parse('${treeDtoA}');
        $('#treeId').datagrid({
            data: data,
            iconCls: 'icon-edit',
            singleSelect: true,
            columns: [[
                {field: 'itemid', title: 'Item ID', width: '10%'},
                {
                    field: 'productid',
                    title: 'Product',
                    width: '15%',
                    editor: {type: "numberbox", options: {precision: 2}}
                },
                {field: 'listprice', title: 'List Price', width: '15%', align: 'right'},
                {
                    field: 'listprice',
                    title: 'formatter Price',
                    width: '15%',
                    formatter: function (value, row, index) {

                    }
                },
                {field: 'unitcost', title: 'Unit ', width: '15%', align: 'right'},
                {
                    field: 'attribute', title: 'Attribute', width: '15%', align: 'right',
                    editor: {
                        type: 'text',
                        required: true
                    }
                },
                {field: 'status', title: 'Status', width: '15%', align: 'right'},

            ]],
            onClickRow: function (index, row) {//在用户点击一行的时候触发

            },
            onDblClickRow: function (index, row) {//在用户双击一行的时候触发

            },
            onClickCell: function (index, field, value) {//在用户点击一个单元格的时候触发。
                if (dataGridObj.endEditing()) {
                    $('#treeId').datagrid('selectRow', index)
                        .datagrid('editCell', {index: index, field: field});
                    dataGridObj.editIndex = index;
                }
            },
            onDblClickCell: function (index, field, value) {//在用户双击一个单元格的时候触发。

            },
            onBeforeEdit: function (index, row) {

            },
            onAfterEdit: function (index, row) {

            },
            onCancelEdit: function (index, row) {

            }
        });
    };

    /**
     * 开启编辑
     */
    $.extend($.fn.datagrid.methods, {
        editCell: function (jq, param) {
            return jq.each(function () {
                var opts = $(this).datagrid('options');
                var fields = $(this).datagrid('getColumnFields', true).concat($(this).datagrid('getColumnFields'));
                for (var i = 0; i < fields.length; i++) {
                    var col = $(this).datagrid('getColumnOption', fields[i]);
                    col.editor1 = col.editor;
                    if (fields[i] != param.field) {
                        col.editor = null;
                    }
                }
                $(this).datagrid('beginEdit', param.index);
                for (var i = 0; i < fields.length; i++) {
                    var col = $(this).datagrid('getColumnOption', fields[i]);
                    col.editor = col.editor1;
                }
            });
        }
    });

    dataGridObj.editIndex = undefined;

    /**
     * 结束编辑
     * @returns {boolean}
     */
    dataGridObj.endEditing = function () {
        if (dataGridObj.editIndex == undefined) {
            return true
        }
        if ($('#treeId').datagrid('validateRow', dataGridObj.editIndex)) {
            $('#treeId').datagrid('endEdit', dataGridObj.editIndex);
            dataGridObj.editIndex = undefined;
            return true;
        } else {
            return false;
        }
    };


    $(document).ready(function () {
        dataGridObj.loadInit();
    });
</script>
</body>
</html>
