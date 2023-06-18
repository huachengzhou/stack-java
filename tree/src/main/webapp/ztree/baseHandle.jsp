<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>ztree 第一个例子</title>
</head>

<div id="modeTreeNodeDiv" class="modal fade bs-example-modal-lg" data-backdrop="static" tabindex="-1"
     role="dialog"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h3 class="modal-title">tree table</h3>
            </div>
            <form class="form-horizontal">
                <input type="hidden" name="id">
                <input type="hidden" name="tId">
                <input type="hidden" name="pid" value="0">
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
                                            <input type="text" class="form-control" name="name"
                                                   placeholder="名称" required="required">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="x-valid">
                                        <label class=" col-xs-2  col-sm-2  col-md-2  col-lg-2  control-label">
                                            日期<span class="symbol required"></span>
                                        </label>
                                        <div class=" col-xs-10  col-sm-10  col-md-10  col-lg-10 ">
                                            <input type="text" class="form-control form_datetime" name="exampleDate"
                                                   placeholder="日期" required="required">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="x-valid">
                                        <label class=" col-xs-2  col-sm-2  col-md-2  col-lg-2  control-label">
                                            html文本<span class="symbol required"></span>
                                        </label>
                                        <div class=" col-xs-10  col-sm-10  col-md-10  col-lg-10 ">
                                            <input type="text" class="form-control" name="htmlText"
                                                   placeholder="html文本" required="required">
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
                        onclick="baseObj.saveData(this);">
                    保存
                </button>
            </div>
        </div>
    </div>
</div>

<body class="container">

<div class="row">

    <div class="col-xl-12 col-sm-12 col-lg-12 col-md-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="btn-group ">
            <button type="button" class="btn btn-primary btn-lg" onclick="baseObj.showModel(true);">
                新增
            </button>
            <button type="button" class="btn btn-primary btn-lg" onclick="baseObj.editData(true)">
                编辑
            </button>
            <button type="button" class="btn btn-primary btn-lg" onclick="baseObj.deleteData(true);">
                删除
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


    /**
     * 配合 addHoverDom()
     * @param treeId
     * @param treeNode
     */
    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_" + treeNode.tId).unbind().remove();
        $("#editBtn_" + treeNode.tId).unbind().remove();
        $("#deleteBtn_" + treeNode.tId).unbind().remove();
    }


    /**
     * 非常重要的添加操作dom
     * @param treeId
     * @param treeNode
     */
    function addHoverDom(treeId, treeNode) {
        var element = $("#" + treeNode.tId + "_span"); //获取节点信息
        if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
        var html = "";

        html += "<span class=' button add' id='addBtn_" + treeNode.tId + "' title='添加数据'>" + "</span>";//定义添加按钮
        html += "<span class=' button edit' id='editBtn_" + treeNode.tId + "' title='编辑数据'>" + "</span>";//定义编辑按钮
        html += "<span class=' button remove' id='deleteBtn_" + treeNode.tId + "' title='删除数据'>" + "</span>";//定义删除按钮


        element.after(html); //加载添加按钮

        var addBtn = $("#addBtn_" + treeNode.tId);
        var editBtn = $("#editBtn_" + treeNode.tId);
        var deleteBtn = $("#deleteBtn_" + treeNode.tId);

        //绑定添加事件，并定义添加操作
        if (addBtn) addBtn.bind("click", function (e) {
            baseObj.showModel(false, treeNode.tId);
        });
        //编辑
        if (editBtn) editBtn.bind("click", function (e) {
            baseObj.initForm(treeNode);
            baseObj.config.model.modal("show");
        });
        //删除
        if (deleteBtn) deleteBtn.bind("click", function (e) {
            baseObj.deleteData(false, treeNode.tId);
        });
    }


    function zTreeOnClick() {

    }

    baseObj.config = {
        tree: $("#treeDemo"),
        model: $("#modeTreeNodeDiv")
    };


    baseObj.showModel = function (flag, tId) {
        var data = {pid: 0};
        var zTree = $.fn.zTree.getZTreeObj(baseObj.config.tree.prop("id"));
        var nodes = zTree.getSelectedNodes();
        if (nodes.length > 1) {
            alert("请只选择一个!");
            return false;
        }
        if (nodes.length == 1) {
            var treeNode = nodes[0];
            data.pid = treeNode.id;
            data.tId = treeNode.tId;
        }
        var frm = baseObj.config.model.find("form");
        frm.clearAll();
        baseObj.initForm(data);
        baseObj.config.model.modal("show");
    };

    baseObj.initForm = function (data) {
        var frm = baseObj.config.model.find("form");
        frm.clearAll();
        if (data.exampleDate) {
            frm.find("input[name='exampleDate']").val(formatDate(data.exampleDate, true));
        }
        frm.initForm(data);
    };

    baseObj.editData = function (flag, tId) {
        var zTree = $.fn.zTree.getZTreeObj(baseObj.config.tree.prop("id"));
        var nodes = zTree.getSelectedNodes();
        if (nodes.length > 1) {
            alert("请只选择一个!");
            return false;
        }
        if (nodes.length == 1) {
            var treeNode = nodes[0];
            baseObj.initForm(treeNode);
            baseObj.config.model.modal("show");
        } else {
            alert("至少选择一个!");
            return false;
        }
    };

    baseObj.deleteData = function (flag, tId) {
        var zTree = $.fn.zTree.getZTreeObj(baseObj.config.tree.prop("id"));
        var data = [];
        var node = undefined;
        var nodes = zTree.getSelectedNodes();
        if (flag) {
            if (nodes.length == 0) {
                alert("至少选择一个!");
                return false;
            }
            for (var i = 0; i < nodes.length; i++) {
                data.push(nodes[i].id);
            }
        } else {
            node = zTree.getNodeByTId(tId);
            data.push(node.id)
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/treeNode/deleteTreeNodeById/" + data.join(","),
            type: "post",
            dataType: "json",
            data: {"_method": "DELETE"},
            success: function (result) {
                if (result.ret) {
                    if (flag) {
                        baseObj.loadTree();
                    } else {
                        zTree.removeNode(node);
                    }
                }
            },
            error: function (result) {
                console.log(result);
            }
        });
    };

    baseObj.saveData = function () {
        var frm = baseObj.config.model.find("form");
        if (!frm.valid()) {
            return false;
        }
        var data = formSerializeArray(frm);
        $.ajax({
            url: "${pageContext.request.contextPath}/treeNode/saveAndUpdate",
            type: "post",
            dataType: "json",
            data: {fomData: JSON.stringify(data)},
            success: function (result) {
                if (result.ret) {
                    baseObj.config.model.modal("hide");
                    var item = result.data;
                    var zTree = $.fn.zTree.getZTreeObj(baseObj.config.tree.prop("id"));
                    var parentNode = null;
                    if (data.tId) {
                        parentNode = zTree.getNodeByTId(data.tId);
                    }
                    if (data.id) {
                        //修改 ==>第一种方式是修改完数据然后直接刷新树,第二种是修改完成后拿到node然后在拿到父级接着删除这个节点然后利用最新节点添加节点,最后最好一种是直接更新节点
                        parentNode.name = item.name;
                        zTree.updateNode(parentNode);
                    } else {
                        //新增
                        zTree.addNodes(parentNode, item);//当parentNode id为null一般是添加到第一级(参考zTree api 那上面是这样说的)
                    }
                    baseObj.loadTree();
                }
            },
            error: function (result) {
                console.log(result);
            }
        });
    };

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
            check: {
                enable: false
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
