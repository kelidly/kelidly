﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>


<!doctype html>
<html>
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>demo</title>
    <script type="text/javascript" src="<%=basePath %>/common/js/imgReview/jquery.imgreview.min.js"></script>
  
 <script type="text/javascript" src="<%=basePath %>/common/js/jquery-1.8.0.js"></script> 

    <script type="text/javascript">
        function jcrop() {
            var jcrop_api;
            $('#uploadReview8Content').Jcrop({
                onChange: showCoords,
                onSelect: showCoords,
                onRelease: clearCoords
            }, function () {
                jcrop_api = this;
            });
            $('#coords').on('change', 'input', function (e) {
                var x1 = $('#x1').val(),
                    x2 = $('#x2').val(),
                    y1 = $('#y1').val(),
                    y2 = $('#y2').val();
                jcrop_api.setSelect([x1, y1, x2, y2]);
            });
        }
        function showCoords(c) {
            $('#x1').val(c.x);
            $('#y1').val(c.y);
            $('#x2').val(c.x2);
            $('#y2').val(c.y2);
            $('#w').val(c.w);
            $('#h').val(c.h);
        };
        function clearCoords() {
            $('#coords input').val('');
        };
    </script>
    <script>
        $(function () {
            //简单调用
            $('#uploadReview1').uploadReview({
                width: 300,
                height: 300
            });

            //在指定的容器中预览
            $('#uploadReview2').uploadReview({
                width: 300,
                height: 300,
                target: '#uploadReview2_content'//也可在元素中添加此属性
            });

            //指定样式
            $('#uploadReview3').uploadReview({
                className: 'uploadReview3_class'
            });

            //限制预览的类型
            $('#uploadReview4').uploadReview({
                ext: '.jpg|.jpeg|.png'
            });

            //选择改变后的事件： onChange
            $('#uploadReview5').uploadReview({
                onChange: function (file) {
                    var fileName = file.val();
                    alert('选择了文件：' + fileName);
                }
            });

            //设置预览模板
            $('#uploadReview6,#uploadReview7').uploadReview({
                template: $('#reviewTemplate').html()
            });

            //与 Jcrop 集成
            $('#uploadReview8').uploadReview({
                target: '#uploadReview8Content',
                width: 400,
                height: 300,
                onChange: function (file) {
                    var hasValue = $('#uploadReview8Content').children().size();
                    if (hasValue > 0) {
                        jcrop();
                    }
                }
            });

        });
    </script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .demo {
            border: 1px solid #ddd;
            padding: 5px 0 10px 20px;
            margin: 10px;
            position: relative;
        }

        h3 {
            margin-bottom: 10px;
        }

        .content2 {
            border: 1px solid #a7be49;
            padding: 10px;
            width: 400px;
            height: 350px;
            margin-right: 30px;
            position: relative;
            top: -20px;
            left: 400px;
        }

        .clear {
            clear: both;
        }

        .uploadReview3_class {
            border: 1px solid #858181;
            padding: 10px;
            background: #eda6a6;
        }

        .reviewTemplate {
            padding: 10px;
            border: dashed 1px #1546e8;
            width: 350px;
            margin-left: 10px;
            display: inline-block;
            text-align: center;
        }

        #uploadReview8Content {
            border: 1px solid #1546e8;
            width: 400px;
            height: 300px;
        }
    </style>
</head>
<body>
    <!-- 简单调用 -->
    <div class="demo">
        <h3>简单调用</h3>
        <input id="uploadReview1" type="file" />
    </div>

    <!-- 在指定的容器中预览 -->
    <div class="demo">
        <h3>在指定的容器中预览</h3>
        <input id="uploadReview2" type="file" />
        <div class="content2">
            <h3 style="text-align: center;">在这里预览</h3>
            <div style="border: 1px solid #dd9f9f; padding: 10px;" id="uploadReview2_content"></div>
        </div>
        <div class="clear"></div>
    </div>

    <!-- 指定样式 -->
    <div class="demo">
        <h3>指定样式</h3>
        <input id="uploadReview3" type="file" />
    </div>

    <!-- 限制预览的图片类型(.jpg|.jpeg|.png) -->
    <div class="demo">
        <h3>限制预览的图片类型(.jpg|.jpeg|.png)</h3>
        <input id="uploadReview4" type="file" />
    </div>

    <!-- 选择改变后的事件处理： onChange -->
    <div class="demo">
        <h3>选择改变后的事件处理： onChange</h3>
        <input id="uploadReview5" type="file" />
    </div>

    <!-- 设置预览模板 -->
    <div>
        <div class="demo">
            <h3>设置预览模板</h3>
            <input id="uploadReview6" target="#uploadReview6Content" type="file" />
            <input id="uploadReview7" target="#uploadReview6Content" type="file" />
            <div class="content3">
                <h3 style="text-align: center;">在这里预览</h3>
                <div style="border: 1px solid #dd9f9f; padding: 10px;" id="uploadReview6Content"></div>
            </div>
        </div>

        <div id="reviewTemplate" style="display: none;">
            <div class="reviewTemplate">
                <h3>这是一个模板预览</h3>
                <div tag="reviewContent" title="预览容器，预览图片将在此显示"></div>
            </div>
        </div>
    </div>


    <!-- 与 Jcrop 集成 -->
    <div class="demo">
        <h3>与 Jcrop 集成</h3>
        <input id="uploadReview8" type="file" />
        <div id="uploadReview8Content"></div>
        <div class="inline-labels">
            <label>X1<input type="text" size="4" id="x1" name="x1" /></label>
            <label>Y1<input type="text" size="4" id="y1" name="y1" /></label>
            <label>X2<input type="text" size="4" id="x2" name="x2" /></label>
            <label>Y2<input type="text" size="4" id="y2" name="y2" /></label>
            <label>W<input type="text" size="4" id="w" name="w" /></label>
            <label>H<input type="text" size="4" id="h" name="h" /></label>
        </div>
        <h3>注：</h3>
        <p style="color: red;">
            关于 Jcrop 的使用方法，请参考有关 Jcrop 的相关资料
            <a target="_blank" href="http://deepliquid.com/content/Jcrop.html">Jcrop Home</a>
        </p>
    </div>

    <br />
    <br />
    <br />
    <br />
</body>
</html>
