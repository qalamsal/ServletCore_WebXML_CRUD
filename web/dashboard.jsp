<%@ page import="service.user.UserService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.User" %>
<%
    UserService userService=new UserService();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap 4 Striped Table</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .bs-example{
            margin: 20px;
        }
    </style>
</head>
<body>
<div class="bs-example">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>User</th>
            <th>Status</th>
        </tr>
        </thead>

        <tbody>
        <%
            ArrayList<User> users= userService.listUsers();
            for(User user:users)
            {
        %>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getStatus()%></td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>