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
    var treeData = [{
        "id": 1,
        "text": "杭州",
        "children": [
            {
                "text": "下城区",
                "checked": true
            },
            {
                "text": "西湖区",
                "state": "open",
                "children": [
                    {
                        "text": "超市",
                        "checked": true
                    },
                    {
                        "id": 8,
                        "text": "银行"
                    }
                ]
            }
        ]
    }, {
        "id": 2,
        "text": "北京"
    }];
    //加载
    $('#treeId').tree({
            data: treeData,//json格式数据
            checkbox: true,  //显示勾选框
            dnd: true,
            onClick: function (node) {//单击事件
                //定义一个弹出框
                $.messager.confirm('Confirm', '你确定要删除这天数据吗?', function (r) {
                    if (r) {//r 表示确认 true或者false否定
                        console.log(node);
                        console.log(node.target);
                    }
                });
                $(this).tree('toggle', node.target);
            },
            onLoadSuccess: function () {////加载完成事件
                $.messager.alert('消息', '加载完成!', 'info', function () {
                    console.log("done!");
                });
            },
            onDblClick: function (node) {

            }
        }
    )
</script>
</body>
</html>
