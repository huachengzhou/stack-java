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
            <h4 class="text-center"><label class="label label-primary">表单</label></h4>
        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel" id="methodObj">

        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <div class="row">
                <div class="col-md-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testBaseExample()">基本实例</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testFormInline()">内联表单</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testFormHorizontal()">水平排列的表单</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testFormControl()">控件</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testFormStaticControl()">静态控件</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testVerifyStatus()">校验状态</button>
                </div>
            </div>
        </div>
    </div>

    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12 panel-body panel">
            <div class="row">
                <div class="col-md-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testIcon()">添加额外的图标</button>
                </div>
                <div class="col-md-1 col-md-offset-1">
                    <button class="btn-default btn btn-lg" onclick="methodObj.testFormControlSize()">控件尺寸</button>
                </div>
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

<script type="text/html" id="testBaseExample">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">基本实例</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                单独的表单控件会被自动赋予一些全局样式。所有设置了 .form-control 类的 &lt;input&gt;、&lt;textarea&gt; 和 &lt;select&gt;
                元素都将被默认设置宽度属性为 width: 100%;。 将 label 元素和前面提到的控件包裹在 .form-group 中可以获得最好的排列。
            </blockquote>
        </div>
        <div class="col-md-12">
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <input type="file" id="exampleInputFile">
                    <p class="help-block">Example block-level help text here.</p>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Check me out
                    </label>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</script>

<script type="text/html" id="testFormInline">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">内联表单</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                <p>
                    为 &lt;form&gt; 元素添加 .form-inline 类可使其内容左对齐并且表现为 inline-block 级别的控件。只适用于视口（viewport）至少在 768px
                    宽度时（视口宽度再小的话就会使表单折叠）。
                </p>
                <p>
                    一定要添加 label 标签
                    如果你没有为每个输入控件设置 label 标签，屏幕阅读器将无法正确识别。对于这些内联表单，你可以通过为 label 设置 .sr-only
                    类将其隐藏。还有一些辅助技术提供label标签的替代方案，比如 aria-label、aria-labelledby 或 title 属性。如果这些都不存在，屏幕阅读器可能会采取使用
                    placeholder 属性，如果存在的话，使用占位符来替代其他的标记，但要注意，这种方法是不妥当的。
                </p>
            </blockquote>
        </div>
        <div class="col-md-12">
            <form class="form-inline">
                <div class="form-group">
                    <label for="exampleInputName2">Name</label>
                    <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail2">Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
                </div>
                <button type="submit" class="btn btn-default">Send invitation</button>
            </form>
        </div>
    </div>
</script>

<script type="text/html" id="testFormHorizontal">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">水平排列的表单</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                <dl>
                    通过为表单添加
                    <dt>.form-horizontal</dt>
                    类，并联合使用 Bootstrap 预置的栅格类，可以将 label 标签和控件组水平并排布局。这样做将改变
                    <dt>.form-group</dt>
                    的行为，使其表现为栅格系统中的行（row），因此就无需再额外添加
                    <dt>.row</dt>
                    了。
                </dl>
            </blockquote>
        </div>
        <div class="col-md-12">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Remember me
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</script>

