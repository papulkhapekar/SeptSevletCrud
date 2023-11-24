

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editdata")
public class editdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public editdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("id"));
//		System.out.println(pid);
		Connection con;
		String pname = null,dob="",email = null,address = null, city = null,gender = "";
		long contact = 0;
		int pin = 0, gender1 = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root", "");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from persondetails where pid="+pid); 
			
			while(rs.next())
			{
				pname = rs.getString(2);
				dob = rs.getString(6);
				email = rs.getString(3);
				address = rs.getString(4);
				city = rs.getString(5);
				contact = rs.getLong(7);
				pin = rs.getInt(8);
				gender1 = rs.getInt(9);
			}
			if(gender1 == 0)
			{
				gender = "Male";
			}
			else
			{
				gender = "Female";
			}
//			System.out.println(contact+gender+pin+address+city+email+pname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		pw.print("<!doctype html><html lang=\"en\"><head> <meta charset=\"utf-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		pw.print(" <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">");
		pw.print("<title>Hello, world!</title> </head> <body> <div class=\"container\"> <div class=\"row\"> <div class=\"col\"></div> <div class=\"col\"> <h1>Edit Information</h1> </div> <div class=\"col\"></div> </div>");
		
//		form Data Start
		
		pw.print("	<form action=\"update\" method=\"post\">");
		pw.print("<input type=\"hidden\" class=\"form-control\" name=\"id\" value="+pid+" required>");
	    pw.print("	<div class=\"row\">");
	    pw.print("		<div class=\"col\"></div>");
	    pw.print("		<div class=\"col\">");
	    pw.print("			<div class=\"form-group\">");
			pw.print("			    <label>Name</label>");
			pw.print("			    <input type=\"text\" class=\"form-control\" name=\"pname\" value="+pname+" required>");
			pw.print("			</div>");
			pw.print("			<div class=\"form-group\">");
			pw.print("			    <label>Email</label>");
			pw.print("			    <input type=\"email\" class=\"form-control\" name=\"email\" value="+email+" required>");
			pw.print("			</div>");
			pw.print("			<div class=\"form-group\">");
			pw.print("			    <label>Contact</label>");
			pw.print("			    <input type=\"number\" class=\"form-control\" name=\"contact\" value="+contact+" required>");
			pw.print("			</div>");
			pw.print("			<div class=\"form-group\">");
			pw.print("			    <label>gender</label>");
			pw.print("			    <input type=\"text\" class=\"form-control\" name=\"gender\" value="+gender+" required>");
			pw.print("			</div>");
			pw.print("			<button type=\"submit\" class=\"btn btn-warning mt-1\">Submit</button>");
	    pw.print("		</div>");
	    pw.print("		<div class=\"col\">");
	    pw.print("		<div class=\"form-group\">");
			pw.print("			    <label>DOB</label>");
			pw.print("			    <input type=\"date\" class=\"form-control\" name=\"dob\" value="+dob+" required>");
			pw.print("			</div>");
			pw.print("			<div class=\"form-group\">");
			pw.print("			    <label>Address</label>");
			pw.print("			    <input type=\"text\" class=\"form-control\" name=\"address\" value="+address+" required>");
			pw.print("			</div>");
			pw.print("			<div class=\"form-group\">");
			pw.print("			    <label>City</label>");
			pw.print("			    <input type=\"text\" class=\"form-control\" name=\"city\" value="+city+" required>");
			pw.print("			</div>");
			pw.print("			<div class=\"form-group\">");
			pw.print("			    <label>Pincode</label>");
			pw.print("			    <input type=\"number\" class=\"form-control\" name=\"pin\" value="+pin+" required>");
			pw.print("			</div>");
	    pw.print("		</div>");
	    pw.print("<div class=\"col\"></div>");
	    pw.print("	</div>");
	    pw.print("	</form>");
	    pw.print("</div>");
		
//		Form Data End
		
		
		pw.print("</div><script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script> <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>");
		pw.print("</body> </html>");
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
