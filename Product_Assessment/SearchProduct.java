package assessment2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pre;
	
    public SearchProduct() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ResultSet rs = null;
		String name = request.getParameter("name");
		try{
			PreparedStatement ps = con.prepareStatement("select * from products where name=?");
			ps.setString(1,name);
			
			rs=ps.executeQuery();
			out.println("<table border = 2><tr><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Product Category</th></tr>");
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getString("id")+"</td>");
				out.println("<td>"+rs.getString("name")+"</td>");
				out.println("<td>"+rs.getString("price")+"</td>");
				out.println("<td>"+rs.getString("category")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