<script type="text/html" id="testFormControl">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">输入框</label></h4>
        </div>
        <div class="col-md-12">
            <dl>
                包括大部分表单控件、文本输入域控件，还支持所有 HTML5 类型的输入控件：
                text、password、datetime、datetime-local、date、month、time、week、number、email、url、search、tel 和 color。
            </dl>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-4">
                    <blockquote>
                        <dl>
                            必须添加类型声明
                            只有正确设置了 type 属性的输入控件才能被赋予正确的样式。
                        </dl>
                    </blockquote>
                </div>
                <div class="col-md-8">
                    <input type="text" class="form-control" placeholder="Text input">
                </div>
                <div class="col-md-12">
                    <blockquote>
                        <div class="bs-callout bs-callout-info">
                            <h4>输入控件组</h4>
                            <p>如需在文本输入域 <code>&lt;input&gt;</code> 前面或后面添加文本内容或按钮控件，请参考<a
                                    href="https://v3.bootcss.com/components/#input-groups">输入控件组</a>。</p>
                        </div>
                    </blockquote>
                </div>
                <div class="col-md-4">
                    <blockquote>
                        <dl>
                            <dt>文本域</dt>
                            支持多行文本的表单控件。可根据需要改变 rows 属性。
                        </dl>
                    </blockquote>
                </div>
                <div class="col-md-8">
                    <textarea class="form-control" rows="3"></textarea>
                </div>
                <div class="col-md-12">
                    <blockquote>
                        <dl>
                            <dt>多选和单选框</dt>
                            多选框（checkbox）用于选择列表中的一个或多个选项，而单选框（radio）用于从多个选项中只选择一个。

                            Disabled checkboxes and radios are supported, but to provide a &quot;not-allowed&quot;
                            cursor on hover
                            of the parent &lt;label&gt;, you&#x27;ll need to add the .disabled class to the parent
                            <code>.radio</code>,
                            <code>.radio-inline</code>,
                            <code>.checkbox</code>, or
                            <code>.checkbox-inline</code>,
                        </dl>
                    </blockquote>
                </div>
                <div class="col-md-12">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="">
                            Option one is this and that&mdash;be sure to include why it's great
                        </label>
                    </div>
                    <div class="checkbox disabled">
                        <label>
                            <input type="checkbox" value="" disabled>
                            Option two is disabled
                        </label>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" value="option1" checked>
                            Option one is this and that&mdash;be sure to include why it's great
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" value="option2">
                            Option two can be something else and selecting it will deselect option one
                        </label>
                    </div>
                    <div class="radio disabled">
                        <label>
                            <input type="radio" name="optionsRadios" value="option3" disabled>
                            Option three is disabled
                        </label>
                    </div>
                </div>
                <div class="col-md-4">
                    <blockquote>
                        <dl>
                            <dt>内联单选和多选框</dt>
                            通过将 <code>.checkbox-inline</code> 或 <code>.radio-inline</code>
                            类应用到一系列的多选框（checkbox）或单选框（radio）控件上，可以使这些控件排列在一行。
                        </dl>
                    </blockquote>
                </div>
                <div class="col-md-8">
                    <label class="checkbox-inline">
                        <input type="checkbox" value="option1"> 1
                    </label>
                    <label class="checkbox-inline">
                        <input type="checkbox" value="option2"> 2
                    </label>
                    <label class="checkbox-inline">
                        <input type="checkbox" value="option3"> 3
                    </label>

                    <label class="radio-inline">
                        <input type="radio" name="inlineRadioOptions" value="option1"> 1
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="inlineRadioOptions" value="option2"> 2
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="inlineRadioOptions" value="option3"> 3
                    </label>
                </div>
                <div class="col-md-4">
                    <blockquote>
                        <dl>
                            <dt>下拉列表（select）</dt>
                            注意，很多原生选择菜单 - 即在 Safari 和 Chrome 中 - 的圆角是无法通过修改 border-radius 属性来改变的。
                        </dl>
                    </blockquote>
                </div>
                <div class="col-md-12">
                    <select class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <blockquote>
                        对于标记了 multiple 属性的 &lt;select&gt; 控件来说，默认显示多选项。
                    </blockquote>
                </div>
                <div class="col-md-12">
                    <select multiple class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testFormStaticControl">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">静态控件</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                如果需要在表单中将一行纯文本和 label 元素放置于同一行，为 &lt;p&gt; 元素添加 .form-control-static 类即可。
            </blockquote>
        </div>
        <div class="col-md-12">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">email@example.com</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                    </div>
                </div>
            </form>
        </div>
    </div>
</script>
<script type="text/html" id="testVerifyStatus">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">校验状态</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                Bootstrap 对表单控件的校验状态，如 error、warning 和 success 状态，都定义了样式。使用时，添加 <code>.has-warning </code>
                、<code>.has-error</code> 或 <code>.has-success</code>
                类到这些控件的父元素即可。任何包含在此元素之内的
                <code>.control-label</code>
                、<code>.form-control</code> 和 <code>.help-block</code> 元素都将接受这些校验状态的样式。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="form-group has-success">
                <label class="control-label" for="inputSuccess1">Input with success</label>
                <input type="text" class="form-control" id="inputSuccess1" aria-describedby="helpBlock2">
                <span id="helpBlock2" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
            </div>
            <div class="form-group has-warning">
                <label class="control-label" for="inputWarning1">Input with warning</label>
                <input type="text" class="form-control" id="inputWarning1">
            </div>
            <div class="form-group has-error">
                <label class="control-label" for="inputError1">Input with error</label>
                <input type="text" class="form-control" id="inputError1">
            </div>
            <div class="has-success">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="checkboxSuccess" value="option1">
                        Checkbox with success
                    </label>
                </div>
            </div>
            <div class="has-warning">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="checkboxWarning" value="option1">
                        Checkbox with warning
                    </label>
                </div>
            </div>
            <div class="has-error">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="checkboxError" value="option1">
                        Checkbox with error
                    </label>
                </div>
            </div>
        </div>
    </div>
</script>

