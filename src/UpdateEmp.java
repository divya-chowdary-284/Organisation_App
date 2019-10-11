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

@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs=((HttpServletRequest) req).getSession();

		List<EmployeeDetails> employeeList = (List<EmployeeDetails>) hs.getAttribute("employeeList");
		
		
		String id = req.getParameter("id");
		String name1 = req.getParameter("name");
		String dob1 = req.getParameter("dob");
		String gender1 = req.getParameter("gender");
		String desgn1 = req.getParameter("desgn");
		String join = req.getParameter("jd");
		String relieve = req.getParameter("rd");
	
		String cname=req.getParameter("name3");

		
		for(EmployeeDetails e:employeeList) {
			
			if(e.getEmpid()!=null && e.getEmpid().equalsIgnoreCase(id)) {
				
				e.setEmpid(id);
				e.setEmpname(name1);
				e.setDob(dob1);
				e.setGender(gender1);
				e.setDesignation(desgn1);
				e.setJoindate(join);
				e.setRelieveddate(relieve);
			
			}
		}
		hs.setAttribute("employeeList", employeeList);
		
		List<EmployeeDetails> employeeList1 = (ArrayList) hs.getAttribute("employeeList");
		
		PrintWriter pw = res.getWriter();	
		int j=1;
		pw.println("<html>"+"<body>"+"<h2>Employees belongs to "+cname+" are</h2>"+"<form action='Employee' method='post'>"+"<input type='submit' value='back'>"+"</form>");
		if(employeeList1!=null && !employeeList1.isEmpty()) {
			
			pw.println("<table id=\"table\" border=\"1\">"+"<tr>"+
					"<th>"+"Company name"+"</th>"+"<th>"+"Emp id"+"</th>"+"<th>"+"Name"+"</th>"+"<th>"+"DOB"+"</th>"+"<th>"+"Gender"+"</th>"
					+"<th>"+"Designation"+"</th>"+"<th>"+"Joining Date"+"</th>"+"<th>"+"Relieving date"+"</th>"+"<th>"+"EditEmp"+"</th>"+"</tr>");


			for(EmployeeDetails e:employeeList1) {
				if(e.getEmpid()!=null && e.getEmpid().equalsIgnoreCase(id)) {
				
						pw.println("<tr id='"+j+"'>"+"<td>"+e.getOrgname()+"</td>"+"<td>"+e.getEmpid()+"</td>"+"<td>"+e.getEmpname()+"</td>"+"<td>"+e.getDob()+"</td>"+"<td>"+e.getGender()+
								"</td>"+"<td>"+e.getDesignation()+"</td>"+"<td>"+e.getJoindate()+"</td>"+"<td>"+e.getRelieveddate()+"</td>"
								+"<td>"+"<a href='/OrganizationApp/EditEmp?id="+e.getEmpid()+"&name="+e.getEmpname()+"&dob="+e.getDob()+"&gender="+e.getGender()+"&desgn="+e.getDesignation()+"&jdate="+e.getJoindate()+"&rdate="+e.getRelieveddate()+"'>"
								+"<input type='Submit' name='EditEmp' value='EditEmp' >"+"</a>"
								+"</td>"+"</tr>");
						j++;
			}
			}
			
			pw.println("</table>"+"</body>"+"</html>");		
		}
		else {
			pw.println("<html>"+"<body>"+
					"<h2>"+"<p>"+"No Employee found"+"</p>"+
					"<form>"+"<input type = 'submit' value = 'back'>"+"</form>"+
					"</body>"+"</html>");
		}	
		//hs.setAttribute("employeeList", employeeList);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}	
	
}
