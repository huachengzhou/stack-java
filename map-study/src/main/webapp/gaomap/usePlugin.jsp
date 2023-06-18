<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7"></script>
    <style>
        body {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height: 600px;" id="container">

            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-12" style="margin-bottom:40px;">
                <ul style="margin-top:20px;margin-right:30px;">
                    <li class="list-group-item"> <a href="${pageContext.request.contextPath}/sys/gaode">返回</a> </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var map = new AMap.Map('container',{
        zoom:12,
        center:[104.06653,30.657326]
    });
    AMap.plugin(['AMap.ToolBar','AMap.Driving','AMap.Scale'],function(){//异步加载插件
        var toolbar = new AMap.ToolBar();
        map.addControl(toolbar);
        var driving = new AMap.Driving();//驾车路线规划
        driving.search(/*参数*/ 2);
    });
</script>
</html>