<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/bootstrap4.jsp" %>
<html>
<head>
    <title>高德 home</title>
    <style>
        body {
            text-align: center;
        }

        #sss {
            margin-top: 20px;
        }
    </style>
</head>
<body class="container">
<div class="row">

    <div class="col-xl-12 col-sm-12">
        <div id="sss" class="card">
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/helloWorld">helloWorld</a>
                </li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/lifeCycle">地图的生命周期</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/property">地图的属性</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/propertyCenter">地图中心点</a>
                </li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/usePlugin">地图插件使用</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/location">地图定位</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/marker">地图点标记 (简单)</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/intermediateMarker">覆盖物的添加与移除
                    (中)</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/seniorMarker">覆盖物的添加与移除
                    (高级)</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/markerClusterer">覆盖物的聚合
                    (高级)</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/markerMyClusterer2">覆盖物的聚合
                    (高级2)</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/markerMyClusterer">覆盖物聚合
                    (高级本地经度和纬度)</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/markerImg">覆盖物 (图片)</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/block">楼块</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/layer">图层</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/dataLayer">数据图层</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/custom">canvas图层</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/video">视频图层</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/keywords-search">地图
                    关键字搜索</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/map/mouseTool">鼠标工具-绘制覆盖物</a></li>
            </ul>
            <ul style="margin-top:20px;margin-right:30px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/home">返回</a></li>
            </ul>
        </div>
    </div>

</div>
<script>
</script>
</body>
</html>
