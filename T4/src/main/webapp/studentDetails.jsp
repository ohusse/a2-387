<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: os92o
  Date: 11/11/2022
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="styles/admin.css">
    </head>
    <div class="container">
        <h1>Courses Enrolled</h1>
        <table class="table1">
            <thead>
            <tr>
                <td>Course Code</td>
                <td>Title</td>
                <td>Instructor</td>
                <td>Semester</td>
                <td>Days</td>
                <td>Start Time</td>
                <td>End Time</td>
                <td>Room</td>
            </tr>
            </thead>
            <tbody>
            <% ResultSet result = (ResultSet) request.getAttribute("resultString"); %>
            <% while (result.next()){%>
            <%="<tr>"%>
            <%="<td>"%><%=result.getString("courseCode")%><%="</td>"%>
            <%="<td>"%><%=result.getString("title")%><%="</td>"%>
            <%="<td>"%><%=result.getString("firstName")%><%="</td>"%>
            <%="<td>"%><%=result.getString("season")%><%="</td>"%>
            <%="<td>"%><%=result.getString("days")%><%="</td>"%>
            <%="<td>"%><%=result.getString("startTime")%><%="</td>"%>
            <%="<td>"%><%=result.getString("endTime")%><%="</td>"%>
            <%="<td>"%><%=result.getString("room")%><%="</td>"%>
            <%="</tr>"%> <%}%>
            </tbody>
        </table>
    </div>
    </body>
</html>
