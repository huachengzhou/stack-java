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

        </div>
    </div>

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="easyui-panel">
            <table id="treeId" class="easyui-treegrid">

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
<script>
    var dataGridObj = {};

    dataGridObj.isNotNull = function (item) {
        if (item) {
            return true;
        }
        return false;
    };

    dataGridObj.getColumns = function () {
        var data = null;
        var precision = 2;//精度
        data = [[
            {field: 'number', title: '序号', width: 50},
            {field: 'name', title: '工程名称', width: 200},
            {
                field: 'currency',
                title: ' 单方造价(元/㎡)',
                width: 100,
                editor: {type: "numberbox", options: {precision: precision}},
                styler: function (value, row, index) {
                    return 'background-color:#F0F0F0;color:red;';
                }
            },
            {
                field: 'valuationDateDegreeCompletion',
                title: '估价时点完工程度',
                width: 110,
                editor: {type: "text", options: {precision: precision}},
                styler: function (value, row, index) {
                    return 'background-color:#F0F0F0;color:red;';
                }
            },
            {field: 'valuationDateCurrency', title: '估价时点单价(元/㎡)', width: 110},
            {
                field: 'continuedConstructionInvestmentCurrency',
                title: '续建投入单价(元/㎡)',
                width: 110,
                editor: {type: "numberbox", options: {precision: precision}},
                styler: function (value, row, index) {
                    return 'background-color:#F0F0F0;color:red;';
                }
            }
        ]];
        return data;
    };

    /*
    加载数据列表
     */
    dataGridObj.loadInit = function () {
        var item = JSON.parse('${treeDtoB}');
        $('#treeId').treegrid({
            iconCls: 'icon-edit',
            nowrap: false,
            width: 1000,
            height: 'auto',
            collapsible: true,
            title: "建安工程费用测算表",
            data: item,
            idField: 'id',//数据表格要有主键
            treeField: 'name',//treegrid 树形结构主键 text
            fitColumns: true,
            striped: true,//显示斑马线
            columns: dataGridObj.getColumns(),
            onAfterEdit: function (row, changes) {//在用户完成编辑一行的时候触发

            }
        });
    };

    dataGridObj.extendOverwrite = function () {
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
                    var ed = $(this).datagrid('getEditor', param);
                    if (ed) {
                        if ($(ed.target).hasClass('textbox-f')) {
                            $(ed.target).textbox('textbox').focus();
                        } else {
                            $(ed.target).focus();
                        }
                    }
                    for (var i = 0; i < fields.length; i++) {
                        var col = $(this).datagrid('getColumnOption', fields[i]);
                        col.editor = col.editor1;
                    }
                });
            },
            enableCellEditing: function (jq) {
                return jq.each(function () {
                    var dg = $(this);
                    var opts = dg.datagrid('options');
                    opts.oldOnClickCell = opts.onClickCell;
                    opts.onClickCell = function (index, field) {
                        editIndexUnderDevelopment = index;
                        if (opts.editIndex != undefined) {
                            if (dg.datagrid('validateRow', opts.editIndex)) {
                                dg.datagrid('endEdit', opts.editIndex);
                                opts.editIndex = undefined;
                            } else {
                                return;
                            }
                        }
                        dg.datagrid('selectRow', index).datagrid('editCell', {
                            index: index,
                            field: field
                        });
                        opts.editIndex = index;
                        opts.oldOnClickCell.call(this, index, field);
                    }
                });
            }
        });
    };


    $(document).ready(function () {
        dataGridObj.loadInit();
        dataGridObj.extendOverwrite();
        $('#treeId').datagrid().datagrid('enableCellEditing');
    });
</script>
</body>
</html>
