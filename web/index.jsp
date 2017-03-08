<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/28
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <s:form name="from" action="login">
    <s:textfield name="username" label="用户名" />
    <s:password name="password" label="密码" />

    <s:submit value="确定" />
  </s:form>
  </body>
</html>
