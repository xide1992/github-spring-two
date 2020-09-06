<%--
  Created by IntelliJ IDEA.
  User: 18852
  Date: 2020/8/26
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%--使用jstl标签库方式: c:foreach  c:if--%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>121111</h1>
<h1>requestScope</h1>
<h2>${requestScope.student.name}  - ${requestScope.student.age}</h2>
<h1>sessionScope</h1>
<h2>${sessionScope.student.name}  - ${sessionScope.student.age}</h2>
<c:forEach items="${requestScope.errors}" var="error">
    <%--var="error" 每一项元素--%>
    ${error.getDefaultMessage()} <br>
</c:forEach>
<fmt:message key="resource.welcome"></fmt:message>
<fmt:message key="resource.exit"></fmt:message>
</body>
</html>
