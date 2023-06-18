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
        <form class="cmxform" id="signupForm" method="get" action="">
            <fieldset>
                <legend>验证完整的表单</legend>
                <p>
                    <input id="firstname" name="firstname" type="text" required="required">
                </p>
                <p>
                    <input id="lastname" name="lastname" type="text" required="required">
                </p>
                <p>
                    <input id="username" name="username" type="text" required="required">
                </p>
                <p>
                    <input id="password" name="password" type="password" required="required">
                </p>
                <p>
                    <input id="confirm_password" name="confirm_password" type="password" required="required">
                </p>
                <p>
                    <label for="email">Email</label>
                    <input id="email" name="email" type="email" required="required">
                </p>
                <p>
                    <input  type="radio" id="gender_male" value="m" name="gender" required="required" />
                    <input  type="radio" id="gender_female" value="f" name="gender"/>
                </p>
                <p>
                    <input type="checkbox" class="checkbox" id="spam_email" value="email" name="spam[]" required minlength="2" />
                    <input type="checkbox" class="checkbox" id="spam_phone" value="phone" name="spam[]" />
                    <input type="checkbox" class="checkbox" id="spam_mail" value="mail" name="spam[]" />
                </p>
                <p>
                    <select id="jungle" name="jungle" title="Please select something!" required>
                        <option value=""></option>
                        <option value="1">Buga</option>
                        <option value="2">Baga</option>
                        <option value="3">Oi</option>
                    </select>
                </p>

            </fieldset>
        </form>
    </div>

    <div class="col-lg-12 col-md-12 col-sm-12 col-xl-12" style="margin-top: 20px;">
        <label class="btn btn-default" onclick="addUser()">submit</label>
    </div>

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
    $(function () {
        //表单验证
        $("#signupForm").validate({
            submitHandler:function() {
                alert("Submitted!");
                },
            messages: {
                firstname: "请输入您的名字",
                lastname: "请输入您的姓氏",
                username: {
                    required: "请输入用户名",
                    minlength: "用户名必需由两个字母组成"
                },
                password: {
                    required: "请输入密码",
                    minlength: "密码长度不能小于 5 个字母"
                },
                confirm_password: {
                    required: "请输入密码",
                    minlength: "密码长度不能小于 5 个字母",
                    equalTo: "两次密码输入不一致"
                },
                email: "请输入一个正确的邮箱",
                agree: "请接受我们的声明",
                topic: "请选择两个主题"
            }
        });
    });

    function addUser(){
        //收集数据
        var data = formParams("signupForm");
        console.log(data);
        var flag = $("#signupForm").valid();
        if(!flag){
            //没有通过验证
            return;
        }
    }
</script>
