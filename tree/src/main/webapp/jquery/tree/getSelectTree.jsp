<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/css/cssBootStrap.jsp" %>
<html>
<head>
    <title>jquery tree 获取所选数据</title>

    <%--<link href="${pageContext.request.contextPath}/assembly/plugins/bootstrap/bootstrap-treeview/bootstrap-treeview.min.css" rel="stylesheet">--%>
    <%--<script src="${pageContext.request.contextPath}/assembly/plugins/bootstrap/bootstrap-treeview/bootstrap-treeview.min.js"></script>--%>

    <%--<script src="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/js/jquery.treegrid.js"></script>--%>
    <%--<link href="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/css/jquery.treegrid.css" rel="stylesheet">--%>
</head>
<body class="container">
<div class="row">
    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div id="tree"></div>
    </div>

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div class="panel-footer">
            <ul style="margin-top:20px;margin-right:20px;">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/sys/jquery">返回</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
<script>

    var data = JSON.parse('${trees}');

    $('#tree').treeview({
        data: data, //列表树上显示的数据
        levels: 5,
        icon: "fa fa-user-circle-o",
        color: "#428bca", //设置列表树所有节点的前景色
        backColor: "#FFFFFF", //设置所有列表树节点的背景颜色
        showCheckbox: false,//是否在节点上显示checkboxesb====>很重要
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
            console.log(data);
            // bootbox.alert("所选择的node name:"+data.text);
            bootbox.confirm("所选择的node name:" + data.text, function (result) { /* your callback code */
            });
        },
        onNodeChecked: function (event, node) {
            console.log(node);
            bootbox.alert("所选择的node name:" + node.text);
        }
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


    //单独
    // $('#tree').on('nodeSelected', function(event, data) {
    //     console.log(data);
    //     // bootbox.alert("所选择的node name:"+data.text);
    //     bootbox.confirm("所选择的node name:"+data.text, function(result){ /* your callback code */ }) ;
    // });
</script>
</html>
