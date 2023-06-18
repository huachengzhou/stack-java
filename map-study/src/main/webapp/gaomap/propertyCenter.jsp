<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assembly/css/other/demo-center.css"/>
    <script src="${pageContext.request.contextPath}/assembly/js/other/demoutils.js"></script>
    <script type="text/javascript" src="https://a.amap.com/jsapi_demos/static/demo-center/js/underscore-min.js" ></script>
    <script type="text/javascript" src="https://a.amap.com/jsapi_demos/static/demo-center/js/backbone-min.js" ></script>
    <script type="text/javascript" src='https://a.amap.com/jsapi_demos/static/demo-center/js/prety-json.js'></script>
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

        <div class="info">
            <h4>获取地图级别与中心点坐标</h4>
            <p>当前级别：<span id="map-zoom">11</span></p>
            <p>当前中心点：<span id="map-center">121.498586,31.239637</span></p>
            <h4>当前所在行政区信息</h4>
            <p><span id="map-city"></span></p>
        </div>

        <div class="form-group">
            <div class="col-sm-12" style="margin-top:30px;height:50px;">
                <label class="label label-info">经度<span class="badge" id="lng">104.05904</span></label>
                <label class="label label-info">纬度<span class="badge" id="lat">30.616186</span></label>
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
            center: [104.05904, 30.616186], //初始地图中心点
        });
        map.on("complete", function () {
            log.success("地图加载完成！");
        });
        event();
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
            center: [117.000923, 36.675807],
            zoom: 6
        });
        map.plugin(["AMap.ToolBar"], function () {
            map.addControl(new AMap.ToolBar());
        });
        event();
    }


    /**
     * 写经纬度
     **/
    function writePosition(lng,lat) {
        //经度
        document.getElementById("lng").innerText = lng;
        //纬度
        document.getElementById("lat").innerText = lat;
    }


    function event() {
        /**
         * 鼠标左键单击事件
         */
        map.on('click', function (e) {
            writePosition(e.lnglat.getLng(),e.lnglat.getLat());
        });
        map.on('rightclick', function (e) {
            map.setCenter([e.lnglat.getLng(), e.lnglat.getLat()]); //设置地图中心点
            writePosition(e.lnglat.getLng(),e.lnglat.getLat());
            logMapinfo();
            logMapinfoA();
        });
        logMapinfo();
        logMapinfoA();
    }

    //显示地图层级与中心点信息
    function logMapinfo(){
        var zoom = map.getZoom(); //获取当前地图级别
        var center = map.getCenter(); //获取当前地图中心位置
        document.querySelector("#map-zoom").innerText = zoom;
        document.querySelector("#map-center").innerText = center.toString();
    };

    //获取并展示当前城市信息
    function logMapinfoA(){
        map.getCity( function(info){
            var node = new PrettyJSON.view.Node({
                el: document.querySelector("#map-city"),
                data: info
            });
        });
    };

</script>
</html>