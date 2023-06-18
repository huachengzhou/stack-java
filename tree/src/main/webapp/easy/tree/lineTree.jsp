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
            "text": "My Documents",
            "children": [{
                "id": 11,
                "text": "Photos",
                "state": "closed",
                "children": [{
                    "id": 111,
                    "text": "Friend"
                }, {
                    "id": 112,
                    "text": "Wife"
                }, {
                    "id": 113,
                    "text": "Company"
                }]
            }, {
                "id": 12,
                "text": "Program Files",
                "children": [{
                    "id": 121,
                    "text": "Intel"
                }, {
                    "id": 122,
                    "text": "Java",
                    "attributes": {
                        "p1": "Custom Attribute1",
                        "p2": "Custom Attribute2"
                    }
                }, {
                    "id": 123,
                    "text": "Microsoft Office"
                }, {
                    "id": 124,
                    "text": "Games",
                    "checked": true
                }]
            }, {
                "id": 13,
                "text": "index.html"
            }, {
                "id": 14,
                "text": "about.html"
            }, {
                "id": 15,
                "text": "welcome.html"
            }]
        }]
    ;
    //加载
    $('#treeId').tree({
            data: treeData,//json格式数据
            checkbox: true,  //显示勾选框
            dnd: true,
            lines: true,
            onClick: function (node) {//单击事件
                console.log(node);
            },
            onLoadSuccess: function () {////加载完成事件

            },
            onDblClick: function (node) {

            }
        }
    )
</script>
</body>
</html>
