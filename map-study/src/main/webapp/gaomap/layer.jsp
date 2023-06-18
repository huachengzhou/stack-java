<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7&plugin=Map3D,AMap.DistrictLayer,AMap.DistrictSearch"></script>
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
                <button class="btn btn-default" onclick="createMap()">3D 楼块</button>
                <button class="btn btn-default" onclick="fun()">函数栅格</button>
                <button class="btn btn-default" onclick="XYZ()">XYZ栅格图层</button>
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

    var imageLayer = new AMap.ImageLayer({
        url: '${pageContext.request.contextPath}/assembly/img/other/dongwuyuan.jpg',
        bounds: new AMap.Bounds(
            [116.327911, 39.939229],
            [116.342659, 39.946275]
        ),
        zooms: [15, 18]
    });

    $(document).ready(function () {
        createMap();
    });

    /**
     * 创建地图
     */
    function createMap() {
        map = new AMap.Map('container', {
            resizeEnable: true,
            center: [116.33719, 39.942384],
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
                }),
                imageLayer
            ],
            zoom: 16
        });
        map.on("complete", function () {
            log.success("地图加载完成！");
        });
    }

    function XYZ() {
        map = new AMap.Map('container', {
            resizeEnable: true,
            layers: [new AMap.TileLayer.Satellite()]
        });
        // 添加图层
        map.add(
            new AMap.TileLayer({
                // 图块取图地址
                getTileUrl: 'https://wprd0{1,2,3,4}.is.autonavi.com/appmaptile?x=[x]&y=[y]&z=[z]&size=1&scl=1&style=8&ltype=11',
                zIndex: 100
            })
        );
    }

    function fun() {
        var map = new AMap.Map('container', {
            resizeEnable: true,
            layers: [
                new AMap.TileLayer.Satellite(),
                new AMap.TileLayer.RoadNet(),
                traffic
            ]
        });
        map.on("complete", function () {
            log.success("函数加载栅格图完成！");
        });
    }

    // 高德栅格路况
    var traffic = new AMap.TileLayer({
        'getTileUrl': function (x, y, z) {
            var a = 'https://tm.amap.com/trafficengine/mapabc/traffictile?v=1.0&t=1&zoom=' + (17 - z) + '&x=' + x + '&y=' + y;
            return a;
        },
        'zooms': [6, 20],
        'zIndex': 4
    });



</script>
</html>