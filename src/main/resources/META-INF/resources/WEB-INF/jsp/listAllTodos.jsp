<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Todo List</title>
</head>
<body>
<p>Welcome ${name}</p>
<hr>
<h1>Your Todos</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Description</th>
        <th>Target</th>
        <th>Done</th>
    </tr>
    </thead>
    <c:forEach items="${todoList}" var="todo">
        <tr>
            <td>${todo.id}</td>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>