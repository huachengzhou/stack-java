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
            <div class="col-sm-12" style="margin-top:10px;height: 700px;" id="container">

            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height: 100px;" id="tip">

            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height:50px;">
                <label class="label label-info">经度<span class="badge" id="lat">0</span></label>
                <label class="label label-info">纬度<span class="badge" id="lon">0</span></label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-12" style="margin-bottom:40px;">
                <ul style="margin-top:20px;margin-right:30px;">
                    <li class="list-group-item"> <a href="${pageContext.request.contextPath}/sys/gaode">返回</a> </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    /***************************************
     由于Chrome、IOS10等已不再支持非安全域的浏览器定位请求，为保证定位成功率和精度，请尽快升级您的站点到HTTPS。
     ***************************************/
    var map, geolocation;
    //加载地图，调用浏览器定位服务
    map = new AMap.Map('container', {
        resizeEnable: true
    });
    map.plugin('AMap.Geolocation', function() {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            buttonPosition:'LT'  //定位按钮可停靠的位置 [“LT”：左上角] [“LB”：左下角] [“RT”：右上角] [“RB”：右下角]
        });
        map.addControl(geolocation);//获取用户当前的精确位置信息
        // map.watchPosition();//移动端有效
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
    });
    //解析定位结果
    function onComplete(data) {
        var str=['定位成功'];
        str.push('经度：' + data.position.getLng());
        str.push('纬度：' + data.position.getLat());
        if(data.accuracy){
            str.push('精度：' + data.accuracy + ' 米');
        }//如为IP精确定位结果则没有精度信息
        str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
        document.getElementById('tip').innerHTML = str.join('<br>');
    }
    //解析定位错误信息
    function onError(data) {
        document.getElementById('tip').innerHTML = '定位失败';
    }

    map.on('click', function(e) {
        //经度
        document.getElementById("lat").innerHTML = e.lnglat.getLng();
        //纬度
        document.getElementById("lon").innerText = e.lnglat.getLat();
    });


</script>
</html>