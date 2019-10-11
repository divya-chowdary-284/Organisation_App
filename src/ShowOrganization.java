
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
@WebServlet("ShowOrganization")
public class ShowOrganization extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs=((HttpServletRequest) req).getSession();
		
		List<OrganizationDetails> organizationList=(List<OrganizationDetails>) hs.getAttribute("organizationList");
		
		PrintWriter pw=res.getWriter();

		if(organizationList!=null && !organizationList.isEmpty()) {
			int j=1;
			
			pw.println("<html>"+"<body>"+"<table id=\"table\" border=\"1\">"+
					"<tr>"+"<th>"+"Org Id"+"</th>"+"<th>"+"Name"+"</th>"+"<th>"+"Address"+"</th>"
					+"<th>"+"Description"+"</th>"+"<th>"+"Establishment date"+"</th>"+"<th>"+"SHOW"+"</th>"+"<th>"+"ADD"+"</th>"+"<th>"+"EDIT"+"</th>"+"</tr>");


			for(OrganizationDetails o:organizationList) {

				pw.println("<tr id='"+j+"'>"+"<td>"+o.getOrgId()+"</td>"+"<td>"+  o.getOrgname()+"</td>"+"<td>"+o.getAddress()+"</td>"
						+"<td>"+o.getDescription()+"</td>"+"<td>"+o.getEstablishmentDate()+"</td>"
						+"<td>"+"<a href='/OrganizationApp/ShowEmp?orgid="+o.getOrgId()+"&ref="+o.getOrgname()+"'><input type='Submit' name=\"showEmp\" value=\"showEmp\"></a>"+"</td>"
						+"<td>"+"<a href='/OrganizationApp/AddEmp?oid="+o.getOrgId()+"&refname="+o.getOrgname()+"'>"+"<input type='Submit' name=\"AddEmp\" value=\"AddEmp\" >"+"</a>"
						+"<td>"+"<a href='/OrganizationApp/EditOrg?refid="+o.getOrgId()+"&name="+o.getOrgname()+"&address="+o.getAddress()+"&description="+o.getDescription()+"&date="+o.getEstablishmentDate()+"' >"
						+ "<input type='Submit' name=\"EditOrg\" value=\"EditOrg\">"+"</a>"
						+"</td>"+"</tr>");
				j++;

			}
			pw.println("<form action='homepage.html'>"+"<input type='submit' value='back to homepage'>"+"</form>");
			
			pw.println("</table>"+"</body>"+"</html>");
		}
		else {
			pw.println("<html>"+"<body>"+"<h1>No Organization Is Available.</h1>"+"</body>"+"</html>");
		}

	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

