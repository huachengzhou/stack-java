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
        <form class="form-horizontal" role="form" id="objFunFrm">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">名字</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="firstname"  required="required"
                           placeholder="请输入名字">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">姓</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="lastname"  required="required"
                           placeholder="请输入姓">
                </div>
            </div>
            <div class="form-group">
                <label for="gendex" class="col-sm-2 control-label">姓别</label>
                <div class="col-sm-10">
                    <select required="required" class="form-control search-select select2" name="gendex" id="gendex">
                        <option value="0">男</option>
                        <option value="1">女</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="remerberMe" required="required"> 请记住我
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" onclick="addUser()">登录</button>
                    <button type="button" class="btn btn-default" onclick="objFun.initForm()">赋值</button>
                </div>
            </div>
        </form>
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
    var objFun = new Object();
    objFun.select2Init = function () {
        $("#objFunFrm #gendex").select2();
    }
    objFun.initForm = function () {
        var data = {firstname:Math.round(Math.random()*10),lastname:Math.round(Math.random()*10)};
        $("#objFunFrm").initForm(data);
    }
    $(function () {
        //表单验证
        $("#objFunFrm").validate({
            submitHandler:function() {
            }
        });
        objFun.select2Init();
    });

    function addUser(){
        //收集数据
        var data = formParams("objFunFrm");
        console.log(data);
        var flag = $("#objFunFrm").valid();
        if(!flag){
            //没有通过验证
            return;
        }
    }
</script>
