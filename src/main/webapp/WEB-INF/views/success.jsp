<%--
  Created by IntelliJ IDEA.
  User: 18852
  Date: 2020/8/26
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</body>
</html>
