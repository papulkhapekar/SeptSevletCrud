

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public update() {
        super();
        // TODO Auto-generated constructor stub
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String pname,dob,email,address, city,gender;
		double contact;
		int id, pin, gender1 = 0;
		id = Integer.parseInt(request.getParameter("id"));
		pname = request.getParameter("pname");
		dob = request.getParameter("dob");
		email = request.getParameter("email");
		address = request.getParameter("address");
		city = request.getParameter("city");
		contact = Long.parseLong(request.getParameter("contact"));
		pin = Integer.parseInt(request.getParameter("pin"));
		gender = request.getParameter("gender");
		gender = gender.toLowerCase();
		if(gender.equals("male"))
		{
			gender1 = 0;
		}
		else if(gender.equals("female"))
		{
			gender1 =1;
		}
		else
		{
			pw.print("Please enter Valid gender value");
			throw new ArithmeticException("Please enter Valid gender value");    
		}
		Connection con;
		try {
			int status = 0;
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root", "");
			 Statement st = con.createStatement();
				PreparedStatement stmt=con.prepareStatement("update persondetails set pname=?,email=?,address=?,city=?,dob=?,contact=?,pin=?,gender=? where pid=?");  
				
				stmt.setString(1, pname);
				stmt.setString(2, email);
				stmt.setString(3, address);
				stmt.setString(4, city);
				stmt.setString(5, dob);
				stmt.setDouble(6, contact);
				stmt.setInt(7, pin);
				stmt.setInt(8, gender1);
				stmt.setInt(9, id);
				status = stmt.executeUpdate();
				if(status>=1)
				{
					pw.print("person data updated successfully");
				}
				else
				{
					pw.print("fail to update data");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
