

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showData")
public class showData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public showData() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root", "");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from persondetails");  
			
		pw.print("<!doctype html>");
		pw.print("<html lang=\"en\"><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"><link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\"><title>Hello, world!</title></head><body>");
//		pw.print("<div class=\"container\">");   
		pw.print("<h1>Show Data</h1>");
		pw.print("<table class=\"table table-bordered\">");
	      pw.print("<thead>");
	        pw.print("<tr>");
	          pw.print("<th scope=\"col\">ID</th>");
	          pw.print("<th scope=\"col\">Name</th>");
	          pw.print("<th scope=\"col\">DOB</th>");
	          pw.print("<th scope=\"col\">Email</th>");
	          pw.print("<th scope=\"col\">Contact</th>");
	          pw.print("<th scope=\"col\">Address</th>");
	          pw.print("<th scope=\"col\">City</th>");
	          pw.print("<th scope=\"col\">Pincode</th>");
	          pw.print("<th scope=\"col\">Gender</th>");
	          pw.print("<th scope=\"col\">Edit</th>");
	          pw.print("<th scope=\"col\">Delete</th>");
	        pw.print("</tr>");
	      pw.print("</thead>");
	      pw.print("<tbody>");
	      while(rs.next())
	      {
	        pw.print("<tr>");
	          pw.print("<td>"+rs.getInt(1)+"</td>");
	          pw.print("<td>"+rs.getString(2)+"</td>");
	          pw.print("<td>"+rs.getString(6)+"</td>");
	          pw.print("<td>"+rs.getString(3)+"</td>");
	          pw.print("<td>"+rs.getDouble(7)+"</td>");
	          pw.print("<td>"+rs.getString(4)+"</td>");
	          pw.print("<td>"+rs.getString(5)+"</td>");
	          pw.print("<td>"+rs.getInt(8)+"</td>");
	          int gender = rs.getInt(9);
	          String data = "";
	          if(gender == 0)
	          {
	        	  data = "Male";
	          }
	          else
	          {
	        	  data = "Female";
	          }
	          pw.print("<td>"+data+"</td>");
	          pw.print("<td><a href='editdata?id="+rs.getInt(1)+"'>Edit</a></td>");
	          pw.print("<td><a href='deletedata'>Delete</a></td>");
	        pw.print("</tr>");
	      }
	      pw.print("</tbody>");
	    pw.print("</table>");
//		pw.print("</div>");
		pw.print("</body></html>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
