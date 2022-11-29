<%@ page import="java.sql.ResultSet" %>

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
<h1>Course Catalogue</h1>
<form action="<%= request.getContextPath() %>/enrolledServlet" method="post">
    <table>
        <thead>
        <tr>
            <td>Course Code</td>
            <td>Title</td>
            <td>Days</td>
            <td>Start Time</td>
            <td>End Time</td>
            <td>Room</td>
            <td>Enroll</td>
        </tr>
        </thead>
        <% ResultSet notTakenSet = (ResultSet) request.getAttribute("notTaken"); %>
        <% while (notTakenSet.next()){%>
        <%="<tr>"%>
        <%="<td>"%><%=notTakenSet.getString("courseCode")%><%="</td>"%>
        <%="<td>"%><%=notTakenSet.getString("title")%><%="</td>"%>
        <%="<td>"%><%=notTakenSet.getString("days")%><%="</td>"%>
        <%="<td>"%><%=notTakenSet.getString("startTime")%><%="</td>"%>
        <%="<td>"%><%=notTakenSet.getString("endTime")%><%="</td>"%>
        <%="<td>"%><%=notTakenSet.getString("room")%><%="</td>"%>
        <%="<td>"%>
        <input type="hidden" name="courseCode" value="<%=notTakenSet.getString("courseCode")%>">
        <input type="hidden" name="title" value="<%=notTakenSet.getString("title")%>">
        <input type="hidden" name="day" value="<%=notTakenSet.getString("days")%>">
        <input type="hidden" name="startTime" value="<%=notTakenSet.getString("startTime")%>">
        <input type="hidden" name="endTime" value="<%=notTakenSet.getString("endTime")%>">
        <input type="hidden" name="room" value="<%=notTakenSet.getString("room")%>">
        <input type="hidden" name="courseID" value="<%=notTakenSet.getString("courseID")%>">
        <input type="hidden" name="semesterID" value="<%=notTakenSet.getString("semesterID")%>">
        <input type="hidden" name="adminID" value="<%=notTakenSet.getString("adminID")%>">
        <input type="submit" value="register">
        <%="</td>"%>
        <%="</tr>"%>
        <%}%>
    </table>
</form>
    <div class="a-div"><a href="./studentServlet">Student Profile</a></div>
</div>


</body>
</html>
