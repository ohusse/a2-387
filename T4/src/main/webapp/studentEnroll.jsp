<%@ page import="java.sql.ResultSet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
<br />
<a href="./studentServlet">Student Profile</a>
</body>
</html>
