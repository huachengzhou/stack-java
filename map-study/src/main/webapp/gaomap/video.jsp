<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.4.11&key=032c70eeb8096f216fd0d4716e8a72b7"></script>
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
    var bounds = new AMap.Bounds([93, -9], [147, 32]);


    map = new AMap.Map('container', {
        resizeEnable: true,
        viewMode: "3D",
        zoom: 3,
        center: [115.811491, 12.423935]
    });

    $(document).ready(function () {
        var VideoLayer = new AMap.VideoLayer({
            autoplay: true,
            loop: true,
            zIndex: 130,
            //可提供不同格式以达到多浏览器兼容
            url: [
                'https://a.amap.com/jsapi_demos/static/video/cloud.m4v',
                'https://a.amap.com/jsapi_demos/static/video/cloud.mov'
            ],
            bounds: bounds,
            zooms: [3, 18],
            opacity: 0.7
        });
        VideoLayer.setMap(map);
    });

</script>
</html>