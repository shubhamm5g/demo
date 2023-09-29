
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;

public class Login extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uname=request.getParameter("uname");
        String password=request.getParameter("pass");
        String repassword=request.getParameter("repass");
        int age=Integer.parseInt(request.getParameter("age"));
        String email=request.getParameter("email");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
            PreparedStatement pstm=con.prepareStatement("insert into loginData values(?,?,?,?)");
            pstm.setString(1,uname);
            pstm.setString(2,password);
            pstm.setInt(3,age);
            pstm.setString(4,email);
            int row=pstm.executeUpdate();
            if(row==1){
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.forward(request, response);

            }
            else{
                out.println("data could not be inserted");
            }
            
        }
        catch(Exception e){
           out.println(e);
        }
    }

   
}
