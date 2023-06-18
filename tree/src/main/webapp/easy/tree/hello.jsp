
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>easy ui tree 第一个例子</title>
    <!-- easyUI -->
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/easyloader.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/plugins/jquery.validatebox.js"></script>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/plugins/jquery.treegrid.js"></script>
    <link href="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/themes/default/easyui.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assembly/plugins/jquery/easyUI/jquery-easyui-1.5.4.1/themes/icon.css" rel="stylesheet">
</head>
<body class="container">
<div class="row">
    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="easyui-panel">
            <ul class="easyui-tree">
                <li>
                    <span>计算机科学与技术专业</span>
                    <ul>
                        <li>
                            <span>专业基础课程</span>
                            <ul>
                                <li><span>电路原理</span></li>
                                <li><span>模拟电子技术</span></li>
                                <li><span>数字逻辑</span></li>
                                <li><span>数值分析</span></li>
                                <li><span>微型计算机技术</span></li>
                                <li><span>计算机系统结构</span></li>
                                <li><span>高级语言</span></li>
                                <li><span>汇编语言</span></li>
                                <li><span>编译原理</span></li>
                                <li><span>图形学</span></li>
                                <li><span>人工智能</span></li>
                                <li><span>计算方法</span></li>
                                <li><span>人机交互</span></li>
                                <li><span>面向对象方法</span></li>
                            </ul>
                        </li>
                        <li>
                            <span>专业方向课程</span>
                            <ul>
                                <li>离散数学</li>
                                <li>算法与数据结构</li>
                                <li>算法与数据结构</li>
                                <li>计算机组成原理</li>
                                <li>计算机操作系统</li>
                                <li>计算机网络基础</li>
                                <li>计算机编译原理</li>
                                <li>计算机数据库原理</li>
                                <li>C语言/c++语言</li>
                                <li>Java语言</li>
                            </ul>
                        </li>
                        <li>
                            <span>数学</span>
                            <ul>
                                <li>微分几何</li>
                                <li>概率统计
                                <li>线性代数</li>
                                <li>离散数学</li>
                            </ul>
                        </li>
                        <li><span>政治（马克思主义思想概论、毛泽东思想概论与中国特色社会主义思想、思想道德修养与法律基础、中国近现代史纲要）</span></li>
                    </ul>
                </li>
                <li><span>大学英语、体育</span></li>
            </ul>
        </div>
    </div>
    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/easy">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