<script type="text/html" id="testIcon">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">添加额外的图标</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                你还可以针对校验状态为输入框添加额外的图标。只需设置相应的 <code>.has-feedback</code> 类并添加正确的图标即可。
                反馈图标（feedback icon）只能使用在文本输入框 &lt;input class=&quot;form-control&quot;&gt; 元素上。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="form-group has-success has-feedback">
                <label class="control-label" for="inputSuccess2">Input with success</label>
                <input type="text" class="form-control" id="inputSuccess2" aria-describedby="inputSuccess2Status">
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                <span id="inputSuccess2Status" class="sr-only">(success)</span>
            </div>
            <div class="form-group has-warning has-feedback">
                <label class="control-label" for="inputWarning2">Input with warning</label>
                <input type="text" class="form-control" id="inputWarning2" aria-describedby="inputWarning2Status">
                <span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
                <span id="inputWarning2Status" class="sr-only">(warning)</span>
            </div>
            <div class="form-group has-error has-feedback">
                <label class="control-label" for="inputError2">Input with error</label>
                <input type="text" class="form-control" id="inputError2" aria-describedby="inputError2Status">
                <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
                <span id="inputError2Status" class="sr-only">(error)</span>
            </div>
            <div class="form-group has-success has-feedback">
                <label class="control-label" for="inputGroupSuccess1">Input group with success</label>
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <input type="text" class="form-control" id="inputGroupSuccess1"
                           aria-describedby="inputGroupSuccess1Status">
                </div>
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
            </div>
        </div>
        <div class="col-md-12">
            <form class="form-horizontal">
                <div class="form-group has-success has-feedback">
                    <label class="control-label col-sm-3" for="inputSuccess3">Input with success</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="inputSuccess3"
                               aria-describedby="inputSuccess3Status">
                        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                        <span id="inputSuccess3Status" class="sr-only">(success)</span>
                    </div>
                </div>
                <div class="form-group has-success has-feedback">
                    <label class="control-label col-sm-3" for="inputGroupSuccess2">Input group with success</label>
                    <div class="col-sm-9">
                        <div class="input-group">
                            <span class="input-group-addon">@</span>
                            <input type="text" class="form-control" id="inputGroupSuccess2"
                                   aria-describedby="inputGroupSuccess2Status">
                        </div>
                        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                        <span id="inputGroupSuccess2Status" class="sr-only">(success)</span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-12">
            <form class="form-inline">
                <div class="form-group has-success has-feedback">
                    <label class="control-label" for="inputSuccess4">Input with success</label>
                    <input type="text" class="form-control" id="inputSuccess4" aria-describedby="inputSuccess4Status">
                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                    <span id="inputSuccess4Status" class="sr-only">(success)</span>
                </div>
            </form>
            <form class="form-inline">
                <div class="form-group has-success has-feedback">
                    <label class="control-label" for="inputGroupSuccess3">Input group with success</label>
                    <div class="input-group">
                        <span class="input-group-addon">@</span>
                        <input type="text" class="form-control" id="inputGroupSuccess3"
                               aria-describedby="inputGroupSuccess3Status">
                    </div>
                    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                    <span id="inputGroupSuccess3Status" class="sr-only">(success)</span>
                </div>
            </form>
        </div>
    </div>
</script>

<script type="text/html" id="testFormControlSize">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center"><label class="label label-primary">控件尺寸</label></h4>
        </div>
        <div class="col-md-12">
            <blockquote>
                通过 <code>.input-lg</code> 类似的类可以为控件设置高度，通过 <code>.col-lg-*</code> 类似的类可以为控件设置宽度。
            </blockquote>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="text-center"><label class="label label-primary">高度尺寸</label></h4>
                </div>
                <div class="col-md-12">
                    <blockquote>
                        创建大一些或小一些的表单控件以匹配按钮尺寸。
                    </blockquote>
                </div>
                <div class="col-md-12">
                    <input class="form-control input-lg" type="text" placeholder=".input-lg">
                    <input class="form-control" type="text" placeholder="Default input">
                    <input class="form-control input-sm" type="text" placeholder=".input-sm">

                    <select class="form-control input-lg">...</select>
                    <select class="form-control">...</select>
                    <select class="form-control input-sm">...</select>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="text-center"><label class="label label-primary">水平排列的表单组的尺寸</label></h4>
                </div>
                <div class="col-md-12">
                    <blockquote>
                        通过添加 <code>.form-group-lg</code> 或 <code>.form-group-sm</code> 类，为 <code>.form-horizontal</code> 包裹的 label 元素和表单控件快速设置尺寸。
                    </blockquote>
                </div>
                <div class="col-md-12">
                    <form class="form-horizontal">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label" for="formGroupInputLarge">Large label</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="formGroupInputLarge" placeholder="Large input">
                            </div>
                        </div>
                        <div class="form-group form-group-sm">
                            <label class="col-sm-2 control-label" for="formGroupInputSmall">Small label</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" id="formGroupInputSmall" placeholder="Small input">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="text-center"><label class="label label-primary">调整列（column）尺寸</label></h4>
                </div>
                <div class="col-md-12">
                    <blockquote>
                        用栅格系统中的列（column）包裹输入框或其任何父元素，都可很容易的为其设置宽度。
                    </blockquote>
                </div>
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-xs-2">
                            <input type="text" class="form-control" placeholder=".col-xs-2">
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" placeholder=".col-xs-3">
                        </div>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" placeholder=".col-xs-4">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</script>

<script>

    var methodObj = {};

    methodObj.testBaseExample = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testBaseExample").html());
    };

    methodObj.testFormInline = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testFormInline").html());
    };

    methodObj.testFormHorizontal = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testFormHorizontal").html());
    };

    methodObj.testFormControl = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testFormControl").html());
    };

    methodObj.testFormStaticControl = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testFormStaticControl").html());
    };

    methodObj.testVerifyStatus = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testVerifyStatus").html());
    };

    methodObj.testIcon = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testIcon").html());
    };

    methodObj.testFormControlSize = function () {
        $("#methodObj").empty();
        $("#methodObj").append($("#testFormControlSize").html());
    };


</script>

</html>
