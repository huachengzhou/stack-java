<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>带 checkbox 的多选</title>
    <link href="${pageContext.request.contextPath}/ztree/awesome.css" rel="stylesheet">
</head>
<body class="container">

<div class="row">

    <div class="col-xl-12 col-sm-12 col-lg-12 col-md-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="row">
            <input type="hidden" name="search">
            <div class="col-xl-6 col-sm-6 col-lg-6 col-md-6 pull-left">
                <input type="text" value="" class="form-control" placeholder="请输入关键字"
                       onblur="baseObj.onSearch(this);"/>
            </div>
            <div class="col-xl-6 col-sm-6 col-lg-6 col-md-6 pull-right">
                <button type="button" class="btn btn-primary btn-lg" onclick="baseObj.search(this);">
                    搜索的数据
                </button>
            </div>
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

    baseObj.search = function (_this) {
        var zTree = $.fn.zTree.getZTreeObj(baseObj.config.tree.prop("id"));
        var row = $(_this).closest(".row");
        var value = row.find("[name='search']").val();
        bootbox.alert(value);
    };

    baseObj.onSearch = function (_this) {
        var value = $(_this).val();
        if (!value) {
            return false;
        }
        var zTree = $.fn.zTree.getZTreeObj(baseObj.config.tree.prop("id"));
        var nodes = zTree.getNodesByParamFuzzy("name", value), vs = [];
        for (var i = 0, l = nodes.length; i < l; i++) {
            vs.push(nodes[i].name);
        }
        var row = $(_this).closest(".row");
        row.find("[name='search']").val(vs.join(","));
    };


    function zTreeOnClick() {

    }

    baseObj.config = {
        tree: $("#treeDemo"),
        model: $("#modeTreeNodeDiv")
    };

    /**
     * 配合 addHoverDom()
     * @param treeId
     * @param treeNode
     */
    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_" + treeNode.tId).unbind().remove();
    }


    /**
     * 非常重要的添加操作dom
     * @param treeId
     * @param treeNode
     */
    function addHoverDom(treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
            + "' title='add node' onfocus='this.blur();'></span>";
        sObj.after(addStr);
    }


    baseObj.loadTree = function () {
        var zTreeObj;

        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {
            //页面上的显示效果
            view: {
                selectedMulti: true,
                addHoverDom: addHoverDom, //当鼠标移动到节点上时，显示用户自定义控件
                removeHoverDom: removeHoverDom,//离开节点时的操作
                expandSpeed: "slow",
                fontCss: {color: "red"}
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
