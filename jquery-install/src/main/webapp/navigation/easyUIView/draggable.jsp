<%--
  Created by IntelliJ IDEA.
  User: noatn
  Date: 2018/9/27
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
</head>
<body class="container">
<div class="row">

    <div class="col-xl-12 col-sm-12">
        <h2>draggable 拖动</h2>
    </div>

    <div class="col-xl-12 col-sm-12">
        <span id="pox">内容部分</span>
    </div>

    <div class="col-xl-12 col-sm-12">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/easyUiHome">返回</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="easyui-panel" id="box">
    <h1>title</h1>
    <p>content</p>
</div>

</body>
<script>

    $(function () {
        $('#box').draggable({
            revert : true, //如果设置为true，在拖动停止时元素将返回起始位置。
            cursor : 'text',//拖动时的CSS指针样式。
            //disabled : true,
            //edge : 180,
            //axis : 'v',
            //proxy : 'clone',
            //deltaX : 50,
            //deltaY : 50,
            //proxy : function (source) {
            //	var p = $('<div style="width:400px;height:200px;border:1px dashed #ccc">');
            //	p.html($(source).html()).appendTo('body');
            //	return p;
            //}

            // onBeforeDrag : function (e) {
            // 	alert('拖动前触发！');
            // },
            // onBeforeDrag : function (e) {
            // 	return false;
            // },
            // onStartDrag : function (e) {
            // 	//alert('拖动开始触发！');
            // 	console.log($('#box').draggable('proxy'));
            // },
            // onDrag : function (e) {
            // 	alert('拖动过程触发！');
            // },
            // onStopDrag : function (e) {
            // 	alert('拖动结束后触发！');
            // },


        });
    });

</script>
</html>
