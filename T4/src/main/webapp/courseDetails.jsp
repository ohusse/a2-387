<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: os92o
  Date: 11/10/2022
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/admin.css">
    <title>Welcome</title>
</head>
            <body>
            <div class="container">
                <h1>Students Enrolled</h1>
                <table class="table1">
                    <thead>
                    <tr>
                        <td>Student ID</td>
                        <td>Name</td>
                    </tr>
                    </thead>
                    <tbody>
                    <% ResultSet result = (ResultSet) request.getAttribute("resultString"); %>
                    <% while (result.next()){%>
                    <%="<tr>"%>
                    <%="<td>"%><%=result.getString("ID")%><%="</td>"%>
                    <%="<td>"%><%=result.getString("firstName")%> <%=result.getString("lastName")%><%="</td>"%>
                    <%="<td><a href=./studentDetailsServlet?ID="%><%=result.getString("ID")%><%=">Show Student Details</a></td>"%>
                    <%="</tr>"%> <%}%>
                    </tbody>
                </table>
            </div>
            </body>
    </html>
