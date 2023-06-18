(function ($) {
    //表单自动赋值
    $.fn.extend({
        initForm: function (options) {
            //默认参数
            var defaults = {
                formdata: "",
                isDebug: false   //是否需要调试，这个用于开发阶段，发布阶段请将设置为false，默认为false,true将会把name value打印出来
            }
            //如果传入的json字符串，将转为json对象
            var tempData = "";
            if ($.type(options) === "string") {
                defaults.formdata = JSON.parse(options);
            } else {
                defaults.formdata = options;
            }
            //设置参数
            // var setting = $.extend({}, defaults, tempData);
            var setting = defaults;
            var form = this;
            formdata = setting.formdata;

            //如果传入的json对象为空，则不做任何操作
            if (!$.isEmptyObject(formdata)) {
                var debugInfo = "";
                $.each(formdata, function (key, value) {
                    //是否开启调试，开启将会把name value打印出来
                    if (setting.isDebug) {
                        debugInfo += "name:" + key + "; value:" + value + "\r\n ";
                    }
                    //表单处理
                    var formField = form.find("[name='" + key + "']");
                    if ($.type(formField[0]) === "undefined") {
                        if (setting.isDebug) {
                            console.warn("can not find name:[" + key + "] in form!!!"); //没找到指定name的表单
                        }
                    } else {
                        var fieldTagName = formField[0].tagName.toLowerCase();
                        if (fieldTagName == "input") {
                            if (formField.attr("type") == "radio") {
                                $("input:radio[name='" + key + "'][value='" + value + "']").attr("checked", "checked");
                            } else if (formField.attr("type") == "checkbox") {
                                $("input:checkbox[name='" + key + "'][value='" + value + "']").prop("checked", true);
                            } else {
                                formField.val(value);
                            }
                        } else if (fieldTagName == "label" || fieldTagName == "a") {
                            formField.html(value);
                        } else {
                            formField.val(value);
                        }
                    }
                    //图片链接处理form.find("img[fieldata=img_url]")
                    var formImage = form.find("img[fieldata=" + key + "]");
                    if ($.type(formImage[0]) != "undefined") {
                        formImage.attr("src", value);
                    }
                    //a链接处理
                    var formLink = form.find("a[fieldata=" + key + "]");
                    if ($.type(formLink[0]) != "undefined") {
                        formLink.attr("href", value);
                    }
                })
                if (setting.isDebug) {
                    console.log(debugInfo);
                }
            }
            return form;    //返回对象，提供链式操作
        }
    });

    var zchCommon = {
        //判断是否为图片(图像)
        checkImgFile: function (filename) {
            var flag = false; //状态
            //常用图片后缀
            var arr = ["bmp", "dib", "rle", "emf", "gif", "jpg", "jpeg", "jpe", "jif", "pcx", "dcx", "pic", "png", "tga", "tif", "tiffxif", "wmf", "jfif"];
            if (filename) {
                //取出上传文件的扩展名
                var index = filename.lastIndexOf(".");
                var ext = filename.substr(index + 1);
                //转换为小写比较
                ext = ext.toLocaleLowerCase();
                //循环比较
                for (var i = 0; i < arr.length; i++) {
                    if (ext == arr[i]) {
                        flag = true; //一旦找到合适的，立即退出循环
                        break;
                    }
                }
            }
            return flag;
        },
        /**
         * 根据省份名称返回省份简称
         * @param province
         * @returns {String}
         */
        provinceForShort: function (province) {
            if (province == "北京")
                return "京";
            else if (province == "天津")
                return "津";
            else if (province == "重庆")
                return "渝";
            else if (province == "上海")
                return "沪";
            else if (province == "河北")
                return "冀";
            else if (province == "山西")
                return "晋";
            else if (province == "辽宁")
                return "辽";
            else if (province == "吉林")
                return "吉";
            else if (province == "黑龙江")
                return "黑";
            else if (province == "江苏")
                return "苏";
            else if (province == "浙江")
                return "浙";
            else if (province == "安徽")
                return "皖";
            else if (province == "福建")
                return "闽";
            else if (province == "江西")
                return "赣";
            else if (province == "山东")
                return "鲁";
            else if (province == "河南")
                return "豫";
            else if (province == "湖北")
                return "鄂";
            else if (province == "湖南")
                return "湘";
            else if (province == "广东")
                return "粤";
            else if (province == "海南")
                return "琼";
            else if (province == "四川")
                return "川";
            else if (province == "贵州")
                return "黔";
            else if (province == "云南")
                return "云";
            else if (province == "陕西")
                return "陕";
            else if (province == "甘肃")
                return "甘";
            else if (province == "青海")
                return "青";
            else if (province == "台湾")
                return "台";
            else if (province == "内蒙古")
                return "内";
            else if (province == "广西")
                return "桂";
            else if (province == "宁夏")
                return "宁";
            else if (province == "新疆")
                return "新";
            else if (province == "西藏")
                return "藏";
            else if (province == "香港")
                return "港";
            else if (province == "澳门")
                return "澳";
            else
                return "";
        }
    } ;


    window.zchCommon = zchCommon;
})(jQuery);


