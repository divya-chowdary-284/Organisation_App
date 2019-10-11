import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/EditEmp")
public class EditEmp extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs=((HttpServletRequest) req).getSession();
		
		String eid=req.getParameter("id");
		String myname=req.getParameter("name");
		String dob=req.getParameter("dob");
		String gender=req.getParameter("gender");
		String desgn=req.getParameter("desgn");
		String jdate=req.getParameter("jdate");
		String rdate=req.getParameter("rdate");
		
		String companyname=req.getParameter("compname");
		
		PrintWriter pw=res.getWriter();

		pw.println("<html>"+"<body>"+ "<form action='/OrganizationApp/UpdateEmp' method='get'>" + 
				
				"<h2>Company name: <input type='text' name='name3' value="+companyname+" readonly>"+
				"<h2>EmpId: <input type='text' name='id' value="+eid+" readonly></h2>" + 
				"<h2>Name: <input type='text' name='name' value="+myname+"></h2>" + 
				"<h2>DOB: <input type='date' name='dob' value="+dob+"></h2>" + 
				"<h2>Gender: <input type='text' name='gender' value="+gender+"></h2>" + 
				"<h2>Designation: <input type='text' name='desgn' value="+desgn+"></h2>" + 
				"<h2>joining Date: <input type='date' name='jd' value="+jdate+"></h2>" + 
				"<h2>relieving Date: <input type='date' name='rd' value="+rdate+"></h2>" + 
				
				"<input type=submit name='update' value='update'>");
		
		pw.println("</form>"+"</body>"+"</html>");

	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}	
	
}

