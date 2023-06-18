<%--
  Created by IntelliJ IDEA.
  User: 13426
  Date: 2018/8/8
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
</head>
<body class="container">
<div class="row">
    <div class="col-xl-12 col-sm-12">
        <h2>分页
        </h2>
        <div class="easyui-panel" title="Basic pagination" style="width:100%;height:200px;padding:10px;">
            <div id="pp" style="background:#efefef;border:1px solid #ccc;"></div>
        </div>
    </div>


    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/easyUiHome">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    var pagination = new Object();
    pagination.loadData = function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/data/httpDataPage",
            type: "get",
            dataType: "json",
            data: {},
            success: function (result) {
                if (result.ret) {
                    pagination.init(result.data);
                }
            },
            error: function (result) {
                console.log("删除数据失败，失败原因:" + result.errmsg);
            }
        })
    }
    pagination.init = function (data) {
        $.ajax({
            url: "${pageContext.request.contextPath}/data/getPageTotal",
            type: "get",
            dataType: "json",
            data: {},
            success: function (result) {
                if (result.ret) {
                    var total = result.data ;
                    $('#pp').pagination({
                        total:total,
                        pageSize:5,
                        layout:['first','links','last','prev']
                    }
                );
                }
            },
            error: function (result) {
                console.log("删除数据失败，失败原因:" + result.errmsg);
            }
        })
    }

    $(function () {
        pagination.loadData();
    });
</script>