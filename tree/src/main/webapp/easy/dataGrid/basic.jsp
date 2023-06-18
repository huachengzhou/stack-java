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
    var dataGrid = {};

    var data = {
        "total": 28, "rows": [
            {
                "productid": "FI-SW-01",
                "productname": "Koi",
                "unitcost": 10.00,
                "status": "P",
                "listprice": 36.50,
                "attr1": "Large",
                "itemid": "EST-1"
            },
            {
                "productid": "K9-DL-01",
                "productname": "Dalmation",
                "unitcost": 12.00,
                "status": "P",
                "listprice": 18.50,
                "attr1": "Spotted Adult Female",
                "itemid": "EST-10"
            },
            {
                "productid": "RP-SN-01",
                "productname": "Rattlesnake",
                "unitcost": 12.00,
                "status": "P",
                "listprice": 38.50,
                "attr1": "Venomless",
                "itemid": "EST-11"
            },
            {
                "productid": "RP-SN-01",
                "productname": "Rattlesnake",
                "unitcost": 12.00,
                "status": "P",
                "listprice": 26.50,
                "attr1": "Rattleless",
                "itemid": "EST-12"
            },
            {
                "selected": true,
                "productid": "RP-LI-02",
                "productname": "Iguana",
                "unitcost": 12.00,
                "status": "P",
                "listprice": 35.50,
                "attr1": "Green Adult",
                "itemid": "EST-13"
            },
            {
                "productid": "FL-DSH-01",
                "productname": "Manx",
                "unitcost": 12.00,
                "status": "P",
                "listprice": 158.50,
                "attr1": "Tailless",
                "itemid": "EST-14"
            },
            {
                "productid": "FL-DSH-01",
                "productname": "Manx",
                "unitcost": 12.00,
                "status": "P",
                "listprice": 83.50,
                "attr1": "With tail",
                "itemid": "EST-15"
            },
            {
                "productid": "FL-DLH-02",
                "productname": "Persian",
                "unitcost": 12.00,
                "status": "P",
                "listprice": 23.50,
                "attr1": "Adult Female",
                "itemid": "EST-16"
            },
            {
                "productid": "FL-DLH-02",
                "productname": "Persian",
                "unitcost": 12.00,
                "status": "P",
                "listprice": 89.50,
                "attr1": "Adult Male",
                "itemid": "EST-17"
            },
            {
                "productid": "AV-CB-01",
                "productname": "Amazon Parrot",
                "unitcost": 92.00,
                "status": "P",
                "listprice": 63.50,
                "attr1": "Adult Male",
                "itemid": "EST-18"
            }
        ]
    };

    dataGrid.loadInit = function () {
        $('#treeId').datagrid({
            data: data,
            columns: [[
                {field: 'itemid', title: 'Item ID', width: '15%'},
                {field: 'productid', title: 'Product', width: '15%'},
                {field: 'listprice', title: 'List Price', width: '25%', align: 'right'},
                {field: 'unitcost', title: 'Unit ', width: '15%', align: 'right'},
                {field: 'attr1', title: 'Attribute', width: '15%', align: 'right'},
                {field: 'status', title: 'Status', width: '15%', align: 'right'}
            ]]
        });

    };

    $(document).ready(function () {
        dataGrid.loadInit();
    });
</script>
</body>
</html>
