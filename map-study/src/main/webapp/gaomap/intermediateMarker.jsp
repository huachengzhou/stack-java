<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assembly/css/other/demo-center.css"/>
    <script src="${pageContext.request.contextPath}/assembly/js/other/demoutils.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/js/other/es5.min.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/js/other/addToolbar.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assembly/css/other/font_873139_0v65kqy674.css"/>
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
            <div class="info">
                <h4>当前地图显示范围（Bounds）</h4>
                <p>NorthEast坐标：<span id="ne" class="lnglat"></span></p>
                <p>SouthWest坐标：<span id="sw" class="lnglat"></span></p>
            </div>
        </div>

        <div class="input-card" style="width:24rem;">
            <h4>添加、删除覆盖物</h4>
            <div class="input-item">
                <label>Marker：</label>
                <button class="btn" id="add-marker" style="margin-right:1rem;">添加Marker</button>
                <button class="btn" id="remove-marker">删除Marker</button>
            </div>
            <div class="input-item">
                <label>Circle：</label>
                <button class="btn" id="add-circle" style="margin-right:1rem;">添加Circle</button>
                <button class="btn" id="remove-circle">删除Circle</button>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height:50px;">
                <label class="label label-info">经度<span class="badge" id="lng">104.222914</span></label>
                <label class="label label-info">纬度<span class="badge" id="lat">30.597945</span></label>
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

    // 构造矢量圆形
    var circle = new AMap.Circle({
        center: new AMap.LngLat("104.066027", "30.582147"), // 圆心位置
        radius: 1000,  //半径
        strokeColor: "#F33",  //线颜色
        strokeOpacity: 1,  //线透明度
        strokeWeight: 3,  //线粗细度
        fillColor: "#ee2200",  //填充颜色
        fillOpacity: 0.35 //填充透明度
    });

    var map = new AMap.Map('container', {
        resizeEnable: true,
        lang: "zh_cn"
    });
    event();
    write();

    /**
     * 创建地图
     */
    function createMap() {
        map = new AMap.Map('container', {
            resizeEnable: true,
            lang: "zh_cn" //可选值：en，zh_en, zh_cn
        });
        map.on("complete", function () {
            write();
            log.success("地图加载完成！");
        });
        event();
    }

    function createMarker(lng,lat) {
        map.add(new AMap.Marker({
            position: [lng, lat],
            icon: "${pageContext.request.contextPath}/assembly/img/other/poi-marker-default.png",
            map: map
        }));
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
            zoom: 6,
            lang: "en" //可选值：en，zh_en, zh_cn
        });
        map.plugin(["AMap.ToolBar"], function () {
            map.addControl(new AMap.ToolBar());
        });
        write();
        event();
    }

    //显示当前地图边界范围坐标
    function write() {
        var bounds = map.getBounds();
        document.querySelector("#ne").innerText = bounds.northeast.toString();
        document.querySelector("#sw").innerText = bounds.southwest.toString();
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
         * 鼠标右键单击事件 并且把此点标记为覆盖物
         */
        map.on('rightclick', function (e) {
            createMarker(e.lnglat.getLng(),e.lnglat.getLat());
            writePosition(e.lnglat.getLng(),e.lnglat.getLat());
        });

        /**
         * 鼠标左键单击事件
         */
        map.on('click', function (e) {
            writePosition(e.lnglat.getLng(),e.lnglat.getLat());
        });
    }

    //事件绑定
    document.querySelector("#add-marker").onclick = function() {
        createMarker(Number(document.getElementById("lng").innerText),Number(document.getElementById("lat").innerText));
        map.setFitView();
    };
    document.querySelector("#remove-marker").onclick = function() {
        var lng = Number(document.getElementById("lng").innerText) ;
        var lat = Number(document.getElementById("lat").innerText) ;
        var arr = [] ;
        $.each(map.getAllOverlays('marker'),function (i,n) {
            var position = n.G.position ;
            arr.push({lng: position.lng, lat: position.lat});
        });
        map.clearMap();
        $.each(arr,function (i,n) {
            if (n.lng != lng && n.lat != lat){
                createMarker(n.lng,n.lat);
            }
        });
        map.setFitView();
    };
    document.querySelector("#add-circle").onclick = function() {
        map.add(circle);
        map.setFitView();
    };
    document.querySelector("#remove-circle").onclick = function() {
        map.remove(circle);
        map.setFitView();
    };


</script>
</html>