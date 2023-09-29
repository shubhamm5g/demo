
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
public class log extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username=request.getParameter("uname");
        String password=request.getParameter("pass");
        
          Cookie ck1 = new Cookie("Username", username);         
        Cookie ck2 = new Cookie("Visit", "1"); 	
        response.addCookie(ck1);       
        response.addCookie(ck2); 

        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
          PreparedStatement pstm=con.prepareStatement("select username from loginData where username=? and password=?");
          pstm.setString(1,username);
          pstm.setString(2,password);
          ResultSet rs= pstm.executeQuery();
          if (rs.next()){
              RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
            rd.forward(request, response);
          }
          else{
              out.println("invalid password");
          }
        }
        catch(Exception e){
            out.println(e);
        }
    }
        

   
}
