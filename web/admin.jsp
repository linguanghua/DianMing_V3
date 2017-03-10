<%--
 Created by IntelliJ IDEA.
 User: Administrator
 Date: 2016/12/2
 Time: 21:32
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>

    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="UTF-8">
    <title>管理首页</title>

    <style type="text/css">
        @font-face {
            font-family: 'Material Icons';
            font-style: normal;
            font-weight: 400;
            src: url(materialize/iconfont/MaterialIcons-Regular.eot); /* For IE6-8 */
            src: local('Material Icons'), local('MaterialIcons-Regular'), url(materialize/iconfont/MaterialIcons-Regular.woff2) format('woff2'), url(materialize/iconfont/MaterialIcons-Regular.woff) format('woff'), url(materialize/iconfont/MaterialIcons-Regular.ttf) format('truetype');
        }

        .material-icons {
            font-family: 'Material Icons';
            font-weight: normal;
            font-style: normal;
            font-size: 24px; /* Preferred icon size */
            display: inline-block;
            width: 1em;
            height: 1em;
            line-height: 1;
            text-transform: none;
            letter-spacing: normal;
            word-wrap: normal;
            white-space: nowrap;
            direction: ltr;
            /* Support for all WebKit browsers. */
            -webkit-font-smoothing: antialiased;
            /* Support for Safari and Chrome. */
            text-rendering: optimizeLegibility;
            /* Support for Firefox. */
            -moz-osx-font-smoothing: grayscale;
            /* Support for IE. */
            font-feature-settings: 'liga';
        }

        .userView {
            position: relative;
            padding: 32px 32px 0;
            margin-bottom: 8px
        }

        .userView > a {
            height: auto;
            padding: 0
        }

        .userView > a:hover {
            background-color: transparent
        }

        .userView .background {
            overflow: hidden;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            z-index: -1
        }

        .userView .circle, .userView .name, .userView .email {
            display: block
        }

        .userView .circle {
            height: 64px;
            width: 64px
        }

        .userView .name, .userView .email {
            font-size: 14px;
            line-height: 24px
        }

        .userView .name {
            margin-top: 16px;
            font-weight: 500
        }

        .userView .email {
            padding-bottom: 16px;
            font-weight: 400
        }

        th, td {
            text-align: center;
        }

        header, main, footer {
            padding-left: 300px;
        }

        @media only screen and (max-width: 992px) {
            header, main, footer {
                padding-left: 0;
            }
        }

        .fixed > li:first-child {
            background: url("images/office.jpg") no-repeat;
        }


    </style>
</head>

<body>
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="materialize/js/jquery-3.1.1.js.js"></script>
<script type="text/javascript" src="materialize/js/materialize.min.js"></script>
<header>
    <div class="container"><a href="#" data-activates="nav-mobile"
                              class="button-collapse top-nav full hide-on-large-only"><i class="material-icons">menu</i></a>
    </div>
    <ul id="nav-mobile" class="side-nav fixed">
        <li>
            <div class="userView">
                <a href="#!user"><img class="circle" src="images/yuna.jpg"></a>
                <a href="#!name"><span class="white-text name">${user.name}</span></a>
                <a href="#!email"><span class="white-text email" id="user">${user.username}</span></a>
            </div>
        </li>
        <li class="bold"><a id="myClass" href="#" class="waves-effect waves-teal"><i class="material-icons">info</i>课程管理</a>
        </li>
        <li class="bold"><a id="signInfo" href="#" class="waves-effect waves-teal"><i
                class="material-icons">mode_edit</i>添加课程</a></li>
        <li class="bold"><a href="#modal1" class="waves-effect waves-teal modal-trigger"><i class="material-icons">settings_applications</i>修改密码</a>
        </li>
        <li class="bold"><a href="logout?action=logout" class="waves-effect waves-teal"><i class="material-icons">power_settings_new</i>退出</a>
        </li>
    </ul>
