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

        <div class='info'>操作说明：圆和矩形通过拖拽来绘制，其他覆盖物通过点击来绘制</div>
        <div class="input-card" style='width: 24rem;'>
            <div class="input-item">
                <input type="radio" name='func' checked="" value='marker'><span class="input-text">画点</span>
                <input type="radio" name='func' value='polyline'><span class="input-text">画折线</span>
                <input type="radio" name='func' value='polygon'><span class="input-text" style='width:5rem;'>画多边形</span>
            </div>
            <div class="input-item">
                <input type="radio" name='func' value='rectangle'><span class="input-text">画矩形</span>
                <input type="radio" name='func' value='circle'><span class="input-text">画圆</span>
            </div>
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
                }),
                imageLayer
            ],
            zoom: 16
        });
        map.on("complete", function () {
            log.success("地图加载完成！");
        });
        mouseTool = new AMap.MouseTool(map);
        mouseTool.on('draw',function(e){
            overlays.push(e.obj);
        });
        var radios = document.getElementsByName('func');
        for(var i=0;i<radios.length;i+=1){
            radios[i].onchange = function(e){
                draw(e.target.value);
            }
        }
        draw('marker');
        document.getElementById('clear').onclick = function(){
            map.remove(overlays);
            overlays = [];
        };
        document.getElementById('close').onclick = function(){
            mouseTool.close(true);//关闭，并清除覆盖物
            for(var i=0;i<radios.length;i+=1){
                radios[i].checked = false;
            }
        };
    });


    var imageLayer = new AMap.ImageLayer({
        url: '${pageContext.request.contextPath}/assembly/img/other/squish_purple_panda_15.jpg',
        bounds: new AMap.Bounds(
            [104.065434, 30.582617],
            [104.0664, 30.582433]
        ),
        zooms: [15, 18]
    });

    function draw(type){
        switch(type){
            case 'marker':{
                mouseTool.marker({
                    //同Marker的Option设置
                });
                break;
            }
            case 'polyline':{
                mouseTool.polyline({
                    strokeColor:'#80d8ff'
                    //同Polyline的Option设置
                });
                break;
            }
            case 'polygon':{
                mouseTool.polygon({
                    fillColor:'#00b0ff',
                    strokeColor:'#80d8ff'
                    //同Polygon的Option设置
                });
                break;
            }
            case 'rectangle':{
                mouseTool.rectangle({
                    fillColor:'#00b0ff',
                    strokeColor:'#80d8ff'
                    //同Polygon的Option设置
                });
                break;
            }
            case 'circle':{
                mouseTool.circle({
                    fillColor:'#00b0ff',
                    strokeColor:'#80d8ff'
                    //同Circle的Option设置
                });
                break;
            }
        }
    }



</script>
</html>