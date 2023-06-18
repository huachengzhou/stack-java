<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>el 表达式</title>
</head>
<body class="container">

<div class="row">

    <div class="col-xl-12 col-sm-12 col-lg-12 col-md-12" style="margin-top:10px;margin-bottom:10px;">
        <code>

            &lt;%
            pageContext.setAttribute(&quot;name1&quot;, &quot;zhangsan&quot;);
            request.setAttribute(&quot;name2&quot;, &quot;lisi&quot;);
            session.setAttribute(&quot;name3&quot;, &quot;wangwu&quot;);
            application.setAttribute(&quot;name4&quot;, &quot;liuliu&quot;);
            %&gt;

            <!--范围.参数名 -->

            &lt;$ &lt;{pageScope.name1 }  &lt;$ &lt;{requestScope.name2 }  &lt;$ &lt;{sessionScope.name3 }
            &lt;$ &lt;{applicationScope.name4 }
        </code>
    </div>

    <div class="col-xl-12 col-sm-12 col-lg-12 col-md-12" style="margin-top:10px;margin-bottom:10px;">

    </div>

    <div class="col-xl-12 col-sm-12 col-lg-12 col-md-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/jstl">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>

<script>



</script>
</html>
