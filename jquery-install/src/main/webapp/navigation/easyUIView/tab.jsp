<%--
  Created by IntelliJ IDEA.
  User: 13426
  Date: 2018/8/8
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <style scoped="scoped">
        .tt-inner{
            display:inline-block;
            line-height:12px;
            padding-top:5px;
        }
        .tt-inner img{
            border:0;
        }
    </style>
</head>
<body class="container">
<div class="row">
    <div class="col-xl-12 col-sm-12">
        <h2>基础选项卡
        </h2>
        <div class="easyui-tabs" style="width:100%;height:250px">
            <div title="About" style="padding:10px">
                <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
                <ul>
                    <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                    <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
                    <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
                    <li>complete framework for HTML5 web page.</li>
                    <li>easyui save your time and scales while developing your products.</li>
                    <li>easyui is very easy but powerful.</li>
                </ul>
            </div>
            <div title="My Documents" style="padding:10px">
                <ul class="easyui-tree">
                    <li>
                        <span>My Documents</span>
                        <ul>
                            <li data-options="state:'closed'">
                                <span>Photos</span>
                                <ul>
                                    <li>
                                        <span>Friend</span>
                                    </li>
                                    <li>
                                        <span>Wife</span>
                                    </li>
                                    <li>
                                        <span>Company</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>Program Files</span>
                                <ul>
                                    <li>Intel</li>
                                    <li>Java</li>
                                    <li>Microsoft Office</li>
                                    <li>Games</li>
                                </ul>
                            </li>
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div title="Help" data-options="iconCls:'icon-help',closable:true" style="padding:10px">
                This is the help content.
            </div>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <h2>固定选项卡 宽度
        </h2>
        <div class="easyui-tabs" data-options="tabWidth:112" style="width:100%;height:250px">
            <div title="Home" style="padding:10px">
                <p>Home Content.</p>
            </div>
            <div title="Maps" style="padding:10px">
                <p>Maps Content.</p>
            </div>
            <div title="Journal" style="padding:10px">
                <p>Journal Content.</p>
            </div>
            <div title="History" style="padding:10px">
                <p>History Content.</p>
            </div>
            <div title="References" style="padding:10px">
                <p>References Content.</p>
            </div>
            <div title="Contact" data-options="tabWidth:110" style="padding:10px">
                <p>Contact Content.</p>
            </div>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <h2>流式选项卡</h2>
        <div class="easyui-panel" title="Nested Panel" style="width:100%;height:200px;padding:10px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'west',split:true" style="width:100px;padding:10px">
                    Left Content
                </div>
                <div data-options="region:'east'" style="width:100px;padding:10px">
                    Right Content
                </div>
                <div data-options="region:'center'" style="padding:10px">
                    Right Content
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <h2>
            带图片的选项卡
        </h2>
        <div class="easyui-tabs" data-options="tabWidth:100,tabHeight:60" style="width:100%;height:250px">
            <div title="<span class='tt-inner'>
            <img src='${pageContext.request.contextPath}/assembly/img/common/uicloud.png'/><br>Modem</span>" style="padding:10px">
                <p>A modem (modulator-demodulator) is a device that modulates an analog carrier signal to encode digital information, and also demodulates such a carrier signal to decode the transmitted information.</p>
            </div>
            <div title="<span class='tt-inner'><img src='${pageContext.request.contextPath}/assembly/img/common/quill.png'/><br>Scanner</span>" style="padding:10px">
                <p>In computing, an image scanner—often abbreviated to just scanner—is a device that optically scans images, printed text, handwriting, or an object, and converts it to a digital image.</p>
            </div>
            <div title="<span class='tt-inner'><img src='${pageContext.request.contextPath}/assembly/img/common/UI中国.png'/><br>Pda</span>" style="padding:10px">
                <p>A personal digital assistant (PDA), also known as a palmtop computer, or personal data assistant, is a mobile device that functions as a personal information manager. PDAs are largely considered obsolete with the widespread adoption of smartphones.</p>
            </div>
            <div title="<span class='tt-inner'><img src='${pageContext.request.contextPath}/assembly/img/common/uikit.png'/><br>Tablet</span>" style="padding:10px">
                <p>A tablet computer, or simply tablet, is a one-piece mobile computer. Devices typically have a touchscreen, with finger or stylus gestures replacing the conventional computer mouse.</p>
            </div>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <h2>带下拉框的选项卡</h2>
        <div id="ttTab" style="width:700px;height:250px">
            <div title="About" style="padding:10px">
                <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
                <ul>
                    <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                    <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
                    <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
                    <li>complete framework for HTML5 web page.</li>
                    <li>easyui save your time and scales while developing your products.</li>
                    <li>easyui is very easy but powerful.</li>
                </ul>
            </div>
            <div title="My Documents" style="padding:10px">
                <ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true"></ul>
            </div>
            <div title="Help" style="padding:10px">
                This is the help content.
            </div>
        </div>
        <div id="mmTab">
            <div>Welcome</div>
            <div>Help Contents</div>
            <div data-options="iconCls:'icon-search'">Search</div>
            <div>Dynamic Help</div>
        </div>
    </div>
    <div class="col-xl-12 col-sm-12" style="margin-top:20px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/easyUiHome">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function(){
        var p = $('#ttTab').tabs().tabs('tabs')[2];
        var mb = p.panel('options').tab.find('a.tabs-inner');
        mb.menubutton({
            menu:'#mmTab',
            iconCls:'icon-help'
        }).click(function(){
            $('#ttTab').tabs('select',2);
        });
    });
</script>
