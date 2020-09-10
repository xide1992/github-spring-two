<html>
<head>
<script type="text/javascript" src="views/js/jquery-1.8.3.js"></script><%--js与views平级不能访问???--%>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#testJson").click(function () {
                //通过ajax请求springmvc
                $.post(
                    "spring/mvc/testJson", <%--服务器地址--%>
                    //{"name","xdz"} 参数
                    function (result) {//服务器处理完毕后回调参数
                        for(var i=0;i<result.length;i++)
                        {
                            alert(result[i].name+"_"+result[i].age+"_"+result[i].email+"_")
                        }
                    }

                );
            })
        })
    </script>
</head>

<body>
<input type="button" value="testJson" id="testJson">
<h2>Hello World!</h2>
<a href="spring/mvc/welcome"> first mvc </a> <br>

<a href="spring/mvc/welcome1"> first mvc welcome1</a> <br>

<form action="/spring/mvc/welcome1" method="post">
    welcome1<br>
    name:<input name="name">  <br>
    age:<input name="age">  <br>
    <input type="submit" value="post">  <br>
</form>

<form action="/spring/mvc/welcome2" method="post">
    welcome2<br>
    name:<input name="name">  <br>
    age:<input name="age">  <br>
    <input type="submit" value="post">  <br>
</form>

<a href="spring/mvc/welcome3/asdas/test"> first mvc welcome3</a> <br>
<a href="spring/mvc/welcome4/abc/test"> first mvc welcome4</a> <br>
<a href="spring/mvc/welcome5/xdz"> first mvc welcome5</a> <br>

<form action="/spring/mvc/testRestful/1234" method="post">
    <input type="submit" value="add">  <br>
</form>

<form action="/spring/mvc/testRestful/1234" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="delete">  <br>
</form>

<form action="/spring/mvc/testRestful/1234" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="change">  <br>
</form>

<form action="/spring/mvc/testRestful/1234" method="get">
    <input type="submit" value="search">  <br>
</form>


<form action="/spring/mvc/testParam" method="get">
    <input name="uname" type="text">
    <input type="submit" value="testParam">  <br>
</form>


<form action="/spring/mvc/testObjectProperties" method="post">
    name:<input name="name" type="text">
    age:<input name="age" type="text">
    birthday:<input name="birthday" type="text">
    email:<input name="email" type="text">
    homeAddress:<input name="address.homeAddress" type="text">
    schoolAddress:<input name="address.schoolAddress" type="text">
    <input type="submit" value="testObjectProperties">  <br>
</form>

<form action="/spring/mvc/testHibernateValidator" method="post">
    name:<input name="name" type="text">
    age:<input name="age" type="text">
    birthday:<input name="birthday" type="text">
    email:<input name="email" type="text">
    homeAddress:<input name="address.homeAddress" type="text">
    schoolAddress:<input name="address.schoolAddress" type="text">
    <input type="submit" value="testHibernateValidator">  <br>
</form>

<form action="/spring/mvc/testHibernateValidatorNoBindingResult" method="post">
    name:<input name="name" type="text">
    age:<input name="age" type="text">
    birthday:<input name="birthday" type="text">
    email:<input name="email" type="text">
    homeAddress:<input name="address.homeAddress" type="text">
    schoolAddress:<input name="address.schoolAddress" type="text">
    <input type="submit" value="testHibernateValidatorNoBindingResult">  <br>
</form>

<form action="/spring/mvc/testHttpServlet" method="post">
    name:<input name="name" type="text">
    age:<input name="age" type="text">
    homeAddress:<input name="address.homeAddress" type="text">
    schoolAddress:<input name="address.schoolAddress" type="text">
    <input type="submit" value="testHttpServlet">  <br>
</form>

<a href="/spring/mvc/testModelAndView"> first mvc testModelAndView</a> <br>
<a href="/spring/mvc/testModelMap"> first mvc testModelMap</a> <br>
<a href="/spring/mvc/testMap"> first mvc testMap</a> <br>
<a href="/spring/mvc/testModel"> first mvc testModel</a> <br>
<a href="/spring/mvc/testSessionAttributes"> first mvc testSessionAttributes</a> <br>


<form action="/spring/mvc/testModelAttribute" method="get">
    name:<input name="name" type="text">
    <input type="submit" value="testModelAttribute">  <br>
</form>

<a href="/spring/mvc/testMvcViewController"> first mvc testMvcViewController</a> <br>

<a href="/spring/mvc/testForwardRedirect"> first mvc testForwardRedirect</a> <br>


<form action="/spring/mvc/testMyConvert" method="post">
    stu:<input name="stu" type="text">
    <input type="submit" value="testMyConvert">  <br>
</form>

<form action="/spring/mvc/testMyConvert2" method="post">
    tea:<input name="tea" type="text">
    <input type="submit" value="testMyConvert2">  <br>
</form>

<form action="/spring/mvc/testUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    描述:<input name="desc" type="text">
    <input type="submit" value="上传">  <br>
</form>

<a href="/spring/mvc/testException"> first mvc testException</a> <br>

<a href="/spring/mvc/testSimpleMappingException"> first mvc testSimpleMappingException</a> <br>

</body>
</html>
