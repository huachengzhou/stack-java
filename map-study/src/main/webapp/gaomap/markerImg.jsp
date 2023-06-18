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
            <div class="col-sm-12" style="margin-top:30px;height:50px;">
                <label class="label label-info">经度<span class="badge" id="lng">104.05904</span></label>
                <label class="label label-info">纬度<span class="badge" id="lat">30.616186</span></label>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height:50px;">
                <button class="btn btn-default" onclick="createMap()">3D 楼块 重载</button>
                <button class="btn btn-default" onclick="createImgMarker(this)">图标型覆盖物</button>
                <button class="btn btn-default" onclick="rotateTransform(true)" style="display: none">右旋转</button>
                <button class="btn btn-default" onclick="rotateTransform(false)" style="display: none">左旋转</button>
                <button class="btn btn-default" onclick="zoom(true)" style="display: none">放大</button>
                <button class="btn btn-default" onclick="zoom(false)" style="display: none">缩小</button>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-12" style="margin-bottom:40px;">
                <ul style="margin-top:20px;margin-right:30px;">
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/gaode">返回</a></li>
                </ul>
            </div>
        </div>

        <img id="oImg" src="${pageContext.request.contextPath}/assembly/img/other/tiger.jpg" style="display:none">

    </div>
</div>
</body>
<script type="text/javascript">
    var map = null;
    var markerIcon = null;
    var startMarker = null;
    var endMarker = null;
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
        event();
    }


    function event() {
        /**
         * 鼠标左键单击事件
         */
        map.on('click', function (e) {
            writePosition(e.lnglat.getLng(), e.lnglat.getLat());
        });
        map.on('rightclick', function (e) {
            // map.setCenter([e.lnglat.getLng(), e.lnglat.getLat()]); //设置地图中心点
            writePosition(e.lnglat.getLng(), e.lnglat.getLat());
        });
    }

    /**
     * 写经纬度
     **/
    function writePosition(lng, lat) {
        //经度
        document.getElementById("lng").innerText = lng;
        //纬度
        document.getElementById("lat").innerText = lat;
    }

    var startIcon = null;
    getImgNaturalDimensions(document.getElementById("oImg"), function (dimensions) {
        // 创建一个 Icon
        startIcon = new AMap.Icon({
            // 图标尺寸
            size: new AMap.Size(Number(dimensions.w)/2, Number(dimensions.h)/2),
            // 图标的取图地址
            image: "${pageContext.request.contextPath}/assembly/img/other/tiger.jpg",
            // 图标所用图片大小
            imageSize: new AMap.Size(Number(dimensions.w)/2, Number(dimensions.h)/2),
            // 图标取图偏移量
            imageOffset: new AMap.Pixel(-9, -3)
        });
    });

    // 创建一个 icon
    var endIcon = new AMap.Icon({
        size: new AMap.Size(125, 164),
        image: "${pageContext.request.contextPath}/assembly/img/other/squish_purple_panda_15.jpg",
        imageSize: new AMap.Size(135, 140),
        imageOffset: new AMap.Pixel(-5, -3)
    });


    /**
     * 图标方式
     */
    function createImgMarker(item) {
        var flag = 1;
        flag = 1;
        if (flag == 0) {
            markerIcon = new AMap.Marker({
                position: [104.059181, 30.653597],
                // 将一张图片的地址设置为 icon
                icon: "${pageContext.request.contextPath}/assembly/img/other/poi-marker-default.png",
                // 设置了 icon 以后，设置 icon 的偏移量，以 icon 的 [center bottom] 为原点
                offset: new AMap.Pixel(-13, -30)
            });
        }
        if (flag = 1) {
            startMarker = new AMap.Marker({
                position: new AMap.LngLat(104.06653, 30.657326),
                icon: startIcon,
                offset: new AMap.Pixel(-13, -30),
                autoRotation: true,
                extData: {id: 'startMarker'},
                angle: 20
            });
            endMarker = new AMap.Marker({
                position: new AMap.LngLat(104.074201, 30.653542),
                icon: endIcon,
                offset: new AMap.Pixel(-13, -30),//点标记显示位置偏移量，默认值为Pixel(-10,-34)。Marker指定position后，默认以marker左上角位置为基准点，对准所给定的position位置，若需使marker指定位置对准在position处需根据marker的尺寸设置一定的偏移量。
                draggable: true,// 设置是否可以拖拽
                cursor: 'move',//指定鼠标悬停时的鼠标样式，自定义cursor，IE仅支持cur/ani/ico格式，Opera不支持自定义cursor
                visible: true,//点标记是否可见，默认为true
                animation: "AMAP_ANIMATION_NONE",//点标记的动画效果，默认值：“AMAP_ANIMATION_NONE” 可选值： “AMAP_ANIMATION_NONE”，无动画效果“AMAP_ANIMATION_DROP”，点标掉落效果“AMAP_ANIMATION_BOUNCE”，点标弹跳效果
                zIndex: 100,//点标记的叠加顺序。地图上存在多个点标记叠加时，通过该属性使级别较高的点标记在上层显示默认zIndex：100
                angle: 0,//点标记的旋转角度，广泛用于改变车辆行驶方向注：angle属性是使用CSS3来实现的，支持IE9及以上版本
                autoRotation: true,//是否自动旋转。点标记在使用moveAlong动画时，路径方向若有变化，点标记是否自动调整角度，默认为false。广泛用于自动调节车辆行驶方向。
                raiseOnDrag: false,// 设置拖拽点标记时是否开启点标记离开地图的效果
                extData: {id: 'endMarker'} // 用户自定义属性，支持JavaScript API任意数据类型，如Marker的id等
            });
        }
        map.add([startMarker, endMarker]);
        $(item).next().show();
        $(item).next().next().show();
        $(item).next().next().next().show();
        $(item).next().next().next().next().show();
    }

    function rotateTransform(flag) {
        var angle = Number(startMarker.getAngle());
        if (flag) {
            startMarker.setAngle(angle + 5);
        } else {
            startMarker.setAngle(angle - 5);
        }
    }

    function zoom(flag) {
        var size = startIcon.getImageSize();
        if (flag) {
            startIcon.setImageSize({
                height: Number(size.height) * 1.2,
                width: Number(size.width) * 1.2
            });
            startMarker.setIcon(startIcon);
        } else {
            startIcon.setImageSize({
                height: Number(size.height) / 1.2,
                width: Number(size.width) / 1.2
            });
            startMarker.setIcon(startIcon);
        }
    }

    /**
     * 获取原始图片的长度和宽度
     * @param oImg
     * @param callback
     */
    function getImgNaturalDimensions(oImg, callback) {
        var nWidth, nHeight;
        if (!oImg.naturalWidth) { // 现代浏览器

            nWidth = oImg.naturalWidth;
            nHeight = oImg.naturalHeight;
            callback({w: nWidth, h: nHeight});

        } else { // IE6/7/8
            var nImg = new Image();
            nImg.onload = function () {
                var nWidth = nImg.width,
                    nHeight = nImg.height;
                callback({w: nWidth, h: nHeight});
            }
            nImg.src = oImg.src;
        }
    }


</script>
</html>