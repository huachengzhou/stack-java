<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <h4 class="text-center"><label class="label label-primary">排版</label></h4>
        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel" id="trad">

        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <div class="row">
                <div class="col-md-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testBody()">页面主体</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testMark()">内联文本</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testDel()">被删除的文本</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testIns()">插入文本</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testAlignment()">对齐</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testCapitalize()">改变大小写</button>
                </div>
            </div>
        </div>
        <div class="col-md-12 panel-body panel">
            <div class="row">
                <div class="col-md-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testBlockQuote()">引用</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testUnorderedList()">无序列表</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testOrderedList()">有序列表</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testInlineList()">内联列表</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testDescribe()">描述</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="tradObj.testAutoTruncate()">自动截断</button>
                </div>
            </div>
        </div>
        <div class="col-md-12 panel-body panel">
            <div class="col-md-1">
                <button class="btn-default btn btn-lg" onclick="tradObj.testCodeBlock()">代码块</button>
            </div>
            <div class="col-md-1 col-md-offset-1">
                <button class="btn-default btn btn-lg" onclick="tradObj.testConsole()">程序输出</button>
            </div>
            <div class="col-md-1 col-md-offset-1">
                <button class="btn-default btn btn-lg" onclick="tradObj.testUserInput()">用户输入</button>
            </div>
        </div>
    </div>


    <div class="row" style="margin-top:50px;">
        <div class="col-sm-12 col-lg-12 col-md-12">
            <div style="text-align: center;">
                <a href="${pageContext.request.contextPath}/sys/bootstrapHome" class="btn btn-primary">返回</a>
            </div>
        </div>
    </div>

</div>
</body>

<script type="text/html" id="testBody">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">页面主体</label></h4>
        </div>
        <div class="col-md-12">
            <p class="lead">
                Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo
                luctus.
            </p>
        </div>
    </div>
</script>

<script type="text/html" id="testMark">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">内联文本</label></h4>
        </div>
        <div class="col-md-12">
            You can use the mark tag to
            <mark>highlight</mark>
            text.
        </div>
    </div>
</script>

<script type="text/html" id="testDel">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">被删除的文本</label></h4>
        </div>
        <div class="col-md-12">
            <del>This line of text is meant to be treated as deleted text.</del>
        </div>
    </div>
</script>

<script type="text/html" id="testIns">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">插入文本</label></h4>
        </div>
        <div class="col-md-12">
            <ins>This line of text is meant to be treated as an addition to the document.</ins>
        </div>
    </div>
</script>

<script type="text/html" id="testAlignment">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">对齐</label></h4>
        </div>
        <div class="col-md-12">
            <p class="text-left">Left aligned text. <strong>.text-left</strong></p>
            <p class="text-center">Center aligned text. <strong>.text-center</strong></p>
            <p class="text-right">Right aligned text. <strong>.text-right</strong></p>
            <p class="text-justify">Justified text. (两端对齐)<strong>.text-justify</strong></p>
            <p class="text-nowrap">No wrap text.(不换行) <strong>.text-nowrap</strong></p>
        </div>
    </div>
</script>

<script type="text/html" id="testCapitalize">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">改变大小写</label></h4>
        </div>
        <div class="col-md-12">
            <p class="text-lowercase">Lowercased text. <strong>.text-lowercase</strong></p>
            <p class="text-uppercase">Uppercased text. <strong>.text-uppercase</strong></p>
            <p class="text-capitalize">Capitalized text.(首字母大写) <strong>.text-capitalize</strong></p>
        </div>
    </div>
</script>

<script type="text/html" id="testBlockQuote">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">引用</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
            </blockquote>
        </div>
        <div class="col-md-12">
            <blockquote>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer>
            </blockquote>
        </div>
        <div class="col-md-12">
            <blockquote class="blockquote-reverse">
                The nation will roll out measures in 2019 to boost retail sales of consumer goods, as consumption is
                predicted to play a greater role in the economy.
            </blockquote>
        </div>
    </div>
