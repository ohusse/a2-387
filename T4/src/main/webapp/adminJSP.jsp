<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/9/2022
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List of courses</h1>
    <a href="./createCourse.php">Create New Course</a>
    <table>
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
        <%="<td>"%> <%=result.getString("room")%><%="</td>"%>
        <%="<td>"%> <%=result.getString("room")%><%="</td>"%>
<%--    echo "<td><a href=./courseDetails.php?courseID=" .$row["courseID"]. ">Show Course Details</a></td>"--%>
        <%="</tr>"%> <%}%>
        </tbody>
    </table>
</body>
</html>
