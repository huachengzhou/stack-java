<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <script src="https://webapi.amap.com/maps?v=1.3&key=032c70eeb8096f216fd0d4716e8a72b7"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assembly/css/other/demo-center.css"/>
    <script src="${pageContext.request.contextPath}/assembly/js/other/demoutils.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/js/other/es5.min.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/js/other/addToolbar.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assembly/css/other/font_873139_0v65kqy674.css"/>
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
            <div class="info">
                <h4>当前地图显示范围（Bounds）</h4>
                <p>NorthEast坐标：<span id="ne" class="lnglat"></span></p>
                <p>SouthWest坐标：<span id="sw" class="lnglat"></span></p>
            </div>
        </div>

        <div class="form-group">
            <div class="input-card" style="width:13rem">
                <h4>底图语言切换</h4>
                <div id="lang">
                    <div class="input-item"><input id="en" name="language" type="radio" checked="checked"><span
                            class="input-text">英文底图</span></div>
                    <div class="input-item"><input id="zh_en" name="language" type="radio"><span class="input-text">中英文对照</span>
                    </div>
                    <div class="input-item"><input id="zh_cn" name="language" type="radio"><span
                            class="input-text">中文底图</span></div>

                    <button class="btn" id="reset-bounds">指定地图显示范围</button>
                </div>
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
    $(document).ready(function () {
        createMap();

        {
            //显示当前地图边界范围坐标
            var bounds = map.getBounds();
            document.querySelector("#ne").innerText = bounds.northeast.toString();
            document.querySelector("#sw").innerText = bounds.southwest.toString();
        }
    });

    /**
     * 创建地图
     */
    function createMap() {
        map = new AMap.Map('container', {
            resizeEnable: true,
            lang: "en" //可选值：en，zh_en, zh_cn
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
            center: [117.000923, 36.675807],
            zoom: 6,
            lang: "en" //可选值：en，zh_en, zh_cn
        });
        map.plugin(["AMap.ToolBar"], function () {
            map.addControl(new AMap.ToolBar());
        });
    }


    //绑定radio点击事件
    var radios = document.querySelectorAll("#lang input");
    radios.forEach(function (ratio) {
        ratio.onclick = setLang;
    });

    function setLang() {
        map.setLang(this.id);
    }

    //绑定按钮事件
    document.querySelector("#reset-bounds").onclick = function () {
        //通过 new AMap.Bounds(southWest:LngLat, northEast:LngLat) 或者 map.getBounds() 获得地图Bounds信息
        var mybounds = new AMap.Bounds([104.075594, 30.634139], [104.095721, 30.626938]);
        map.setBounds(mybounds);
    }

</script>
</html>