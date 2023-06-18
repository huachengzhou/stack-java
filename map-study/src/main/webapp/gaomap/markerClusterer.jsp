<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/assembly/js/other/china.js"></script>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7&plugin=AMap.MarkerClusterer"></script>
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
            <div class="col-sm-12 map" style="margin-top:10px;height: 700px;" id="container">

            </div>
        </div>

        <div class="input-card">
            <h4>聚合点效果切换</h4>
            <div class="input-item">
                <input type="button" class="btn" value="默认样式" id="add0" onclick='addCluster(0)'/>
                <input type="button" class="btn" value="自定义图标" id="add1" onclick='addCluster(1)'/>
                <input type="button" class="btn" value="完全自定义" id="add2" onclick='addCluster(2)'/>
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
    var cluster, markers = [];
    $(document).ready(function () {
        createMap();
        addCluster(2);
    });

    /**
     * 创建地图
     */
    function createMap() {
        map = new AMap.Map('container', {
            center: [105, 34],
            zoom: 4
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
            center: [105, 34],
            zoom: 4
        });
        map.plugin(["AMap.ToolBar"], function () {
            map.addControl(new AMap.ToolBar());
        });
    }

    for (var i = 0; i < points.length; i += 1) {
        markers.push(new AMap.Marker({
            position: points[i]['lnglat'],
            content: '<div style="background-color: hsla(180, 100%, 50%, 0.7); height: 24px; width: 24px; border: 1px solid hsl(180, 100%, 40%); border-radius: 12px; box-shadow: hsl(180, 100%, 50%) 0px 0px 1px;"></div>',
            offset: new AMap.Pixel(-15, -15)
        }))
    }

    var count = markers.length;
    var _renderCluserMarker = function (context) {
        var factor = Math.pow(context.count / count, 1 / 18);
        var div = document.createElement('div');
        var Hue = 180 - factor * 180;
        var bgColor = 'hsla(' + Hue + ',100%,50%,0.7)';
        var fontColor = 'hsla(' + Hue + ',100%,20%,1)';
        var borderColor = 'hsla(' + Hue + ',100%,40%,1)';
        var shadowColor = 'hsla(' + Hue + ',100%,50%,1)';
        div.style.backgroundColor = bgColor;
        var size = Math.round(30 + Math.pow(context.count / count, 1 / 5) * 20);
        div.style.width = div.style.height = size + 'px';
        div.style.border = 'solid 1px ' + borderColor;
        div.style.borderRadius = size / 2 + 'px';
        div.style.boxShadow = '0 0 1px ' + shadowColor;
        div.innerHTML = context.count;
        div.style.lineHeight = size + 'px';
        div.style.color = fontColor;
        div.style.fontSize = '14px';
        div.style.textAlign = 'center';
        context.marker.setOffset(new AMap.Pixel(-size / 2, -size / 2));
        context.marker.setContent(div)
    };

    function addCluster(tag) {
        if (cluster) {
            cluster.setMap(null);
        }
        if (tag == 2) {//完全自定义
            cluster = new AMap.MarkerClusterer(map, markers, {
                gridSize: 80,
                renderCluserMarker: _renderCluserMarker
            });
        } else if (tag == 1) {//自定义图标
            var sts = [{
                url: "https://a.amap.com/jsapi_demos/static/images/blue.png",
                size: new AMap.Size(32, 32),
                offset: new AMap.Pixel(-16, -16)
            }, {
                url: "https://a.amap.com/jsapi_demos/static/images/green.png",
                size: new AMap.Size(32, 32),
                offset: new AMap.Pixel(-16, -16)
            }, {
                url: "https://a.amap.com/jsapi_demos/static/images/orange.png",
                size: new AMap.Size(36, 36),
                offset: new AMap.Pixel(-18, -18)
            }, {
                url: "https://a.amap.com/jsapi_demos/static/images/red.png",
                size: new AMap.Size(48, 48),
                offset: new AMap.Pixel(-24, -24)
            }, {
                url: "https://a.amap.com/jsapi_demos/static/images/darkRed.png",
                size: new AMap.Size(48, 48),
                offset: new AMap.Pixel(-24, -24)
            }];
            cluster = new AMap.MarkerClusterer(map, markers, {
                styles: sts,
                gridSize: 80
            });
        } else {//默认样式
            cluster = new AMap.MarkerClusterer(map, markers, {gridSize: 80});
        }
    }

</script>
</html>