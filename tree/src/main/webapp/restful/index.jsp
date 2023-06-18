<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
</head>
<body class="container">
<div class="row">

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <button type="button" class="btn btn-primary btn-lg" onclick="obj.showModel({});">
            添加
        </button>
        <button type="button" class="btn btn-primary btn-lg" onclick="obj.removeAll({});">
            多个数据删除
        </button>
    </div>

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <form class="form-horizontal">
            <table class="table table-bordered" id="oTable" style="height: auto">

            </table>
        </form>
    </div>

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="panel-body panel">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/home">返回</a></li>
            </ul>
        </div>
    </div>

</div>
<script>
    var obj = {};

    obj.config = {
        model: $("#modeUserDiv")
    };

    //请求参数设置
    function queryParams(params) {
        return {
            offset: params.offset,      //从数据库第几条记录开始
            limit: params.limit        //找多少条
        }
    }

    obj.initForm = function (data) {
        var model = obj.config.model.selector;
        model = $(model);
        var frm = model.find("form");
        frm.clearAll();
        frm.initForm(data);
    };

    obj.showModel = function (data) {
        var model = obj.config.model.selector;
        model = $(model);
        obj.initForm(data);
        model.modal("show");
    };

    obj.init = function () {
        var cols = [{
            checkbox: true
        },
            {
                field: 'age',
                title: '年龄'
            },
            {
                field: 'userName',
                title: '用户名'
            },
            {
                field: 'password',
                title: '密码'
            },
            {
                field: 'authority',
                title: '权限'
            },
            {
                field: 'role',
                title: '角色'
            },
            {
                field: 'id',
                title: '操作',
                formatter: function (value, row, index) {
                    var str = "";
                    str += "<div>";
                    str += "<a class='btn-default btn' onclick='obj.delete(" + row.id + ")'" + ">" + "<i class='fa fa-trash-o fa-fw'>" + '</i>' + "</a>";
                    str += "<a class='btn-default btn' onclick='obj.edit(" + row.id + ")'" + ">" + "<i class='fa fa-pencil fa-fw'>" + '</i>' + "</a>";
                    str += "</div>";
                    return str;
                }
            }
        ];
        var target = $("#oTable");
        target.bootstrapTable('destroy');
        target.bootstrapTable({
            url: '${pageContext.request.contextPath}/api/user/getBootstrapTableVo',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: queryParams,//传递参数（*）
            queryParamsType: "limit",//设置为 ‘limit’ 则会发送符合 RESTFul 格式的参数.
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            contentType: "application/x-www-form-urlencoded",
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: false,                //是否启用点击选中行
            height: 600,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: cols
        });
    };

    obj.removeAll = function () {
        var target = $("#oTable");
        var rows = target.bootstrapTable('getSelections');
        var data = [];
        $.each(rows, function (i, item) {
            data.push(item.id);
        });
        if (rows.length == 0) {
            toastr.warning("至少选择一个!");
            return false;
        }
        bootbox.confirm({
            size: "small",
            message: "Are you sure?",
            callback: function (result) {
                if (result) {
                    obj.deleteServer(data.join(","), function () {
                        obj.init();
                        toastr.info("删除成功!…");
                    });
                }
            }
        });
    };

    obj.delete = function (id) {
        var model = obj.config.model.selector;
        model = $(model);
        bootbox.confirm("Are you sure?", function (result) {
            if (result) {
                obj.deleteServer(id, function () {
                    obj.init();
                    toastr.info("删除成功!…");
                    model.modal("hide");
                });
            }
        });
    };

    obj.deleteServer = function (id, callback) {
        $.ajax({
            url: "${pageContext.request.contextPath}/api/user/delete/" + id,
            type: "post",
            dataType: "json",
            data: {"_method": "DELETE"},
            success: function (result) {
                if (result.ret) {
                    if (callback) {
                        callback();
                    }
                }
            },
            error: function (result) {
                console.log(result);
            }
        });
    };

    obj.edit = function (id) {
        var target = $("#oTable");
        var item = target.bootstrapTable('getRowByUniqueId', id);
        obj.showModel(item);
    };

    obj.saveData = function () {
        var model = obj.config.model.selector;
        model = $(model);
        var frm = model.find("form");
        if (!frm.valid()) {
            return false;
        }
        var data = formSerializeArray(frm);
        $.ajax({
            url: "${pageContext.request.contextPath}/api/user/save",
            type: "post",
            dataType: "json",
            data: {formData: JSON.stringify(data)},
            success: function (result) {
                if (result.ret) {
                    obj.init();
                    bootbox.alert("save成功!");
                    model.modal("hide");
                }
            },
            error: function (result) {
                console.log(result);
            }
        });
    };

    $(document).ready(function () {
        obj.init();
    });
</script>

<!-- 模态框（Modal） -->
<div id="modeUserDiv" class="modal fade bs-example-modal-lg" data-backdrop="static" tabindex="-1"
     role="dialog"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h3 class="modal-title">restful ..</h3>
            </div>
            <form class="form-horizontal">
                <input type="hidden" name="id">
                <div class="modal-body">
                    <div class="row">
                        <div class=" col-xs-12  col-sm-12  col-md-12  col-lg-12 ">
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="x-valid">
                                        <label class=" col-xs-2  col-sm-2  col-md-2  col-lg-2  control-label">
                                            名称<span class="symbol required"></span>
                                        </label>
                                        <div class=" col-xs-10  col-sm-10  col-md-10  col-lg-10 ">
                                            <input type="text" class="form-control" name="userName"
                                                   placeholder="名称" required="required">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="x-valid">
                                        <label class=" col-xs-2  col-sm-2  col-md-2  col-lg-2  control-label">
                                            密码<span class="symbol required"></span>
                                        </label>
                                        <div class=" col-xs-10  col-sm-10  col-md-10  col-lg-10 ">
                                            <input type="text" class="form-control" name="password"
                                                   placeholder="密码" required="required">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="x-valid">
                                        <label class=" col-xs-2  col-sm-2  col-md-2  col-lg-2  control-label">
                                            年龄<span class="symbol required"></span>
                                        </label>
                                        <div class=" col-xs-10  col-sm-10  col-md-10  col-lg-10 ">
                                            <input type="text" class="form-control" name="age"
                                                   placeholder="年龄" required="required">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="x-valid">
                                        <label class=" col-xs-2  col-sm-2  col-md-2  col-lg-2  control-label">
                                            角色
                                        </label>
                                        <div class=" col-xs-10  col-sm-10  col-md-10  col-lg-10 ">
                                            <input type="text" class="form-control" name="role"
                                                   placeholder="角色">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="x-valid">
                                        <label class=" col-xs-2  col-sm-2  col-md-2  col-lg-2  control-label">
                                            权限
                                        </label>
                                        <div class=" col-xs-10  col-sm-10  col-md-10  col-lg-10 ">
                                            <input type="text" class="form-control" name="authority"
                                                   placeholder="权限">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <div class="modal-footer">
                <button type="button" data-dismiss="modal" class="btn btn-default">
                    取消
                </button>
                <button type="button" class="btn btn-primary"
                        onclick="obj.saveData(this);">
                    保存
                </button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
