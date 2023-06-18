<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">
    <div class="x_panel">
        <div class="x_title">
            <h2>
            </h2>
            <div class="clearfix"></div>
        </div>

        <div class="x_content">
            <div class="form-group ">
                <div class="col-sm-12">
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <td>使用VS2017编写C语言程序</td>
                        </tr>
                        <tr>
                            <td>在 VS 2017 下开发程序首先要创建项目，不同类型的程序对应不同类型的项目</td>
                        </tr>
                        <tr>
                            <td>打开 VS 2017，在菜单栏中依次选择 “文件 --> 新建 --> 项目”</td>
                        </tr>
                        <tr>
                            <td>选择空项目 , 填写好项目名称，选择好存储路径，同时对于初学者来说，可取消勾选 “为解决方案创建目录”，点击 “确定” 按钮即可。</td>
                        </tr>
                        <tr>
                            <td>点击 “确定” 按钮后，会直接进入项目可操作界面，我们将在这个界面完成所有的编程工作</td>
                        </tr>
                        <tr>
                            <td>
                                点击 视图 切换到 解决方案资源管理器 (必须)
                            </td>
                        </tr>
                        <tr>
                            <td>
                                点击 源文件
                                此分类中，我们选择 “C++文件（.cpp）”，编写 C 语言程序时，注意源文件后缀名为 .c ,点击 “添加” 按钮，就添加上了一个新的源文件。
                                打开 hello.c
                            </td>
                        </tr>
                        <tr>
                            <td>
                                “生成 --> 编译”，就完成了 hello.c 源文件的编译工作
                            </td>
                        </tr>
                        <tr>
                            <td>链接（Link）
                                在菜单栏中选择 “项目 --> 仅用于项目 --> 仅连接 Demo” ， 就完成了 hello.obj 链接工作</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

        <div class="row" style="margin-top:50px;">
            <div class="col-sm-12 col-lg-12 col-md-12">
                <div style="text-align: center;">
                    <a href="${pageContext.request.contextPath}/sys/cAddHome" class="btn btn-primary">返回</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>


</script>
</html>
