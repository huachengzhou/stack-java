<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/sucai17.jsp" %>
<html>
<head>
    <title></title>
    <!-- 加载地图JS API 脚本 -->
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7"></script>
</head>
<body class="nav-md footer_fixed">
<div class="container body">
    <div class="main_container">
        <div class="right_col" role="main" style="margin-left: 0">

            <div class="x_panel">
                <div class="x_content">
                    <div class="form-group">
                        <div class="col-sm-12" id="container" style="height:1200px;">

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>

<script>

    var map = new AMap.Map('container', {
        resizeEnable: true, //是否监控地图容器尺寸变化
        zoom: 11, //初始化地图层级
        center: [116.397428, 39.90923] //初始化地图中心点
    });

</script>

</html>
