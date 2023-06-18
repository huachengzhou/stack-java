<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7"></script>
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
            <div class="col-sm-12" style="margin-top:10px;height:50px;">
                <button class="btn btn-default" onclick="createMap()">创建map</button>
                <button class="btn btn-default" onclick="destroyMap()">销毁map</button>
                <button class="btn btn-default" onclick="asynchronous()">异步map</button>
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
    $(document).ready(function () {
        createMap();
    });

    /**
     * 创建地图
     */
    function createMap() {
        map = new AMap.Map('container', {
            resizeEnable: true,
            center: [104.06653, 30.657326],
            viewMode: '3D',
            pitch: 60,
            rotation: -35,
            // 隐藏默认楼块
            features: ['bg', 'road', 'point'],
            mapStyle: 'amap://styles/light',
            layers: [
                // 高德默认标准图层
                new AMap.TileLayer.Satellite(),
                // 楼块图层
                new AMap.Buildings({
                    zooms: [16, 18],
                    zIndex: 10,
                    heightFactor: 2//2倍于默认高度，3D下有效
                })
            ],
            zoom: 16
        });
        map.on("complete", function () {
            log.success("地图加载完成！");
        });
    }

    /**
     * 销毁地图
     */
    function destroyMap() {
        map && map.destroy();
        log.info("地图已销毁");
    }


    /**
     * 异步地图
     */
    function asynchronous() {
        var url = 'https://webapi.amap.com/maps?v=1.4.11&key=032c70eeb8096f216fd0d4716e8a72b7&callback=onApiLoaded';
        var jsapi = document.createElement('script');
        jsapi.charset = 'utf-8';
        jsapi.src = url;
        document.head.appendChild(jsapi);
        log.info("地图 异步加载开始");
    }

    function onApiLoaded() {
        map = new AMap.Map('container', {
            center: [104.06653, 30.657326],
            zoom: 6
        });
        map.plugin(["AMap.ToolBar"], function () {
            map.addControl(new AMap.ToolBar());
        });
    }

</script>
</html>