<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7"></script>
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
            <div class="col-sm-12" style="margin-top:10px;height: 600px;" id="container">

            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height:50px;">
                <label class="label label-info">经度<span class="badge" id="lat">104.222914</span></label>
                <label class="label label-info">纬度<span class="badge" id="lon">30.597945</span></label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height:50px;">
                <button class="btn btn-default" onclick="addMarker()">把显示出的点标记为覆盖物</button>
                <button class="btn btn-default" onclick="deleteMarker()">删除当前标记的覆盖物</button>
                <button class="btn btn-default" onclick="clearMarker()">清除点标记覆盖物</button>
                <button class="btn btn-default" onclick="getAllMarker()">获取所有标记覆盖物</button>
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
    var marker;
    /**
     * 创建map容器
     **/
    var map = new AMap.Map('container', {
        zoom: 12,//地图显示的缩放级别范在PC上，默认为[3,18]，取值范围[3-18]；在移动设备上，默认为[3,19],取值范围[3-19]
        resizeEnable: true, //是否监控地图容器尺寸变化，默认值为false
        center: [104.06653, 30.657326]
    });

    /**
     * 写经纬度
     **/
    function write(lng,lat) {
        //经度
        document.getElementById("lat").innerText = lng;
        //纬度
        document.getElementById("lon").innerText = lat;
    }

    /**
     * 鼠标左键单击事件
     */
    map.on('click', function (e) {
        write(e.lnglat.getLng(),e.lnglat.getLat()) ;
    });

    /**
     * 鼠标右键单击事件 并且把此点标记为覆盖物
     */
    map.on('rightclick', function (e) {
        new AMap.Marker({
            position: [e.lnglat.getLng(), e.lnglat.getLat()],
            icon: "${pageContext.request.contextPath}/assembly/img/other/poi-marker-default.png",
            map: map
        });
        write(e.lnglat.getLng(),e.lnglat.getLat()) ;
    });

    // 把显示出的点标记为覆盖物
    function addMarker() {
        var lat = Number(document.getElementById("lat").innerText);
        var lon = Number(document.getElementById("lon").innerText);
        var flag = false;
        //两种皆可以标记
        if (flag) {
            new AMap.Marker({
                position: [lat, lon],
                icon: "${pageContext.request.contextPath}/assembly/img/other/poi-marker-default.png",
                map: map
            });
        }

        if (!flag) {
            marker = new AMap.Marker({
                icon: "${pageContext.request.contextPath}/assembly/img/other/poi-marker-default.png",
                position: [lat, lon],
                offset: new AMap.Pixel(-13, -30)
            });
            marker.setMap(map);
        }
    }

    /**
     * 删除所有被标记的覆盖物
     **/
    function clearMarker() {
        map.clearMap();
    }

    /**
     * 删除刚被标记的覆盖物
     */
    function deleteMarker() {
        if (marker) {
            marker.setMap(null);
            marker = null;
        }
    }

    /**
     * 获取所有被标记的覆盖物
     * @returns {Array}
     */
    function getAllMarker() {

        map.getAllOverlays('marker');//定位
        map.getAllOverlays('circle');//圆
        map.getAllOverlays('polyline');//折线
        map.getAllOverlays('polygon');//多边形

        var arr = [] ;
        $.each(map.getAllOverlays('marker'),function (i,n) {
            var position = n.G.position ;
            arr.push({lng: position.lng, lat: position.lat});
        });
        console.log(arr);
        return arr;
    }
</script>
</html>