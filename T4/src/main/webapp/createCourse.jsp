<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2022-11-10
  Time: 8:33 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.ResultSet"%>
<%@ page import="java.sql.ResultSet" %>
      <!DOCTYPE html>
      <html lang="en">
          <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="styles/admin.css">
            <title>Course Creation Form</title>
          </head>
                  <body>
                  <div class = "container2">
                    <h1>Add Course</h1>
                    <form action="<%= request.getContextPath() %>/registerCourse" method="post">
                      <label for="courseCode">Course Code</label><br>
                      <input type="text" name="courseCode" id="courseCode"><br>

                      <label for="adminID">Instructor</label><br>
                      <select name='adminID' id='adminID'>
                        <option hidden disabled selected value> -- select an option -- </option>
                        <% ResultSet result = (ResultSet) request.getAttribute("resultString");%>
                        <% while (result.next()){%>
                        <%="<option value=" + result.getString("adminID") + ">" + result.getString("firstName") + " " + result.getString("lastName") + "</option>"%>
                        <%}%>
                      </select><br>

                      <label for="semesterID">Semester</label><br>
                      <select name="semesterID" id="semesterID">
                        <option hidden disabled selected value> -- select an option -- </option>
                        <% ResultSet result2 = (ResultSet) request.getAttribute("resultString2");%>
                        <% while (result2.next()){%>
                        <%="<option value=" + result2.getString("semesterID") + ">" + result.getString("season") + " " + result.getString("year") + "</option>"%>
                        <%}%>
                      </select><br>
                      <label for="days">Days</label><br>
                      <input type="text" name="days" id="days"><br>
                      <label for="startTime">Start Time</label><br>
                      <input type="time" name="startTime" id="startTime"><br>
                      <label for="endTime">End Time</label><br>
                      <input type="time" name="endTime" id="endTime"><br>
                      <label for="title">Course Title</label><br>
                      <input type="text" name="title" id="title"><br>
                      <label for="room">Room</label><br>
                      <input type="text" name="room" id="room"><br>

                      <div class="submitions">
                        <button type="submit">Add</button>
                        <a href="<%= request.getContextPath() %>/adminJSP.jsp" class = "button">Return</a>
                      </div>

                    </form>

                  </div>
                  </body>
      </html>