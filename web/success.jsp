<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/28
  Time: 21:11
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
    <title>首页</title>

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
        .hide{
            display: none;
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
        <li class="bold"><a id="myClass" href="#" class="waves-effect waves-teal"><i class="material-icons">info</i>我的课程</a>
        </li>
        <li class="bold"><a id="signInfo" href="#" class="waves-effect waves-teal"><i
                class="material-icons">mode_edit</i>签到情况</a></li>
        <li class="bold"><a href="#modal1" class="waves-effect waves-teal modal-trigger"><i class="material-icons">settings_applications</i>修改密码</a>
        </li>
        <li class="bold"><a  href="logout?action=logout" class="waves-effect waves-teal"><i class="material-icons">power_settings_new</i>退出</a>
        </li>
    </ul>
</header>
<main>

    <div id="myClassDiv" class="row" style="width: 95%;">
        <div id="class" class="section scrollspy">
            <h3 class="header">我的课程</h3>
            <div class="row">
                <div class="col s12">
                    <table class="bordered">
                        <thead>
                        <tr>
                            <th data-field="id">时间/星期</th>
                            <th data-field="name">星期一</th>
                            <th data-field="price">星期二</th>
                            <th data-field="price">星期三</th>
                            <th data-field="price">星期四</th>
                            <th data-field="price">星期五</th>
                        </tr>
                        </thead>
                        <tbody>

                        <s:if test="#session.classes!=null">
                            <s:iterator value="#session.classes" id="item">
                                <tr>
                                <s:iterator value="#item" id="v">

                                        <td><s:property value="v" escape="false" /></td>

                                </s:iterator>
                                </tr>
                            </s:iterator>
                        </s:if>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="row" style="width: 95%;display: none" id="signInfoDiv">
        <div class="section scrollspy">
            <h3 class="header">签到情况</h3>
                    <div class='row' style="display:${user.userType==0?'block':'none'};">
                        <div class='col s12'>
                            <table class='bordered'>
                                <thead>
                                <tr>
                                    <th data-field='id'>日期</th>
                                    <th data-field='id'>星期</th>
                                    <th data-field='id'>课程名称</th>
                                    <th data-field='name'>节号</th>
                                    <th data-field='price'>签到情况</th>
                                </tr>
                                </thead>
                                <tbody>
                                <s:iterator value="#session.stuSignInfo" id="item">
                                    <tr>
                                        <td><s:property value="#item.day" /></td>
                                        <td><s:property value="#item.week" /></td>
                                        <td><s:property value="#item.className" /></td>
                                        <td><s:property value="#item.lesson" /></td>
                                        <s:if test="#item.sign==1">
                                            <td style='background:#00e676'>已签到</td>
                                        </s:if>
                                        <s:else>
                                            <td style='background:#d50000'>未签到</td>
                                        </s:else>

                                    </tr>
                                </s:iterator>

                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class='row' style="display:${user.userType==0?'none':'block'};">
                        <div class='col s12'>
                            <s:iterator value="#session.taeSignInfo" id="item">
                                <h5><s:property value="#item.className" /></h5>
                                <table class='bordered'>
                                    <thead>
                                    <tr>
                                        <th data-field='id'>日期</th>
                                        <th data-field='id'>星期</th>
                                        <th data-field='name'>学号</th>
                                        <th data-field='name'>姓名</th>
                                        <th data-field='name'>节号</th>
                                        <th data-field='price'>签到情况</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="#item.list" id="v">
                                            <tr>
                                                <td><s:property value="#v.day" /></td>
                                                <td><s:property value="#v.week" /></td>
                                                <td><s:property value="#v.stuName" /></td>
                                                <td><s:property value="#v.stuId" /></td>
                                                <td><s:property value="#v.lesson" /></td>
                                                <s:if test="#v.sign==1">
                                                    <td style='background:#00e676'>已签到</td>
                                                </s:if>
                                                <s:else>
                                                    <td style='background:#d50000'>未签到</td>
                                                </s:else>

                                            </tr>
                                        </s:iterator>

                                    </tbody>
                                </table>
                            </s:iterator>
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
    $('.button-collapse').sideNav({
                menuWidth: 300, // Default is 240
                edge: 'left', // Choose the horizontal origin
                closeOnClick: false, // Closes side-nav on <a> clicks, useful for Angular/Meteor
                draggable: true // Choose whether you can drag to open on touch screens
            }
    );

    $(document).ready(function () {

        $('#myClass').click(function () {
            $("#myClassDiv").show();
            $("#signInfoDiv").hide();
        });
        $('#signInfo').click(function () {

            $("#signInfoDiv").show();
            $("#myClassDiv").hide();
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
    });

    $(document).ready(function () {
        // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
        $('.modal-trigger').leanModal();
    });

    $('#modal1').openModal();

    $('#modal1').closeModal();


</script>
</body>
</html>


