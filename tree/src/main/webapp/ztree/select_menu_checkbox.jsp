<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>带 checkbox 的多选</title>
</head>
<body class="container">

<div class="row">
    <div class="col-xl-12 col-sm-12 col-lg-12 col-md-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="btn-group ">
            <button type="button" class="btn btn-primary btn-lg" onclick="baseObj.getCheckbox(true);">
                勾选的多选数据
            </button>
        </div>
    </div>

    <div class="col-xl-12 col-sm-12 col-lg-12 col-md-12" style="margin-top:10px;margin-bottom:10px;">
        <ul id="treeDemo" class="ztree"></ul>
    </div>

    <div class="col-xl-12 col-sm-12 col-lg-12 col-md-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/ztree">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>

<script>

    var baseObj = {};

    baseObj.getCheckbox = function () {
        var zTree = $.fn.zTree.getZTreeObj(baseObj.config.tree.prop("id"));
        var nodes = zTree.getCheckedNodes(true), v = "";

        for (var i=0, l=nodes.length; i<l; i++) {
            v += nodes[i].name + ",";
        }
        if (v.length > 0 ) v = v.substring(0, v.length-1);
        bootbox.alert(v,function () {
            zTree.checkAllNodes(false);//checked = true 表示勾选全部节点     ,   checked = false 表示全部节点取消勾选
        });
    };




    function zTreeOnClick() {

    }

    baseObj.config = {
        tree: $("#treeDemo"),
        model: $("#modeTreeNodeDiv")
    };




    baseObj.loadTree = function () {
        var zTreeObj;

        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {
            //页面上的显示效果
            view: {
                selectedMulti: true,
                expandSpeed: "slow",
                fontCss: {color: "red"}
            },
            check: {
                enable: true,
                chkboxType: {"Y":"", "N":""}
            },
            callback: {
                onClick: zTreeOnClick
            },
            data: {
                key: {
                    name: "name"
                },
                simpleData: {//json 数据必须设置
                    enable: true,//true / false 分别表示 使用 / 不使用 简单数据模式
                    idKey: "id",
                    pIdKey: "pid",
                    rootPId: 0
                }
            }
        };
        $.ajax({
            url: "${pageContext.request.contextPath}/treeNode/getTreeNodeList",
            type: "get",
            dataType: "json",
            data: {ipType: "ipv4"},
            success: function (result) {
                if (result.ret) {
                    $.fn.zTree.destroy();
                    zTreeObj = $.fn.zTree.init(baseObj.config.tree, setting, result.data);
                    zTreeObj.expandAll(true);
                }
            },
            error: function (result) {

            }
        });
    };


    $(document).ready(function () {
        baseObj.loadTree();
    });


</script>
</html>
