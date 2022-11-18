<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Student Information</h1>

    <% ResultSet studentInfoSet = (ResultSet) request.getAttribute("studentInfo");%>

    <p>FIRST NAME: <%=studentInfoSet.getString("firstName")%></p>
    <p>LAST NAME: <%=studentInfoSet.getString("lastName")%></p>
    <p>ADDRESS: <%=studentInfoSet.getString("address")%></p>
    <p>EMAIL: <%=studentInfoSet.getString("email")%></p>
    <p>PHONE: <%=studentInfoSet.getString("phoneNum")%></p>
    <p>DATE OF BIRTH: <%=studentInfoSet.getString("dob")%></p>


    <br />
<h1>Drop Classes Being Taken</h1>


<form action="<%= request.getContextPath() %>/dropClassServlet" method="post">
    <table>
        <thead>
        <tr>
            <td>Course Code</td>
            <td>Title</td>
            <td>Days</td>
            <td>Start Time</td>
            <td>End Time</td>
            <td>Room</td>
            <td>Drop</td>
        </tr>
        </thead>
        <% ResultSet classesTakenSet = (ResultSet) request.getAttribute("classesTaken"); %>
        <% while (classesTakenSet.next()){%>
        <%="<tr>"%>
        <%="<td>"%><%=classesTakenSet.getString("courseCode")%><%="</td>"%>
        <%="<td>"%><%=classesTakenSet.getString("title")%><%="</td>"%>
        <%="<td>"%><%=classesTakenSet.getString("days")%><%="</td>"%>
        <%="<td>"%><%=classesTakenSet.getString("startTime")%><%="</td>"%>
        <%="<td>"%><%=classesTakenSet.getString("endTime")%><%="</td>"%>
        <%="<td>"%><%=classesTakenSet.getString("room")%><%="</td>"%>
        <%="<td>"%>
        <input type="hidden" name="courseCode" value="<%=classesTakenSet.getString("courseCode")%>">
        <input type="hidden" name="title" value="<%=classesTakenSet.getString("title")%>">
        <input type="hidden" name="day" value="<%=classesTakenSet.getString("days")%>">
        <input type="hidden" name="startTime" value="<%=classesTakenSet.getString("startTime")%>">
        <input type="hidden" name="endTime" value="<%=classesTakenSet.getString("endTime")%>">
        <input type="hidden" name="room" value="<%=classesTakenSet.getString("room")%>">
        <input type="hidden" name="courseID" value="<%=classesTakenSet.getString("courseID")%>">
        <input type="hidden" name="semesterID" value="<%=classesTakenSet.getString("semesterID")%>">
        <input type="hidden" name="adminID" value="<%=classesTakenSet.getString("adminID")%>">
        <input type="hidden" name="studentID" value="<%=request.getAttribute("studentID")%>">
        <input type="submit" value="Drop">
        <%="</td>"%>
        <%="</tr>"%>
        <%}%>
    </table>
</form>
<br />
<a href="./studentClassRegistrationServlet">Class Registration</a>
</body>
</html>