//表单查询参数
function formParams(formId) {
    return formSerializeArray($("#" + formId));
}

function formSerializeArray(obj) {
    var ret = {};
    var queryParams = obj.serializeArray();
    $.each(queryParams, function (i, field) {
        if (field.value != undefined) {
            if (ret[field.name] != undefined && ret[field.name] != '') {
                ret[field.name] = ret[field.name] + "," + field.value;
            } else {
                ret[field.name] = field.value;
            }
        }
    });
    return ret;
}


//向form表单中添加参数
function formAddParam(formId, params) {
    var form = $("#" + formId);
    if (form && params) {
        form.empty();
        $.each(params, function (name, value) {
            var item = "<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\" />";
            form.append(item);
        })
    }
}

//日期格式化
function formatDate(v, isfull) {
    if (!v) {
        return "";
    }
    if (/^(-)?\d{1,10}$/.test(v)) {
        v = v * 1000;
    } else if (/^(-)?\d{1,13}$/.test(v)) {
        v = v * 1;
    }
    var dateObj = new Date(v);
    var month = dateObj.getMonth() + 1;
    var day = dateObj.getDate();
    var hours = dateObj.getHours();
    var minutes = dateObj.getMinutes();
    var seconds = dateObj.getSeconds();
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    if (hours < 10) {
        hours = "0" + hours;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (seconds < 10) {
        seconds = "0" + seconds;
    }
    var UnixTimeToDate = dateObj.getFullYear() + '-' + month + '-' + day;
    if (isfull) {
        UnixTimeToDate += ' ' + hours + ':' + minutes;
        UnixTimeToDate += ':' + seconds;
    }
    return UnixTimeToDate;
}

//时间格式化
function formatTime(v) {
    if (!v) {
        return "";
    }
    if (/^(-)?\d{1,10}$/.test(v)) {
        v = v * 1000;
    } else if (/^(-)?\d{1,13}$/.test(v)) {
        v = v * 1;
    }
    var dateObj = new Date(v);
    var hours = dateObj.getHours();
    var minutes = dateObj.getMinutes();
    if (hours < 10) {
        hours = "0" + hours;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    return hours + ':' + minutes + " ";
}

//获取参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}
//获取url后缀
function getSearch() {
    var index = window.location.href.indexOf("?");
    return window.location.href.substring(index + 1);
}

/**
 * 去除字符
 * @param str
 * @param item
 */
function trimChar(str, item) {
    if (!item) item = " ";
    var reStart = new RegExp("^" + item + "+");
    var reEnd = new RegExp(item + "+$");
    return str.replace(reStart, "").replace(reEnd, "");
}


/*
 * 功能：对JSON对象字符串数组进行多字段（多列）排序
 * 参数：
 *   objArr: 目标数组
 *   keyArr: 排序字段，以数组形式传递
 *   type：排序方式，undefined以及asc都是按照升序排序，desc按照降序排序
 * */
function sortObjectArray(objArr, keyArr, type) {
    if (type != undefined && type != 'asc' && type != 'desc') {
        return 'error';
    }
    var order = 1;
    if (type != undefined && type == 'desc') {
        order = -1;
    }
    var key = keyArr[0];
    objArr.sort(function (objA, objB) {
        if (objA[key] > objB[key]) {
            return order;
        } else if (objA[key] < objB[key]) {
            return 0 - order;
        } else {
            return 0;
        }
    })
    for (var i = 1; i < keyArr.length; i++) {
        var key = keyArr[i];
        objArr.sort(function (objA, objB) {
            for (var j = 0; j < i; j++) {
                if (objA[keyArr[j]] != objB[keyArr[j]]) {
                    return 0;
                }
            }
            if (objA[key] > objB[key]) {
                return order;
            } else if (objA[key] < objB[key]) {
                return 0 - order;
            } else {
                return 0;
            }
        })
    }
    return objArr;
}

/**
 * 格式化下划线
 * @param key
 * @param value
 */
function formatToUnderline(var1, var2, separator) {
    if (!var1) return "";
    if (!separator) {
        separator = ',';
    }
    var keyArray = var1.split(separator);
    if (var2) {
        var valueArray = var2.split(separator);
    }
    var resultStr = '';
    $.each(keyArray, function (i, item) {
        resultStr += item + '_' + valueArray[i] + ',';
    });
    return resultStr.replace(/,$/, '');
}

$(document).ready(function () {


    $(".form_datetime").datetimepicker({format: 'yyyy-mm-dd', language: 'zh-CN'});

    try {
        $(".select2").each(function () {
            $(this).select2({minimumResultsForSearch: -1});
        })
    } catch (e) {
    }


});
