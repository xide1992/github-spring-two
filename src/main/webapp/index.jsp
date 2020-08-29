<html>
<body>
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

</body>
</html>
