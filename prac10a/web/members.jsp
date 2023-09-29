<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <h1>Members of our society</h1>
        <div>My name is shubham</div>
        <div>
            <table border="1">
                <tr>
                    <td>username</td>
                    <td>age</td>
                    <td>email   </td>
                </tr>
            <%
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
                Statement smt=con.createStatement();
                String statement="select * from loginData";
                ResultSet rs=smt.executeQuery(statement);
                while (rs.next()){
                    %>
                    <tr>
                        <td><%=rs.getString("username")%></td>
                        <td><%=rs.getInt("age")%></td>
                        <td><%=rs.getString("email")%></td>
                    </tr>
                    <%
                }
                
            }   
            catch(Exception e){
  
            }
            %>
            
            </table>
        </div>
        
    </body>
</html>