</header>
<main>

    <div id="myClassDiv" class="row" style="width: 95%;">
        <div class="section scrollspy">
            <h3 class="header">课程管理</h3>
            <a class="waves-effect waves-light btn" id="addClass">添加课程</a>

            <div class='row'>
                <div class='col s12'>
                    <table class='bordered' id='t_signInfo'>
                        <thead>
                        <tr>
                            <th data-field='id'>课程号</th>
                            <th data-field='id'>课程名称</th>
                            <th data-field='id'>星期</th>
                            <th data-field='name'>节号</th>
                            <th data-field='price'>教室</th>
                            <th data-field='price'>详细信息</th>
                            <th data-field='price' colspan='2'>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="#session.allClass" id="item">
                            <tr>
                                <td><s:property value="#item.classId" /></td>
                                <td><s:property value="#item.className" /></td>
                                <td><s:property value="#item.week" /></td>
                                <td><s:property value="#item.lesson" /></td>
                                <td><s:property value="#item.classRoom" /></td>
                                <td><a class='waves-effect waves-light btn check'>查看</a></td>
                                <td style='width:12%'><a class='waves-effect waves-light btn edit'>编辑</a></td>
                                <td style='width:12%'><a class='waves-effect waves-light btn del'>删除</a></td>
                            </tr>
                            </s:iterator>

                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>

    <div class="row" style="width: 80%;display: none" id="signInfoDiv">
        <div id="class" class="section scrollspy">
            <h3 class="header">添加课程</h3>
            <div class="row">
                <form class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="classId" type="text" class="validate">
                            <label for="classId">课程号</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="className" type="text" class="validate">
                            <label for="className">课程名称</label>
                        </div>
                    </div>
                    <div class="row">
                        <!-- Dropdown Trigger -->
                        <a id="week" class='dropdown-button btn' href='#' data-activates='dropdown1'>星期</a>
                        <!-- Dropdown Structure -->
                        <ul id='dropdown1' class='dropdown-content'>
                            <li><a href="#!">星期一</a></li>
                            <li><a href="#!">星期二</a></li>
                            <li><a href="#!">星期三</a></li>
                            <li><a href="#!">星期四</a></li>
                            <li><a href="#!">星期五</a></li>
                        </ul>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="classRoom" type="text" class="validate">
                            <label for="classRoom">教室</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="lesson" type="text" class="validate">
                            <label for="lesson">第几节(数字1-7)</label>
                        </div>
                    </div>

                </form>
                <div class="row" style="float: right">
                    <button class="btn waves-effect waves-light" id="addClassBtn">确定</button>
                </div>
            </div>
        </div>
    </div>

    <div class="row" style="width: 80%;display: none" id="studentsInfoDiv">
        <div id="students" class="section scrollspy">
            <h3 class="header">课程信息</h3>
            <div class="row">
                <div class="col s12">
                    <table class='bordered'>
                        <thead>
                        <tr>
                            <th data-field="id">编号</th>
                            <th data-field="name">学号</th>
                            <th data-field="price">姓名</th>
                        </tr>
                        </thead>

                        <tbody>

                        </tbody>

                    </table>
                </div>

            </div>
        </div>
    </div>


    <!-- Modal Structure -->
    <div id="modal1" class="modal">
        <div class="modal-content">
            <h4>修改密码</h4>
            <div class="row">
                <form class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="nPsw" type="password" class="validate">
                            <label for="nPsw">新密码</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate">
                            <label for="password">确认密码</label>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="modal-footer">
            <a href="#" id="changePsw" class="modal-action modal-close waves-effect waves-green btn-flat ">确定</a>
            <a href="#" class="modal-action modal-close waves-effect waves-red btn-flat ">取消</a>
        </div>
    </div>


</main>

