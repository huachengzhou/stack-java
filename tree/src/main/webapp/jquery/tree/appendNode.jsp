<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jquery tree append node</title>
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/demo/bootstrap/jquery-3.1.1.min.js"
            type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/demo/bootstrap/bootstrap.min.css"
          rel="stylesheet">
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/demo/bootstrap/bootstrap.min.js"
            type="text/javascript"></script>

    <link href="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/demo/plugins/bootstrap-treeview/bootstrap-treeview.min.css"
          rel="stylesheet">
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/demo/plugins/bootstrap-treeview/bootstrap-treeview.js"
            type="text/javascript"></script>

    <link href="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/demo/plugins/bootstrap-dialog/bootstrap-dialog.min.css"
          rel="stylesheet">
    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/demo/plugins/bootstrap-dialog/bootstrap-dialog.min.js"
            type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/assembly/plugins/jquery/tree-grid/demo/javascripts/customPlugin.js"
            type="text/javascript"></script>
</head>
<body class="container">
<div class="row">
    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <div id="tree"></div>
    </div>

    <div class="col-xs-12  col-sm-12  col-md-12  col-lg-12" style="margin-top:10px;margin-bottom:10px;">
        <input id="btnAdd" class="btn btn-primary" type="button" value="添加节点">
        <input id="btnMove" class="btn btn-success" type="button" value="节点移动">
        <input id="btnDel" class="btn btn-danger" type="button" value="删除节点">
    </div>

    <div class="col-xs-4  col-sm-4  col-md-4  col-lg-4">
        <div class="panel panel-primary ">
            <div class="panel-heading">
                <h3 class="panel-title">科目树</h3>
            </div>
            <div class="panel-body right_centent" style="">
                <div id="left-tree"></div>
            </div>
        </div>
    </div>

    <div class="col-xs-8  col-sm-8  col-md-8  col-lg-8">
        <div class="panel panel-primary ">
            <div class="panel-heading">
                <h3 class="panel-title">编辑区</h3>
            </div>
            <!--编辑操作权限 start-->
            <div class="panel-body right_centent">
                <div id="editShow">
                    <div>
                        <div class="input-group margin-t-5">
                            <span class="input-group-addon">名称:</span>

                            <input id="editName" type="text" class="form-control"/>
                        </div>
                    </div>
                    <div style="margin-top: 10px;">
                        <input id="Edit" class="btn btn-primary" type="button" value="确定"/>
                        <input id="Edit_cancel" class="btn btn-default" type="button"
                               style="margin-left:80px;display:none;" value="取消"/>
                    </div>
                </div>
            </div>
            <!--编辑操作权限 end-->
        </div>
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


    $(function () {

        onLoad();

        BindEvent();

        //页面加载
        function onLoad() {
            //渲染树
            $('#left-tree').treeview({
                data: getTree(),
                levels: 1,
                onNodeSelected: function (event, node) {
                    $('#editName').val(node.text);
                },
                showCheckbox: false//是否显示多选
            });
        }

        //事件注册
        function BindEvent() {
            //保存-新增
            $("#Save").click(function () {
                $('#addOperation-dialog').modal('hide')
                //静态添加节点
                var parentNode = $('#left-tree').treeview('getSelected');
                var node = {
                    text: $('#addName').val()
                };
                $('#left-tree').treeview('addNode', [node, parentNode]);

            });
        }

        //保存-编辑
        $('#Edit').click(function () {
            var node = $('#left-tree').treeview('getSelected');
            var newNode = {
                text: $('#editName').val()
            };
            $('#left-tree').treeview('updateNode', [node, newNode]);
        });


        //显示-添加
        $("#btnAdd").click(function () {
            var node = $('#left-tree').treeview('getSelected');
            if (node.length == 0) {
                $.showMsgText('请选择节点');
                return;
            }
            $('#addName').val('');
            $('#addOperation-dialog').modal('show');

        });
        //显示-编辑
        $("#btnEdit").click(function () {
            var node = $('#left-tree').treeview('getSelected');
            $('#editShow').show();

        });
        //删除
        $("#btnDel").click(function () {
            var node = $('#left-tree').treeview('getSelected');
            if (node.length == 0) {
                $.showMsgText('请选择节点');
                return;
            }
            BootstrapDialog.confirm({
                title: '提示',
                message: '确定删除此节点?',
                size: BootstrapDialog.SIZE_SMALL,
                type: BootstrapDialog.TYPE_DEFAULT,
                closable: true,
                btnCancelLabel: '取消',
                btnOKLabel: '确定',
                callback: function (result) {
                    if (result) {
                        del();
                    }
                }
            });

            function del() {

                $('#left-tree').treeview('removeNode', [node, {silent: true}]);
            }

        });
        $("#btnMove").click(function () {
            $.showMsgText('更新中...');
        });

        //获取树数据
        function getTree() {
            var tree = [
                {
                    text: "一年级",
                    id: "1",
                    nodes: [
                        {
                            text: "一班",
                            id: "2",
                            nodes: [
                                {
                                    text: "物理"
                                },
                                {
                                    text: "化学"
                                }
                            ]
                        },
                        {
                            text: "二班"
                        }
                    ]
                },
                {
                    text: "二年级"
                },
                {
                    text: "三年级"
                },
                {
                    text: "四年级"
                },
                {
                    text: "五年级"
                }
            ];
            return tree;
        }

        /*-----页面pannel内容区高度自适应 start-----*/
        $(window).resize(function () {
            setCenterHeight();
        });
        setCenterHeight();

        function setCenterHeight() {
            var height = $(window).height();
            var centerHight = height - 240;
            $(".right_centent").height(centerHight).css("overflow", "auto");
        }

        /*-----页面pannel内容区高度自适应 end-----*/
    });

</script>

<!--弹出框 新增权限 start-->
<div class="modal fade" id="addOperation-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">

        <div class="modal-content radius_5">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增</h4>
            </div>
            <div class="modal-body">
                <div group="" item="add">
                    <div>
                        <div class="input-group margin-t-5">
                            <span class="input-group-addon">名称:</span>
                            <input id="addName" type="text" class="form-control" />
                        </div>

                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button id="Save" type="button" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

            </div>
        </div>


    </div>
</div>
<!--弹出框 新增权限 end-->

</html>
