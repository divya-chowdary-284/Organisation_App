import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AddEmp")
public class AddEmp extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("refname");
		//String oid=req.getParameter("oid");
		PrintWriter pw= res.getWriter();
		
		pw.println("<html>"+"<body>"+"<p>"+"Add Employees to: "+name+"</p>"
				+ "<form action='/OrganizationApp/Employee?refname="+name+"' method='post'>" + 
				"<h2>EmpId: <input type=\"text\" name=\"id\"></h2>" + 
				"<h2>Name: <input type=\"text\" name=\"name\"></h2>" + 
				"<h2>DOB: <input type=\"date\" name=\"dob\"></h2>" + 
				"<h2>Gender: <input type=\"text\" name=\"gender\"></h2>" + 
				"<h2>Designation: <input type=\"text\" name=\"desgn\"></h2>" + 
				"<h2>joining Date: <input type=\"date\" name=\"jd\"></h2>" + 
				"<h2>relieving Date: <input type=\"date\" name=\"rd\"></h2>" + 
				"<input type=\"submit\" value=\"submit\">" + 
				 "</form>"+"</body>"+"</html>");
	}
}
