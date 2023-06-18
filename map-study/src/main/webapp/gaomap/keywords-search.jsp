<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.4.11&key=032c70eeb8096f216fd0d4716e8a72b7"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assembly/css/other/demo-center.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assembly/css/other/main1119.css"/>
    <script src="${pageContext.request.contextPath}/assembly/js/other/demoutils.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/js/other/addToolbar.js"></script>
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
            <div class="col-sm-3" style="margin-top:10px;">
                <input type="text" class="" placeholder="关键字">
            </div>
            <div class="col-sm-3" style="margin-top:10px;">
                <button class="btn btn-default" onclick="search(this)">搜索</button>
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
        zoom: 12,//地图显示的缩放级别范在PC上，默认为[3,18]，取值范围[3-18]；在移动设备上，默认为[3,19],取值范围[3-19]
        resizeEnable: true, //是否监控地图容器尺寸变化，默认值为false
        center: [104.06653, 30.657326]
    });

    function search() {
        AMap.service(["AMap.PlaceSearch"], function() {
            //构造地点查询类
            var placeSearch = new AMap.PlaceSearch({
                pageSize: 5, // 单页显示结果条数
                pageIndex: 1, // 页码
                city: "010", // 兴趣点城市
                citylimit: true,  //是否强制限制在设置的城市内搜索
                map: map, // 展现结果的地图实例
                panel: "panel", // 结果列表将在此容器中进行展示。
                autoFitView: true // 是否自动调整地图视野使绘制的 Marker点都处于视口的可见范围
            });
            //关键字查询
            placeSearch.search('四川大学');
        });
    }


</script>
</html>