</script>
<script type="text/html" id="testUnorderedList">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">无序列表</label></h4>
        </div>
        <div class="col-md-12">
            <ul>
                <li>Lorem ipsum dolor sit amet</li>
                <li>Consectetur adipiscing elit</li>
                <li>Integer molestie lorem at massa</li>
                <li>Facilisis in pretium nisl aliquet</li>
                <li>Nulla volutpat aliquam velit
                    <ul>
                        <li>Phasellus iaculis neque</li>
                        <li>Purus sodales ultricies</li>
                        <li>Vestibulum laoreet porttitor sem</li>
                        <li>Ac tristique libero volutpat at</li>
                    </ul>
                </li>
                <li>Faucibus porta lacus fringilla vel</li>
                <li>Aenean sit amet erat nunc</li>
                <li>Eget porttitor lorem</li>
            </ul>
        </div>
    </div>
</script>
<script type="text/html" id="testOrderedList">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">有序列表</label></h4>
        </div>
        <div class="col-md-12">
            <ol>
                <li>Lorem ipsum dolor sit amet</li>
                <li>Consectetur adipiscing elit</li>
                <li>Integer molestie lorem at massa</li>
                <li>Facilisis in pretium nisl aliquet</li>
                <li>Nulla volutpat aliquam velit</li>
                <li>Faucibus porta lacus fringilla vel</li>
                <li>Aenean sit amet erat nunc</li>
                <li>Eget porttitor lorem</li>
            </ol>
        </div>
    </div>
</script>
<script type="text/html" id="testInlineList">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">内联列表</label></h4>
        </div>
        <div class="col-md-12">
            <ul class="list-inline">
                <li>Lorem ipsum</li>
                <li>Phasellus iaculis</li>
                <li>Nulla volutpat</li>
            </ul>
        </div>
    </div>
</script>
<script type="text/html" id="testDescribe">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">描述</label></h4>
        </div>
        <div class="col-md-12">
            <dl>
                <dt>Description lists</dt>
                <dd>A description list is perfect for defining terms.</dd>
                <dt>Euismod</dt>
                <dd>Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit.</dd>
                <dd>Donec id elit non mi porta gravida at eget metus.</dd>
                <dt>Malesuada porta</dt>
                <dd>Etiam porta sem malesuada magna mollis euismod.</dd>
            </dl>
        </div>
        <div class="col-md-12">
            <dl class="dl-horizontal">
                <dt>Description lists</dt>
                <dd>A description list is perfect for defining terms.</dd>
                <dt>Euismod</dt>
                <dd>Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit.</dd>
                <dd>Donec id elit non mi porta gravida at eget metus.</dd>
                <dt>Malesuada porta</dt>
                <dd>Etiam porta sem malesuada magna mollis euismod.</dd>
                <dt>Felis euismod semper eget lacinia</dt>
                <dd>Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo
                    sit amet risus.
                </dd>
            </dl>
        </div>
    </div>
</script>
<script type="text/html" id="testAutoTruncate">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">自动截断</label></h4>
        </div>
        <div class="col-md-12">
            <p class="text-left text-overflow" style="">
                通过 <code>text-overflow</code>
                属性，水平排列的描述列表将会截断左侧太长的短语。在较窄的视口（viewport）内，列表将变为默认堆叠排列的布局方式。
            </p>
        </div>
    </div>
</script>
<script type="text/html" id="testCodeBlock">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">代码块</label></h4>
        </div>
        <div class="col-md-12">
            <pre>
              public ResponseEntity&lt;byte[]&gt; createResponse(String fileName, byte[] bodys) {
                    HttpHeaders headers = new HttpHeaders();
                    ResponseEntity&lt;byte[]&gt; responseEntity = null;
                    String downloadFileName = null;
                    try {
                        downloadFileName = new String(fileName.getBytes(&quot;UTF-8&quot;), &quot;iso-8859-1&quot;);
                    } catch (UnsupportedEncodingException e) {
                        logger.error(&quot;抛出异常:&quot; + e.getMessage());
                    }
                    //解决下载显示的文件名问题
                    headers.setContentDispositionFormData(&quot;attachment&quot;, downloadFileName);
                    //二进制流数据(最常见的文件下载)
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                    responseEntity = new ResponseEntity&lt;byte[]&gt;(bodys, headers, HttpStatus.CREATED);
                    return responseEntity;
                }
            </pre>
        </div>
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">内联代码</label></h4>
        </div>
        <div class="col-md-12">
            For example, <code> var tradObj = {};</code> should be wrapped as inline.
        </div>
    </div>
