<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: os92o
  Date: 11/10/2022
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="styles/admin.css">
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
                    <%="<td>"%><%=result.getString("studentID")%><%="</td>"%>
                    <%="<td>"%><%=result.getString("firstName")%> <%=result.getString("lastName")%><%="</td>"%>
                    <%="<td><a href=./studentDetailsServlet?studentID="%><%=result.getString("studentID")%><%=">Show Student Details</a></td>"%>
                    <%="</tr>"%> <%}%>
                    </tbody>
                </table>
            </div>
            </body>
    </html>