<script type="text/javascript">

    var activeType = 0;

    $('.button-collapse').sideNav({
                menuWidth: 300, // Default is 240
                edge: 'left', // Choose the horizontal origin
                closeOnClick: false, // Closes side-nav on <a> clicks, useful for Angular/Meteor
                draggable: true // Choose whether you can drag to open on touch screens
            }
    );

    $(document).ready(function () {

        $('.modal-trigger').leanModal();
        $('.dropdown-button').dropdown({
                    inDuration: 300,
                    outDuration: 225,
                    constrain_width: false, // Does not change width of dropdown to that of the activator
                    hover: true, // Activate on hover
                    gutter: 0, // Spacing from edge
                    belowOrigin: false, // Displays dropdown below the button
                    alignment: 'left' // Displays dropdown with edge aligned to the left of button
                }
        );

        $('#myClass').click(function () {
            $("#myClassDiv").show();
            $("#signInfoDiv").hide();
            $("#studentsInfoDiv").hide();
        });
        $('#signInfo').click(function () {

            $("#signInfoDiv").show();
            $("#myClassDiv").hide();
            $("#studentsInfoDiv").hide();
        });
        $("#addClass").click(function () {
            $("#classId").attr("disabled", false);
            $("#signInfoDiv form label").removeClass('active');
            $("#signInfoDiv form input").val("");
            $("#signInfoDiv").show();
            $("#myClassDiv").hide();
            $("#studentsInfoDiv").hide();
        });

        $("#dropdown1 a").click(function () {
            var content = $(this).html();
            $("#week").html(content);
        });


        $("#changePsw").click(function () {
            var nPsw = $("#nPsw").val();
            var psssword = $("#password").val();
            if (nPsw != "" && psssword != "" && nPsw == psssword) {

                $.post("changPwdAction",
                        {
                            pwd: nPsw
                        },
                        function (data, status) {
                            if ((data.b == true) && (status == "success")) {
                                alert("密码设置成功");
                            } else {
                                alert("密码设置失败");
                            }
                        });
            } else {
                alert("两次密码不一致或密码无效");
            }

        });


        $("#addClassBtn").click(function () {

            var classId = $.trim($("#classId").val());
            var className = $.trim($("#className").val());
            var classRoom = $.trim($("#classRoom").val());
            var week = $.trim($("#week").html());
            var lesson = $.trim($("#lesson").val());
            var b = true;
            if (!$.isNumeric(classId)) {
                alert("课程号包含非法字符" + classId);
                b = false;
            }
            if (!$.isNumeric(lesson)) {
                alert("节数包含非法字符");
                b = false;
            }
            if (week == "星期") {
                alert("请选择星期");
                b = false;
            } else if (week == "星期一") {
                week = 1;
            } else if (week == "星期二") {
                week = 2;
            } else if (week == "星期三") {
                week = 3;
            } else if (week == "星期四") {
                week = 4;
            } else if (week == "星期五") {
                week = 5;
            }
            if (b) {
                $.post("addClass",
                        {
                            action: "addClass",
                            classId: classId,
                            className: className,
                            classRoom: classRoom,
                            week: week,
                            lesson: lesson,
                            activeType: activeType
                        },
                        function (data, status) {
                            if ((data.b==true)&&(status == "success")) {
                                if (activeType == 0) {
                                    alert("添加成功");
                                } else {
                                    alert("修改成功");
                                }
                                window.location.reload();
                            }
                            if (s == "time error") {
                                alert("课程冲突");
                            }
                        });
            }
        });
        //删除课程
        $("td .del").click(function () {
            var cid = $(this).parents("tr").children(0).html();
            $.post("delClass",
                    {
                        action:"deleteClass",
                        cid:cid
                    },
                    function (data, status) {
                        if ((data.b==true)&&(status == "success")) {
                            alert("删除成功");
                            window.location.reload();
                        }
                    });
        });

        //编辑课程信息
        $("td .edit").click(function () {
            activeType = 1;
            var tds = $(this).parents("tr").children('td');
            $("#classId").val(tds.eq(0).text());
            $("#className").val(tds.eq(1).text());
            $("#classRoom").val(tds.eq(4).text());
            switch (tds.eq(2).text()) {
                case 1:
                    $("#week").html("星期一");
                    break;
                case 2:
                    $("#week").html("星期二");
                    break;
                case 3:
                    $("#week").html("星期三");
                    break;
                case 4:
                    $("#week").html("星期四");
                    break;
                case 5:
                    $("#week").html("星期五");
                    break;
            }
            $("#lesson").val(tds.eq(3).text());
            $("#signInfoDiv form label").addClass('active');
            $("#classId").attr("disabled", true);
            $("#signInfoDiv").show();
            $("#myClassDiv").hide();
        });

        //查看学生信息

        $("td .check").click(function () {

            var cid = $(this).parents("tr").children(0).html();
            $.post("getActionValue",
                    {
                        action: "getStudentInfo",
                        cid: cid
                    },
                    function (data, status) {
                        $("#students tbody").html("");
                        $("#teacher").remove();
                        var item = data.array;
                        for(var i=0;i<item.length;i++){
                            if (item[i].userType == 1) {
                                $("#students h3").after("<h5 id='teacher'>课程教师：" + item[i].name + "</h5>");
                            } else {
                                $("#students tbody").append("<tr><td>" + i + "</td><td>" + item[i].username + "</td><td>" + item[i].name + "</td></tr>");
                            }
                        }
                        $("#studentsInfoDiv").show();
                        $("#signInfoDiv").hide();
                        $("#myClassDiv").hide();
                    });
        });

    });

    $('#modal1').openModal();

    $('#modal1').closeModal();

    $('.dropdown-button').dropdown('open');


    $('.dropdown-button').dropdown('close');


</script>
</body>
</html>


