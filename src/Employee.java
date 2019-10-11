import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Employee")
public class Employee extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked"})
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession hs=((HttpServletRequest) req).getSession();
		
		List<EmployeeDetails> employeeList = (List<EmployeeDetails>) hs.getAttribute("employeeList");
		
		EmployeeDetails ed=new EmployeeDetails();
		
		ed.setEmpid(req.getParameter("id"));
		ed.setEmpname(req.getParameter("name"));
		ed.setDob(req.getParameter("dob"));
		ed.setGender(req.getParameter("gender"));
		ed.setDesignation(req.getParameter("desgn"));
		ed.setJoindate(req.getParameter("jd"));
		ed.setRelieveddate(req.getParameter("rd"));
		ed.setOrgname(req.getParameter("refname"));
		
		
		if(employeeList!=null && !employeeList.isEmpty()) {
			employeeList.add(ed);
		}
		
		else {
			employeeList =new ArrayList<EmployeeDetails>();
			employeeList.add(ed);
		}
		hs.setAttribute("employeeList", employeeList);
		
		
		 req.getServletContext().getRequestDispatcher("/ShowOrganization").include(req,res);
		}
	

}
