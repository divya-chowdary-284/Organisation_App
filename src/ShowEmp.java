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

@WebServlet("ShowEmp")
public class ShowEmp extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs=((HttpServletRequest) req).getSession();
		int j=1;
		List<EmployeeDetails> employeeList = (List<EmployeeDetails>) hs.getAttribute("employeeList");
		
		String cname= req.getParameter("ref");
	
		
		PrintWriter pw=res.getWriter();

		if(employeeList!=null && !employeeList.isEmpty()) {
			pw.println("<html>"+"<body>"+"<h2>"+"Employees who belongs to "+cname+" are"+"</h2>"+"<table border=\"1\">"+
					"<tr>"+"<th>"+"Company name"+"</th>"+"<th>"+"Emp Id"+"</th>"+"<th>"+"Emp name"+"</th>"+"<th>"+"DOB"+"</th>"+"<th>"+"Gender"+"</th>"
					+"<th>"+"Designation"+"</th>"+"<th>"+"date of joining"+"</th>"+"<th>"+"date of relieving"+"</th>"+
					"</th>"+"<th>"+"extra"+"</th>"+"</tr>");

			for(EmployeeDetails e:employeeList) {

				if(e.getOrgname()!=null && e.getOrgname().equalsIgnoreCase(cname)) {

					pw.println("<tr>"+"<td>"+cname+"</td>"+"<td>"+e.getEmpid()+"</td>"+"<td>"+e.getEmpname()+"</td>"+"<td>"+e.getDob()+"</td>"
							+"<td>"+e.getGender()+"</td>"+"<td>"+e.getDesignation()+"</td>"+"<td>"+e.getJoindate()+"</td>"+"<td>"+e.getRelieveddate()+"</td>"
							+"<td>"+"<a href='/OrganizationApp/EditEmp?compname="+cname+"&id="+e.getEmpid()+"&name="+e.getEmpname()+"&dob="+e.getDob()+"&gender="+e.getGender()+
							"&desgn="+e.getDesignation()+"&jdate="+e.getJoindate()+"&rdate="+e.getRelieveddate()+"'>"
							+ "<input type='Submit' name=\"EditEmp\" value=\"EditEmp\"></a>"
							+"</td>"+"</tr>");
					j++;

				}
			}
			pw.println("<form action='Employee' method='post'>"+"<input type='submit' value='back'>"+"</form>");
			
			pw.println("</table>"+"</body>"+"</html>");
		}

		else {
			pw.println("<html>"+"<body>"+"<h1>No Employee Details is Available.</h1>"+"</body>"+"</html>");

		}
		hs.setAttribute("employeeList", employeeList);

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}


