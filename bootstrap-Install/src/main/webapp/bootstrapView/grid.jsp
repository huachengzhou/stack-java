<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <title>栅格</title>
    <%@include file="/css/cssBootStrap.jsp" %>
</head>
<body class="container">

<div id="test" style="margin-top: 20px;">

</div>

<div class="row panel-body" style="margin-top: 20px;">
    <div>
        <div class="col-md-2">
            <strong>布局容器</strong>
        </div>

        <div class="col-md-9">
            <div class="row">
                <div class="col-sm-6 col-lg-6 col-md-6">
                    .container 类用于固定宽度并支持响应式布局的容器。
                </div>
                <div class="col-sm-6 col-lg-6 col-md-6">
                    .container-fluid 类用于 100% 宽度，占据全部视口（viewport）的容器。
                </div>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-sm-4 col-lg-4 col-md-4">
        <button onclick="gridObj.test1()" class="btn-default btn btn-lg">从堆叠到水平排列<i class="fa fa-user-circle-o" aria-hidden="true"></i>
        </button>
    </div>
    <div class="col-sm-4 col-lg-4 col-md-4">
        <button onclick="gridObj.test2()" class="btn-default btn btn-lg">列偏移<i class="fa fa-user-circle-o" aria-hidden="true"></i>
        </button>
    </div>
    <div class="col-sm-4 col-lg-4 col-md-4">
        <button onclick="gridObj.test3()" class="btn-default btn btn-lg">嵌套列<i class="fa fa-user-circle-o" aria-hidden="true"></i>
        </button>
    </div>
</div>

<div class="row" style="margin-top:50px;">
    <div class="col-sm-12 col-lg-12 col-md-12">
        <div style="text-align: center;">
            <a href="${pageContext.request.contextPath}/sys/bootstrapHome" class="btn btn-primary">返回</a>
        </div>
    </div>
</div>

<!-- 使用单一的一组 .col-md-* 栅格类，就可以创建一个基本的栅格系统，在手机和平板设备上一开始是堆叠在一起的（超小屏幕到小屏幕这一范围），
在桌面（中等）屏幕设备上变为水平排列。所有“列（column）必须放在 ” .row 内。 -->
<script type="text/html" id="grid1" data-title="从堆叠到水平排列">
    <div class="row">
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
        <div class="col-md-1 table-bordered">.col-md-1</div>
    </div>
    <div class="row">
        <div class="col-md-8 table-bordered">.col-md-8</div>
        <div class="col-md-4 table-bordered">.col-md-4</div>
    </div>
    <div class="row">
        <div class="col-md-4 table-bordered">.col-md-4</div>
        <div class="col-md-4 table-bordered">.col-md-4</div>
        <div class="col-md-4 table-bordered">.col-md-4</div>
    </div>
    <div class="row">
        <div class="col-md-6 table-bordered">.col-md-6</div>
        <div class="col-md-6 table-bordered">.col-md-6</div>
    </div>
</script>

<!-- 使用 .col-md-offset-* 类可以将列向右侧偏移。这些类实际是通过使用 * 选择器为当前元素增加了左侧的边距（margin）。
例如，.col-md-offset-4 类将 .col-md-4 元素向右侧偏移了4个列（column）的宽度。 -->
<script type="text/html" id="grid2" data-title="列偏移">
    <div class="row">
        <div class="col-md-4 table-bordered">.col-md-4</div>
        <div class="col-md-4 col-md-offset-4 table-bordered">.col-md-4 .col-md-offset-4</div>
    </div>
    <div class="row">
        <div class="col-md-3 col-md-offset-3 table-bordered">.col-md-3 .col-md-offset-3</div>
        <div class="col-md-3 col-md-offset-3 table-bordered">.col-md-3 .col-md-offset-3</div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3 table-bordered">.col-md-6 .col-md-offset-3</div>
    </div>
</script>

<script type="text/html" id="grid3" data-title="嵌套列">
    <div class="row">
        <div class="col-md-8 table-bordered">
            <div class="row">
                <div class="col-md-8 table-bordered">第二层8个格子</div>
                <div class="col-md-4 table-bordered">第二层4个格子</div>
            </div>
        </div>
        <div class="col-md-4 table-bordered">.col-md-4</div>
    </div>
</script>

<script type="text/javascript">
    var gridObj = {};

    gridObj.test1 = function () {
        $("#test").empty();
        $("#test").append($("#grid1").html());
    };

    gridObj.test2 = function () {
        $("#test").empty();
        $("#test").append($("#grid2").html());
    };

    gridObj.test3 = function () {
        $("#test").empty();
        $("#test").append($("#grid3").html());
    };


</script>


</body>
</html>
