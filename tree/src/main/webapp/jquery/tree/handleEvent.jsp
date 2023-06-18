<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>jquery tree 事件处理</title>
    <style>
        .info {
            padding: .75rem 1.25rem;
            margin-bottom: 1rem;
            border-radius: .25rem;
            position: fixed;
            top: 1rem;
            background-color: white;
            width: auto;
            min-width: 22rem;
            border-width: 0;
            right: 1rem;
            box-shadow: 0 2px 6px 0 rgba(114, 124, 245, .5);
        }
    </style>
</head>
<body class="container">
<div class="row">
    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div id="tree"></div>
    </div>

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="panel-body">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><i class="fa fa-address-card"></i> <a onclick="objTree.getSelect()" class="btn-default btn">获取所选择的</a></li>
                <li class="list-group-item"><i class="fa fa-plus"></i> <a onclick="objTree.collapseAll()" class="btn-default btn">collapseAll</a></li>
                <li class="list-group-item"><i class="fa fa-minus"></i> <a onclick="objTree.expandAll()" class="btn-default btn">expandAll</a></li>
                <li class="list-group-item"><i class="fa"></i> <a onclick="objTree.expandNode()" class="btn-default btn">expandNode</a></li>
                <li class="list-group-item"><i class="fa fa-check-square"></i> <a onclick="objTree.checkAll()" class="btn-default btn">checkAll</a></li>
                <li class="list-group-item"><i class="fa fa-square-o"></i> <a onclick="objTree.uncheckAll()" class="btn-default btn">uncheckAll</a></li>
                <li class="list-group-item"><i class="fa fa-minus-circle"></i> <a onclick="objTree.clearSearch()" class="btn-default btn">clearSearch</a></li>
                <li class="list-group-item"><i class="fa "></i> <a onclick="objTree.enableAll()" class="btn-default btn">enableAll</a></li>
                <li class="list-group-item"><i class="fa "></i> <a onclick="objTree.disableAll()" class="btn-default btn">disableAll</a></li>
            </ul>
        </div>
    </div>

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/jquery">返回</a></li>
            </ul>
        </div>
    </div>
    <div class="info" style="width:200px;">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="节点搜索">
            <span class="input-group-addon" onclick="objTree.searchFun(this)">搜索</span>
        </div>
    </div>
