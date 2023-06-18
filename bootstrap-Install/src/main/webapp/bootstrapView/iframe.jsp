<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">


    <div class="row">

        <div class="col-md-12">
            <blockquote>
                具有响应式特性的嵌入内容
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="bs-docs-section">
                <h1 id="responsive-embed" class="page-header">具有响应式特性的嵌入内容</h1>

                <p>根据被嵌入内容的外部容器的宽度，自动创建一个固定的比例，从而让浏览器自动确定视频或 slideshow 的尺寸，能够在各种设备上缩放。</p>
                <p>这些规则被直接应用在 <code>&lt;iframe&gt;</code>、<code>&lt;embed&gt;</code>、<code>&lt;video&gt;</code> 和 <code>&lt;object&gt;</code>
                    元素上。如果你希望让最终样式与其他属性相匹配，还可以明确地使用一个派生出来的 <code>.embed-responsive-item</code> 类。</p>
                <p><strong>超级提示：</strong> 不需要为 <code>&lt;iframe&gt;</code> 元素设置 <code>frameborder="0"</code>
                    属性，因为我们已经替你这样做了！</p>
                <div class="bs-example" data-example-id="responsive-embed-16by9-iframe-youtube">
                    <div class="embed-responsive embed-responsive-16by9">
                        <!-- <iframe class="embed-responsive-item" src="//www.youtube.com/embed/zpOULjyy-n8?rel=0" allowfullscreen></iframe> -->
                    </div>
                </div>
                <figure class="highlight"><pre><code class="language-html" data-lang="html"><span class="c">&lt;!-- 16:9 aspect ratio --&gt;</span>
                <span class="nt">&lt;div</span> <span class="na">class=</span><span class="s">"embed-responsive embed-responsive-16by9"</span><span
                            class="nt">&gt;</span>
                  <span class="nt">&lt;iframe</span> <span class="na">class=</span><span class="s">"embed-responsive-item"</span> <span
                            class="na">src=</span><span class="s">"..."</span><span
                            class="nt">&gt;&lt;/iframe&gt;</span>
                <span class="nt">&lt;/div&gt;</span>

                <span class="c">&lt;!-- 4:3 aspect ratio --&gt;</span>
                <span class="nt">&lt;div</span> <span class="na">class=</span><span class="s">"embed-responsive embed-responsive-4by3"</span><span
                            class="nt">&gt;</span>
                  <span class="nt">&lt;iframe</span> <span class="na">class=</span><span class="s">"embed-responsive-item"</span> <span
                            class="na">src=</span><span class="s">"..."</span><span
                            class="nt">&gt;&lt;/iframe&gt;</span>
                <span class="nt">&lt;/div&gt;</span></code></pre>
                </figure>
            </div>
        </div>

        <div class="col-md-12">
            <!-- 16:9 aspect ratio -->
            <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="${pageContext.request.contextPath}/bootstrapView/pic.jpg"></iframe>
            </div>
            <hr/>
            <!-- 4:3 aspect ratio -->
            <div class="embed-responsive embed-responsive-4by3">
                <iframe class="embed-responsive-item" src="${pageContext.request.contextPath}/bootstrapView/pic.jpg"></iframe>
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
<script>


</script>
</html>
