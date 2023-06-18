<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">栅格参数</label></h4>
        </div>
        <div class="col-md-12">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th></th>
                    <th>
                        超小屏幕
                        <small>手机 (&lt;768px)</small>
                    </th>
                    <th>
                        小屏幕
                        <small>平板 (≥768px)</small>
                    </th>
                    <th>
                        中等屏幕
                        <small>桌面显示器 (≥992px)</small>
                    </th>
                    <th>
                        大屏幕
                        <small>大桌面显示器 (≥1200px)</small>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th class="text-nowrap" scope="row">栅格系统行为</th>
                    <td>总是水平排列</td>
                    <td colspan="3">开始是堆叠在一起的，当大于这些阈值时将变为水平排列C</td>
                </tr>
                <tr>
                    <th class="text-nowrap" scope="row"><code>.container</code> 最大宽度</th>
                    <td>None （自动）</td>
                    <td>750px</td>
                    <td>970px</td>
                    <td>1170px</td>
                </tr>
                <tr>
                    <th class="text-nowrap" scope="row">类前缀</th>
                    <td><code>.col-xs-</code></td>
                    <td><code>.col-sm-</code></td>
                    <td><code>.col-md-</code></td>
                    <td><code>.col-lg-</code></td>
                </tr>
                <tr>
                    <th class="text-nowrap" scope="row">列（column）数</th>
                    <td colspan="4">12</td>
                </tr>
                <tr>
                    <th class="text-nowrap" scope="row">最大列（column）宽</th>
                    <td class="text-muted">自动</td>
                    <td>~62px</td>
                    <td>~81px</td>
                    <td>~97px</td>
                </tr>
                <tr>
                    <th class="text-nowrap" scope="row">槽（gutter）宽</th>
                    <td colspan="4">30px （每列左右均有 15px）</td>
                </tr>
                <tr>
                    <th class="text-nowrap" scope="row">可嵌套</th>
                    <td colspan="4">是</td>
                </tr>
                <tr>
                    <th class="text-nowrap" scope="row">偏移（Offsets）</th>
                    <td colspan="4">是</td>
                </tr>
                <tr>
                    <th class="text-nowrap" scope="row">列排序</th>
                    <td colspan="4">是</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="row" style="margin-top: 50px;">

        <div class="col-md-12 table-bordered">
            <h4 class="text-center"><label class="label label-primary">嵌套列</label></h4>
        </div>
        <div class="col-md-12 table-bordered">
            <p>为了使用内置的栅格系统将内容再次嵌套，可以通过添加一个新的 .row 元素和一系列 .col-sm-* 元素到已经存在的 .col-sm-*
                元素内。被嵌套的行（row）所包含的列（column）的个数不能超过12（其实，没有要求你必须占满12列）</p>
        </div>
        <div class="col-sm-9 table-bordered">
            Level 1: .col-sm-9
            <div class="row">
                <div class="col-xs-8 col-sm-6 table-bordered">
                    Level 2: .col-xs-8 .col-sm-6
                </div>
                <div class="col-xs-4 col-sm-6 table-bordered">
                    Level 2: .col-xs-4 .col-sm-6
                </div>
            </div>
        </div>

    </div>

    <div class="row" style="margin-top: 50px;">

        <div class="col-md-12 table-bordered">
            <h4 class="text-center"><label class="label label-primary">列偏移</label></h4>
        </div>
        <div class="col-md-12 table-bordered">
            <p>使用 .col-md-offset-* 类可以将列向右侧偏移。这些类实际是通过使用 * 选择器为当前元素增加了左侧的边距（margin）。例如，.col-md-offset-4 类将 .col-md-4
                元素向右侧偏移了4个列（column）的宽度。</p>
        </div>
        <div class="col-sm-12 table-bordered">
            <div class="row">
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
            </div>
        </div>

    </div>


    <div class="row" style="margin-top: 50px;">

        <div class="col-md-12 table-bordered">
            <h4 class="text-center"><label class="label label-primary">列排序</label></h4>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-9 col-md-push-3 table-bordered">.col-md-9 .col-md-push-3</div>
                <div class="col-md-3 col-md-pull-9 table-bordered">.col-md-3 .col-md-pull-9</div>
            </div>
        </div>
    </div>


    <div class="row" style="margin-top:50px;">
        <div class="col-sm-12 col-lg-12">
            <div style="text-align: center;">
                <a href="${pageContext.request.contextPath}/sys/bootstrapHome" class="btn btn-primary">返回</a>
            </div>
        </div>
    </div>

</div>
</body>
<script>


</script>
</html>
