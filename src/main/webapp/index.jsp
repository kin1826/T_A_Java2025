<%@ page import="java.sql.*" %>
<%@ page import="com.demo.DBConnection" %>

<html>
<head>
    <title>Student Management</title>
</head>
<body>

<h1>Student Management</h1>

<form action="addStudent" method="post">

    Name:
    <input type="text" name="name">

    <br><br>

    Email:
    <input type="text" name="email">

    <br><br>

    <button type="submit">
        Add Student
    </button>

</form>

<hr>

<h2>Student List</h2>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>

    <%

        try {

            Connection conn =
                    DBConnection.getConnection();

            Statement st = conn.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            while(rs.next()) {

    %>

    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getString("email") %></td>
    </tr>

    <%

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    %>

</table>

</body>
</html>