</div>
</body>
<script>


    var objTree = {};

    var $tree;

    objTree.loadInit = function () {
        var data = JSON.parse('${trees}');
        $tree = $('#tree').treeview({
            data: data, //列表树上显示的数据
            levels: 5,
            icon: "fa fa-user-circle-o",
            color: "#428bca", //设置列表树所有节点的前景色
            backColor: "#FFFFFF", //设置所有列表树节点的背景颜色
            showCheckbox: true,//是否在节点上显示checkboxesb====>很重要
            showBorder: true,//是否在节点上显示边框。
            selectable: false,//指定列表树的节点是否可选择。设置为false将使节点展开，并且不能被选择。
            showIcon: true,//是否显示节点图标。
            showTags: true,//是否在每个节点右边显示tags标签。tag值必须在每个列表树的data结构中给出。
            multiSelect: true,//是否可以同时选择多个节点。
            selectedIcon: "fa fa-check-square-o", //设置所有被选择的节点上的默认图标
            nodeIcon: 'fa fa-user-circle-o', //设置所有列表树节点上的默认图标。
            checkedIcon: 'fa fa-check-square-o',//设置处于checked状态的复选框图标
            expandIcon: "fa fa-plus-square",//设置列表树可展开节点的图标。
            collapseIcon: "fa fa-minus-square",//设置列表树可收缩节点的图标。
            uncheckedIcon: 'fa fa-square-o',//设置图标为未选择状态的checkbox图标
            state: {//一个节点的初始状态
                checked: false,//指示一个节点是否处于checked状态，用一个checkbox图标表示
                disabled: false,//指示一个节点是否处于disabled状态。（不是selectable，expandable或checkable）
                expanded: false,//指示一个节点是否处于展开状态。
                selected: false//指示一个节点是否可以被选择。
            },
            onNodeSelected: function (event, data) {

            },
            onNodeChecked: function (event, node) {

            }
        });
    };

    objTree.getSelect = function () {
        var data = $tree.treeview('getSelected', [$('#input-check-node').val(), {
            ignoreCase: false,
            exactMatch: false
        }]);
        var html = "";
        $.each(data, function (i, item) {
            html += "<div class='panel'>";
            html += "<span class='label label-success'>" + item.id + "</span>";
            html += "<span class='label label-primary'>" + item.text + "</span>";
            html += "<br>";
            html += "</div>";
        });
        bootbox.confirm({
            message: html,
            buttons: {
                confirm: {
                    label: 'Yes',
                    className: 'btn-success'
                },
                cancel: {
                    label: 'No',
                    className: 'btn-danger'
                }
            },
            callback: function (result) {
                if (result) {
                    console.log("ok");
                }
            }
        });
    };

    objTree.collapseAll = function () {
        $tree.treeview('collapseAll', {silent: $('#chk-expand-silent').is(':checked')});
    };

    objTree.expandAll = function () {
        var levels = $('#select-expand-all-levels').val();
        $tree.treeview('expandAll', { levels: levels, silent: $('#chk-expand-silent').is(':checked') });
    };

    objTree.clearSearch = function () {
        $tree.treeview('clearSearch');
        $('#input-search').val('');
        $('#search-output').html('');
    };

    objTree.expandNode = function () {
        var levels = $('#select-expand-node-levels').val();
        var expandibleNodes = {
            createTime: 1545570202176,
            id: 2000,
            nodeId: 200,
            nodes: [],
            num: 1497.5385121443612,
            parentId: 88,
            searchResult: true,
            selectable: true,
            state: {checked: false, disabled: false, expanded: false, selected: false},
            text: "zch"
        } ;
        console.log("expandNode") ;
        $tree.treeview('expandNode', [ expandibleNodes, { levels: levels, silent: $('#chk-expand-silent').is(':checked') }]);
    };

    objTree.checkAll = function () {
        $tree.treeview('checkAll', { silent: $('#chk-check-silent').is(':checked') });
    };

    objTree.uncheckAll = function () {
        $tree.treeview('uncheckAll', { silent: $('#chk-check-silent').is(':checked') });
    };

    objTree.enableAll = function () {
        $tree.treeview('enableAll', { silent: $('#chk-disable-silent').is(':checked') });
    };

    objTree.disableAll = function () {
        $tree.treeview('disableAll', { silent: $('#chk-disable-silent').is(':checked') });
    };

    objTree.searchFun = function (that) {
        var text = $(that).prev().val();
        var options = {
            ignoreCase: $('#chk-ignore-case').is(':checked'),
            exactMatch: $('#chk-exact-match').is(':checked'),
            revealResults: $('#chk-reveal-results').is(':checked')
        };
        var results = $tree.treeview('search', [text, options]);
        var html = "";
        $.each(results, function (i, item) {
            html += "<div class='panel'>";
            html += "<span class='label label-success'>" + item.id + "</span>";
            html += "<span class='label label-primary'>" + item.text + "</span>";
            html += "<br>";
            html += "</div>";
        });
        bootbox.alert({
            message: html,
            callback: function () {
                console.log(results);
            }
        });
    };

    $(document).ready(function () {
        objTree.loadInit();
    });


    /* 注意要加上on
    nodeChecked (event, node)：一个节点被checked。
    nodeCollapsed (event, node)：一个节点被折叠。
    nodeDisabled (event, node)：一个节点被禁用。
    nodeEnabled (event, node)：一个节点被启用。
    nodeExpanded (event, node)：一个节点被展开。
    nodeSelected (event, node)：一个节点被选择。
    nodeUnchecked (event, node)：一个节点被unchecked。
    nodeUnselected (event, node)：取消选择一个节点。
    searchComplete (event, results)：搜索完成之后触发。
    searchCleared (event, results)：搜索结果被清除之后触发。
    **/

    //https://www.cnblogs.com/cpcpc/p/7217926.html
    //https://www.npmjs.com/package/bootstrap-treeview

</script>
</html>