</script>
<script type="text/html" id="testConsole">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">程序输出</label></h4>
        </div>
        <div class="col-md-12">
            <samp>
                [DEBUG] 2019-01-05 21:10:12,905
                method:org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.getHandlerInternal(AbstractHandlerMethodMapping.java:317)
                Returning handler method [public org.springframework.web.servlet.ModelAndView
                com.blue.spring.controller.model.BootstrapController.trad()]
                [DEBUG] 2019-01-05 21:10:12,906
                method:org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:251)
                Returning cached instance of singleton bean 'bootstrapController'
                [DEBUG] 2019-01-05 21:10:12,906
                method:org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:955)
                Last-Modified value for [/bootstrap-Install/bootstrap/trad] is: -1
                [DEBUG] 2019-01-05 21:10:12,907
                method:org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1280)
                Rendering view [org.springframework.web.servlet.view.JstlView: name 'bootstrapView/trad'; URL
                [/bootstrapView/trad.jsp]] in DispatcherServlet with name 'dispatcherServlet'
                [DEBUG] 2019-01-05 21:10:12,907
                method:org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:166)
                Forwarding to resource [/bootstrapView/trad.jsp] in InternalResourceView 'bootstrapView/trad'
                [DEBUG] 2019-01-05 21:10:13,229
                method:org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1000)
                Successfully completed request
            </samp>
        </div>
    </div>
</script>
<script type="text/html" id="testUserInput">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">用户输入</label></h4>
        </div>
        <div class="col-md-12">
            To switch directories, type <kbd>cd</kbd> followed by the name of the directory.<br>
            To edit settings, press <kbd><kbd>ctrl</kbd> + <kbd>,</kbd></kbd>
        </div>
    </div>
</script>

<script>
    var tradObj = {};

    tradObj.testBody = function () {
        $("#trad").empty();
        $("#trad").append($("#testBody").html());
    };

    tradObj.testMark = function () {
        $("#trad").empty();
        $("#trad").append($("#testMark").html());
    };

    tradObj.testDel = function () {
        $("#trad").empty();
        $("#trad").append($("#testDel").html());
    };

    tradObj.testIns = function () {
        $("#trad").empty();
        $("#trad").append($("#testIns").html());
    };

    tradObj.testAlignment = function () {
        $("#trad").empty();
        $("#trad").append($("#testAlignment").html());
    };

    tradObj.testCapitalize = function () {
        $("#trad").empty();
        $("#trad").append($("#testCapitalize").html());
    };

    tradObj.testBlockQuote = function () {
        $("#trad").empty();
        $("#trad").append($("#testBlockQuote").html());
    };

    tradObj.testUnorderedList = function () {
        $("#trad").empty();
        $("#trad").append($("#testUnorderedList").html());
    };

    tradObj.testOrderedList = function () {
        $("#trad").empty();
        $("#trad").append($("#testOrderedList").html());
    };

    tradObj.testInlineList = function () {
        $("#trad").empty();
        $("#trad").append($("#testInlineList").html());
    };

    tradObj.testDescribe = function () {
        $("#trad").empty();
        $("#trad").append($("#testDescribe").html());
    };

    tradObj.testAutoTruncate = function () {
        $("#trad").empty();
        $("#trad").append($("#testAutoTruncate").html());
    };

    tradObj.testCodeBlock = function () {
        $("#trad").empty();
        $("#trad").append($("#testCodeBlock").html());
    };


    tradObj.testConsole = function () {
        $("#trad").empty();
        $("#trad").append($("#testConsole").html());
    };

    tradObj.testUserInput = function () {
        $("#trad").empty();
        $("#trad").append($("#testUserInput").html());
    };


</script>

</html>
