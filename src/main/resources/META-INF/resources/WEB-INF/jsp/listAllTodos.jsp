<%@include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf" %>

<div class="container">
<h1>Your Todos</h1>
<table class="table">
    <thead>
    <tr>
<%--        <th>Id</th>--%>
        <th>Description</th>
        <th>Target</th>
        <th>Done</th>
        <th>Update</th>
        <th>DELETE</th>
    </tr>
    </thead>
    <c:forEach items="${todoList}" var="todo">
        <tr>
<%--            <td>${todo.id}</td>--%>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
            <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
            <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a> </td>
        </tr>
    </c:forEach>
</table>
    <a href="add-todo"  class="btn btn-success">Add todo</a>
</div>
<%@include file="common/footer.jspf"%>