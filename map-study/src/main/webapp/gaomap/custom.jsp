<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7&plugin=AMap.CustomLayer,AMap.DistrictSearch"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assembly/css/other/demo-center.css"/>
    <script src="${pageContext.request.contextPath}/assembly/js/other/demoutils.js"></script>
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
            <div class="col-sm-12" style="margin-top:10px;height: 700px;" id="container">

            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-12" style="margin-bottom:40px;">
                <ul style="margin-top:20px;margin-right:30px;">
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/gaode">返回</a></li>
                </ul>
            </div>
        </div>

    </div>
</div>
</body>
<script type="text/javascript">
    var map = null;

    map = new AMap.Map('container', {
        center: [116.306206, 39.975468],
        zooms: [3, 10],
        zoom: 3
    });

    $(document).ready(function () {

        // 获取 canvas 实例
        var canvas = document.createElement('canvas');

        // 将 canvas 宽高设置为地图实例的宽高
        canvas.width = map.getSize().width;
        canvas.height = map.getSize().height;

        var ctx = canvas.getContext("2d");

        ctx.beginPath();
        ctx.arc(40,40,20,Math.PI/180,355*Math.PI/180,false);
        ctx.stroke();
        ctx.closePath();


        ctx.beginPath();
        ctx.arc(150,40,30,0,360*Math.PI/180,true);
        ctx.fill();
        ctx.closePath();
        // 创建一个自定义图层
        var customLayer = new AMap.CustomLayer(canvas, {
            zIndex: 12,
            zooms: [3, 18] // 设置可见级别，[最小级别，最大级别]
        });
        map.add(customLayer);

    });

</script>
</html>