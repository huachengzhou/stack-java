<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7&plugin=AMap.MouseTool"></script>
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

        <div class="input-card" style='width: 24rem;'>
            <div class="input-item">
                <input id="clear" type="button" class="btn" value="清除"/>
                <input id="close" type="button" class="btn" value="关闭绘图"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-12" style="margin-top:10px;height:50px;">
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
    var mouseTool = null;
    var pathArray = [];

    //监听draw事件可获取画好的覆盖物
    var overlays = [];

    $(document).ready(function () {
        map = new AMap.Map('container', {
            resizeEnable: true,
            center: [104.064871, 30.582428],
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
            draw('polyline');
        });
        mouseTool = new AMap.MouseTool(map);
        mouseTool.on('draw', function (e) {
            overlays.push(e.obj);
        });

        document.getElementById('clear').onclick = function () {
            map.remove(overlays);
            overlays = [];
        };

        document.getElementById('close').onclick = function () {
            //把已经画好的折线图展示出来
            overlays.forEach(function (obj) {
                var path = obj.Qi.path ;
                showPolyline(path);
                pathArray.push(path);
            });
            mouseTool.close(true);//关闭，并清除覆盖物
        };
    });



    /**
    * @author:  zch
    * 描述: 只读的时候  绘制图形
    **/
    function readyPath(obj) {
        var arrPath = JSON.parse(obj);
        arrPath.forEach(function (path) {
            showPolyline(path);
        });
    }


    function draw(type) {
        switch (type) {
            case 'marker': {
                mouseTool.marker({
                    //同Marker的Option设置
                });
                break;
            }
            //折线
            case 'polyline': {
                mouseTool.polyline({
                    strokeColor: '#80d8ff'
                    //同Polyline的Option设置
                });
                break;
            }
            case 'polygon': {
                mouseTool.polygon({
                    fillColor: '#00b0ff',
                    strokeColor: '#80d8ff'
                    //同Polygon的Option设置
                });
                break;
            }
            case 'rectangle': {
                mouseTool.rectangle({
                    fillColor: '#00b0ff',
                    strokeColor: '#80d8ff'
                    //同Polygon的Option设置
                });
                break;
            }
            case 'circle': {
                mouseTool.circle({
                    fillColor: '#00b0ff',
                    strokeColor: '#80d8ff'
                    //同Circle的Option设置
                });
                break;
            }
        }
    }

    /**
     * @author:  zch
     * 描述: path 折线的节点坐标数组，每个元素为 AMap.LngLat 对象 ,然后map绘制出数组path的路径
     **/
    function showPolyline(path) {
        var polyline = new AMap.Polyline({
            path: path,
            borderWeight: 2, // 线条宽度，默认为 1
            strokeColor: 'red', // 线条颜色
            lineJoin: 'round' // 折线拐点连接处样式
        });
        // 将折线添加至地图实例
        map.add(polyline);
        //包裹一下
        new AMap.Polygon({
            map: map,
            fillOpacity: 0.4,
            path: path
        });
    }


</script>
</html>