package assessment2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pre;
	
    public RegisterPage() {
    	try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","seed1234");
		}
    	catch(Exception e)
    	{
    		e.printStackTrace();    		
    	}
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			PrintWriter out=response.getWriter();
			pre=con.prepareStatement("insert into user_table values(?,?,?)");
			
			String loginId=request.getParameter("loginId");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			

			pre.setString(1,loginId);
			pre.setString(2,password);
			pre.setString(3,email);

			
			int ra=pre.executeUpdate();
			if(ra>0){
				out.println("Details Inserted Succcessfully.");
				out.println("<a href='firstPage.html'>MainPage</a>");
			}
			
			else
				out.println("Details are not inserted.");
			out.println("<a href='register.html'>Try Again</a>");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}