<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
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

        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height: 100px;" id="tip">

            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height:50px;">
                <button class="btn btn-default" onclick="areaMap.rotateTransform(true)">右旋转</button>
                <button class="btn btn-default" onclick="areaMap.rotateTransform(false)">左旋转</button>
                <button class="btn btn-default" onclick="areaMap.zoom(true)">放大</button>
                <button class="btn btn-default" onclick="areaMap.zoom(false)">缩小</button>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-12" style="margin-bottom:40px;">
                <ul style="margin-top:20px;margin-right:30px;">
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/gaode">返回</a></li>
                </ul>
            </div>
        </div>

        <img style="display: none"
             src="${pageContext.request.contextPath}/assembly/img/other/squish_purple_panda_15.jpg" id="oImg">

    </div>
</div>
</body>
<script type="text/javascript">
    var map = null;
    var imgMarker = null;
    var imgIcon = null;
    var areaMap = {};

    /**
     * 判断字符串以及null等
     */
    areaMap.isNotBlank = function (item) {
        if (item) {
            return true;
        }
        return false;
    };

    /**
     * 判断对象
     */
    areaMap.isNotBlankObject = function (obj) {
        for (var key in obj) {
            return true;
        }
        return false
    };

    /**
     * 创建地图
     */
    areaMap.createMap = function (lng, lat, zoom) {
        map = new AMap.Map('container', {
            resizeEnable: true, //是否监控地图容器尺寸变化
            center: [lng, lat], //初始地图中心点
            zoom: zoom,// //初始地图级别
            showIndoorMap: false,//关闭室内地图
            lang: "zh_cn" //可选值：en，zh_en, zh_cn
        });
        areaMap.event();
        map.add(areaMap.createImgMarker({lon: 104.084933, lat: 30.592833}));
        var mapList = [
            {name: "a", title: "t1", id: 1, lon: 104.07944, lat: 30.586974},
            {
                name: "b",
                title: "t2",
                id: 2,
                lon: 104.072573,
                lat: 30.589508
            }];
        var markerList = [];
        $.each(mapList, function (i, n) {
            var marker = areaMap.getMarker(n);
            markerList.push(marker);
        });
        map.add(markerList);
    };

    areaMap.event = function () {
        /**
         * 鼠标右键单击事件
         */
        map.on('rightclick', function (e) {
            var str = "<div class='panel panel-default'>";
            str += "<div class='panel-body'>";
            str += "经度:" + e.lnglat.getLng() + "<br>";
            str += "纬度:" + e.lnglat.getLat() + "<br>";
            map.getCity(function (info) {
                str += "省:" + info.province + "<br>";
                str += "市:" + info.city + "<br>";
                str += "区/县/县级市:" + info.district + "<br>";
                str += "</div>";
                str += "</div>";
                $("#myContent").html(str);
                $('#myModal').modal('show');
            });
        });
    };


    //创建一个图片覆盖物
    areaMap.createImgMarker = function (n) {
        var dimensions = areaMap.getImgNaturalDimensions(document.getElementById("oImg"));
        $("#oImg").next().show();
        // 创建一个 Icon
        imgIcon = new AMap.Icon({
            // 图标尺寸
            size: new AMap.Size(Number(dimensions.w) * 10, Number(dimensions.h) * 10),
            // 图标的取图地址
            image: "${pageContext.request.contextPath}/assembly/img/other/squish_purple_panda_15.jpg",
            // 图标所用图片大小
            imageSize: new AMap.Size(Number(dimensions.w) / 2.5, Number(dimensions.h) / 2.5),
            // 图标取图偏移量
            imageOffset: new AMap.Pixel(-1, -1)
        });
        imgMarker = new AMap.Marker({
            position: new AMap.LngLat(Number(n.lon), Number(n.lat)), // 经纬度对象
            icon: imgIcon,
            offset: new AMap.Pixel(-13, -30),
            autoRotation: true,
            extData: {id: 'startMarker'},
            angle: 20
        });
        return imgMarker;
    };

    /**
     * 修改旋转角度
     */
    areaMap.rotateTransform = function (flag) {
        var angle = Number(imgMarker.getAngle());
        if (flag) {
            imgMarker.setAngle(angle + 5);
        } else {
            imgMarker.setAngle(angle - 5);
        }
    };

    /*修改覆盖物的大小*/
    areaMap.zoom = function (flag) {
        var size = imgIcon.getImageSize();
        if (flag) {
            imgIcon.setImageSize({
                height: Number(size.height) * 1.2,
                width: Number(size.width) * 1.2
            });
            imgMarker.setIcon(imgIcon);
        } else {
            imgIcon.setImageSize({
                height: Number(size.height) / 1.2,
                width: Number(size.width) / 1.2
            });
            imgMarker.setIcon(imgIcon);
        }
    };

    /**
     * 获取原始图片的长度和宽度
     * @param oImg
     * @param callback
     */
    areaMap.getImgNaturalDimensions = function (oImg) {
        var nWidth, nHeight;
        if (oImg.naturalWidth) { // 现代浏览器
            nWidth = oImg.naturalWidth;
            nHeight = oImg.naturalHeight;
            return {w: nWidth, h: nHeight};
        } else { // IE6/7/8
            var nImg = new Image();
            nImg.src = oImg.src;
            nImg.onload = function () {
                nWidth = nImg.width;
                nHeight = nImg.height;
                return {w: nWidth, h: nHeight};
            };
        }
    };

    //解析定位结果
    areaMap.onComplete = function (data) {
        var str = ['定位成功'];
        str.push('经度：' + data.position.getLng());
        str.push('纬度：' + data.position.getLat());
        if (data.accuracy) {
            str.push('精度：' + data.accuracy + ' 米');
        }//如为IP精确定位结果则没有精度信息
        str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
        document.getElementById('tip').innerHTML = str.join('<br>');
    };

    areaMap.onError = function (data) {
        document.getElementById('tip').innerHTML = '定位失败';
    };

    /**
     * 加载子地图
     */
    areaMap.onSonLoadMap = function (e) {
        var extData = e.target.G.extData;
        console.log(extData);
        var str = '';
        str += "<p>" ;
        str += '经度：' + extData.lon +"<br>";
        str += '纬度：' + extData.lat +"<br>";
        str += '标题：' + extData.title +"<br>";
        str += '名称：' + extData.name +"<br>";
        str += "<p>" ;
        $("#myMarkerContent").html(str);
        $('#myMarker').modal('show');
    };


    //自定义icon (主要是便于识别)
    areaMap.getContent = function (name) {
        var markerContent = '' +
            '<div class="panel panel-body" style="width:95px;height:55px;">' +
            '<p style="text-overflow: ellipsis; white-space: nowrap;">' + name +
            '<img style="height:25.5px;width:19.8px;float: left;" src="http://a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png">' +
            '<div style="clear:both"></div>' +
            '</p>' +
            '</div>';
        return markerContent;
    };


    //创建一个覆盖物
    areaMap.getMarker = function (n) {
        var marker = new AMap.Marker({
            position: [Number(n.lon), Number(n.lat)], // 经纬度对象
            icon: areaMap.getIcon(), // 添加 Icon 实例
            // icon: "http://a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png",
            title: n.title,
            extData: n,
            content: areaMap.getContent(n.name) //会使icon无效
        });
        marker.on('click', areaMap.onSonLoadMap);
        return marker;
    };


    // 创建一个 icon
    areaMap.getIcon = function () {
        var icon = new AMap.Icon({
            size: new AMap.Size(53, 68),    // 图标尺寸
            image: 'http://a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png',  // Icon的图像
            imageOffset: new AMap.Pixel(0, 0),  // 图像相对展示区域的偏移量，适于雪碧图等
            imageSize: new AMap.Size(53, 68)   // 根据所设置的大小拉伸或压缩图片
        });
        return icon;
    };

    $(document).ready(function () {
        areaMap.createMap(104.083199, 30.593365, 15);
        //自动定位
        map.plugin('AMap.Geolocation', function () {
            geolocation = new AMap.Geolocation({
                enableHighAccuracy: true,//是否使用高精度定位，默认:true
                timeout: 10000,          //超过10秒后停止定位，默认：无穷大
                buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
                buttonPosition: 'LT'  //定位按钮可停靠的位置 [“LT”：左上角] [“LB”：左下角] [“RT”：右上角] [“RB”：右下角]
            });
            map.addControl(geolocation);//获取用户当前的精确位置信息
            // map.watchPosition();//移动端有效
            geolocation.getCurrentPosition();
            AMap.event.addListener(geolocation, 'complete', areaMap.onComplete);//返回定位信息
            AMap.event.addListener(geolocation, 'error', areaMap.onError);      //返回定位出错信息
        });
    });

</script>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    当前点击的经纬度信息
                </h4>
            </div>
            <div class="modal-body" id="myContent">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<div class="modal fade" id="myMarker" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    覆盖物信息
                </h4>
            </div>
            <div class="modal-body" id="myMarkerContent">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</html>