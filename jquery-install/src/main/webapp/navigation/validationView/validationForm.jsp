<%--
  Created by IntelliJ IDEA.
  User: 13426
  Date: 2018/8/26
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>jquery 对 form 表单的提交校验</title>
</head>
<body class="container">
<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xl-12" style="margin-top: 20px;">
    </div>
    <form class="form-horizontal" enctype="multipart/form-data" id="commentForm">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xl-12">
                <div>
                    <label class="col-lg-1 col-md-1 col-sm-1 col-xl-1 control-label">电话</label>
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xl-3">
                        <input type="text" name="phone"
                               placeholder="电话" class="form-control" required="required">
                    </div>
                </div>
                <div>
                    <label class="col-lg-1 col-md-1 col-sm-1 col-xl-1 control-label">数字</label>
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xl-3">
                        <input type="text" name="number"
                               placeholder="数字" class="form-control" required="required">
                    </div>
                </div>
                <div>
                    <label class="col-lg-1 col-md-1 col-sm-1 col-xl-1 control-label">邮箱</label>
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xl-3">
                        <input type="text" name="email"
                               placeholder="邮箱" class="form-control" required="required">
                    </div>
                </div>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xl-12" style="margin-top:20px;">
            <div>
                <label class="col-lg-1 col-md-1 col-sm-1 col-xl-1 control-label"></label>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xl-4">
                    <input type="submit" class="btn btn-success" value="submit">
                </div>
            </div>
        </div>
    </form>
    <div class="col-lg-12 col-md-12 col-sm-12 col-xl-12" style="margin-top:20px;">
        <div class="col-lg-3 col-md-3 col-sm-3 col-xl-3">
        </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xl-3">
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 col-xl-6">
            <a href="${pageContext.request.contextPath}/sys/jqueryValidation" class="btn btn-success">返回<i class="fa fa-retweet"></i> </a>
        </div>
    </div>
</div>
</body>
</html>
<script>

    $().ready(function() {
        console.log("被触发!");
        $("#commentForm").validate();
    });

    $.validator.setDefaults({
        submitHandler: function() {
            alert("提交事件!");
        }
    });
</script>
