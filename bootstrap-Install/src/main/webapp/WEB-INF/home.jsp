
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/nav/headA.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="container">
    <div class="row">
        <div>
            <form class="form-horizontal">

                <div class="col-sm-12">
                    <canvas id="drawing" width="300" height="300">没有金刚钻就不要揽瓷器活</canvas>
                </div>

                <div class="col-sm-12">

                </div>
            </form>
        </div>
    </div>

</div>
<script>
    function hous(x,y,r,h,context){

        var gen3=Math.sqrt(3);
        var rs=0.5*r;
        switch(h)
        {
            case 1:
                context.fillText("1",x+rs,y-rs*gen3);
                break;
            case 2:
                context.fillText("2",x+gen3*rs,y-rs);
                break;
            case 3:
                context.fillText("3",x+2*rs,y);
                break;
            case 4:
                context.fillText("4",x+gen3*rs,y+rs);
                break;
            case 5:
                context.fillText("5",x+rs,y+gen3*rs);
                break;
            case 6:
                context.fillText("6",x,y+2*rs);
                break;
            case 7:
                context.fillText("7",x-rs,y+gen3*rs);
                break;
            case 8:
                context.fillText("8",x-gen3*rs,y+rs);
                break;
            case 9:
                context.fillText("9",x-2*rs,y);
                break;
            case 10:
                context.fillText("10",x-gen3*rs,y-rs);
                break;
            case 11:
                context.fillText("11",x-rs,y-gen3*rs);
                break;
            case 12:
                context.fillText("12",x,y-2*rs);
                break;
            default:
                alert("请输入正确的时间刻度！");
        }
    }



    var drawing=document.getElementById("drawing");
    if(drawing.getContext){
        var context=drawing.getContext("2d");
        context.beginPath();
        //绘制外圆
        context.arc(100,100,99,0,2*Math.PI,false);
        //绘制内圆
        context.moveTo(194,100);
        context.arc(100,100,94,0,2*Math.PI,false);
        context.closePath();
        context.stroke();
    }

    //绘制刻度
    context.font="bold 14px Arial";
    context.textAlign="center";
    context.textBaseline="midden";
    for(var i=1;i<13;i++){
        hous(100,105,85,i,context);
    }
    context.closePath();
    context.stroke();

    var oDate = new Date(); //实例一个时间对象；
    var h=oDate.getHours(); //获取系统时，
    var m=oDate.getMinutes(); //分
    var s=oDate.getSeconds(); //秒
    m+=s/60;
    h+=m/60;

    function times(r,context,s){
        context.moveTo(100,100);
        var a=Math.PI*s/30;
        var x=r*Math.sin(a)+100;
        var y=100-r*Math.cos(a)
        context.lineTo(x,y);
    }

    function timeh(r,context,h){
        context.moveTo(100,100);
        var a=Math.PI*h/6;
        var x=r*Math.sin(a)+100;
        var y=100-r*Math.cos(a)
        context.lineTo(x,y);
    }

    function time(context,r){
        //描边路径
        context.beginPath();
        var oDate = new Date(); //实例一个时间对象；
        var h=oDate.getHours(); //获取系统时，
        var m=oDate.getMinutes(); //分
        var s=oDate.getSeconds(); //秒
        m+=s/60;
        h+=m/60;
        //绘制小圆
        context.moveTo(103,100);
        context.arc(100,100,3,0,2*Math.PI,false);
        //绘制秒针
        times(r,context,s);
        // 绘制分针
        times(r-15,context,m);
        //绘制时针
        timeh(r-30,context,h);
        context.closePath();
        context.stroke();

    }

    var r=94/Math.sqrt(2)-1;
    setInterval(function(){
        context.clearRect(100-r,100-r,2*r,2*r);
        time(context,r-1);
    },16.7);
</script>
</body>
</html>
