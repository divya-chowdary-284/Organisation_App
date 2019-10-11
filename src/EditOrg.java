
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("EditOrg")
public class EditOrg extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs=((HttpServletRequest) req).getSession();

		String orgid=req.getParameter("refid");
		String myname=req.getParameter("name");
		String addr=req.getParameter("address");
		String desc=req.getParameter("description");
		String edate=req.getParameter("date");
		
		PrintWriter pw=res.getWriter();

		pw.println("<html>"+"<body>"+ "<form action='/OrganizationApp/UpdateOrg' method = 'post'>" +  
				"<h2>Org id: <input type='text' name='orgid' value="+orgid+" readonly></h2>"+
				
				"<h2>Name: <input type='text' name='N1' value="+myname+"></h2>" + 
				"<h2>Address: <input type='text' name='A1' value="+addr+"></h2>" + 
				"<h2>Description: <input type='text' name='D1' value="+desc+"></h2>" + 
				"<h2>Establishment Date: <input type='date' name='E1' value="+edate+"></h2>"+
				
				"<input type=submit name='update' value='update'>");
		
		pw.println("</form>"+"</body>"+"</html>");

	}
	
}


