<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    <title>Todo List</title>
</head>
<body>
<div class="container">
<h1>Your Todos</h1>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Description</th>
        <th>Target</th>
        <th>Done</th>
        <th>Action</th>
    </tr>
    </thead>
    <c:forEach items="${todoList}" var="todo">
        <tr>
            <td>${todo.id}</td>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
            <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a> </td>
        </tr>
    </c:forEach>
</table>
    <a href="add-todo"  class="btn btn-success">Add todo</a>
</div>
<script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
<script src="webjars\jquery\3.6.0\jquery.min.js"></script>
</body>
</html>