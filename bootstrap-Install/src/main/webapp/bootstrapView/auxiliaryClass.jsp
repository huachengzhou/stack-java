<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <h4 class="text-center"><label class="label label-primary">表单</label></h4>
        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel" id="methodObj">

        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <div class="row">
                <div class="col-md-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample()">情境文本颜色</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testSituationBackgroundExample()">情境背景色</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testSituationOtherExample()">其他</button>
                </div>
            </div>
        </div>
    </div>


    <div class="row" style="margin-top:50px;">
        <div class="col-sm-12 col-lg-12 col-md-12">
            <div style="text-align: center;">
                <a href="${pageContext.request.contextPath}/sys/bootstrapHome" class="btn btn-primary">返回</a>
            </div>
        </div>
    </div>

</div>
</body>

<script type="text/html" id="testBaseExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">情境文本颜色</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                通过颜色来展示意图，Bootstrap 提供了一组工具类。这些类可以应用于链接，并且在鼠标经过时颜色可以还可以加深，就像默认的链接一样。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="bs-example bs-example-bg-classes" data-example-id="contextual-backgrounds-helpers">
                <p class="bg-primary">Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p class="bg-success">Duis mollis, est non commodo luctus, nisi erat porttitor ligula.</p>
                <p class="bg-info">Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
                <p class="bg-warning">Etiam porta sem malesuada magna mollis euismod.</p>
                <p class="bg-danger">Donec ullamcorper nulla non metus auctor fringilla.</p>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testSituationBackgroundExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">情境背景色</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                和情境文本颜色类一样，使用任意情境背景色类就可以设置元素的背景。链接组件在鼠标经过时颜色会加深，就像上面所讲的情境文本颜色类一样。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="bs-example bs-example-bg-classes" data-example-id="contextual-backgrounds-helpers">
                <p class="bg-primary">Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p class="bg-success">Duis mollis, est non commodo luctus, nisi erat porttitor ligula.</p>
                <p class="bg-info">Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
                <p class="bg-warning">Etiam porta sem malesuada magna mollis euismod.</p>
                <p class="bg-danger">Donec ullamcorper nulla non metus auctor fringilla.</p>
            </div>
        </div>
    </div>
</script>


<script type="text/html" id="testSituationOtherExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">关闭按钮</label></h4>
        </div>
        <div class="col-md-12">
            <div class="bs-example" data-example-id="close-icon">
                <p><button type="button" class="close" aria-label="Close"><span aria-hidden="true">×</span></button></p>
            </div>
        </div>
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">三角符号</label></h4>
        </div>
        <div class="col-md-12">
            <div class="bs-example" data-example-id="caret">
                <span class="caret"></span>
            </div>
        </div>
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">快速浮动</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                通过添加一个类，可以将任意元素向左或向右浮动。!important 被用来明确 CSS 样式的优先级。这些类还可以作为 mixin（参见 less 文档） 使用。
                <code>
                    &lt;div class=&quot;pull-left&quot;&gt;...&lt;/div&gt;
                    &lt;div class=&quot;pull-right&quot;&gt;...&lt;/div&gt;
                </code>
            </blockquote>
        </div>
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">让内容块居中</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                为任意元素设置 display: block 属性并通过 margin 属性让其中的内容居中。下面列出的类还可以作为 mixin 使用。
                <code>
                    &lt;div class=&quot;center-block&quot;&gt;...&lt;/div&gt;
                </code>
            </blockquote>
        </div>
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">清除浮动</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                通过为父元素添加 .clearfix 类可以很容易地清除浮动（float）。这里所使用的是 Nicolas Gallagher 创造的 micro clearfix 方式。此类还可以作为 mixin 使用。
                <code>
                    &lt;!-- Usage as a class --&gt;
                    &lt;div class=&quot;clearfix&quot;&gt;...&lt;/div&gt;
                </code>
            </blockquote>
        </div>
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">显示或隐藏内容</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                .show 和 .hidden 类可以强制任意元素显示或隐藏(对于屏幕阅读器也能起效)。这些类通过 !important 来避免 CSS 样式优先级问题，就像 quick floats 一样的做法。注意，这些类只对块级元素起作用，另外，还可以作为 mixin 使用。
                <code>
                    &lt;div class=&quot;show&quot;&gt;...&lt;/div&gt;
                    &lt;div class=&quot;hidden&quot;&gt;...&lt;/div&gt;
                </code>
            </blockquote>
        </div>
    </div>
</script>



<script>

    var methodObj = {};

    methodObj.testBaseExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample").html());
    };

    methodObj.testSituationBackgroundExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testSituationBackgroundExample").html());
    };

    methodObj.testSituationOtherExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testSituationOtherExample").html());
    };

</script>

</html>
