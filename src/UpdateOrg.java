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

@WebServlet("/UpdateOrg")
public class UpdateOrg extends HttpServlet{

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs=((HttpServletRequest) req).getSession();

		List<OrganizationDetails> organizationList=(ArrayList) hs.getAttribute("organizationList");

		String name1 = req.getParameter("N1");
		String addr1 = req.getParameter("A1");
		String desc1 = req.getParameter("D1");
		String edate1 = req.getParameter("E1");
		
		String orgid = req.getParameter("orgid");

		for(OrganizationDetails o:organizationList) {
			
			if(o.getOrgId().equals(orgid)) {
				
				o.setOrgname(name1);
				o.setAddress(addr1);
				o.setDescription(desc1);
				o.setEstablishmentDate(edate1);
				
			}
			
		}
		hs.setAttribute("organizationList", organizationList);
		
		List<OrganizationDetails> organizationList1=(ArrayList) hs.getAttribute("organizationList");
		
		PrintWriter pw= res.getWriter();	
		int j=1;
		pw.println("<html>"+"<body>"+"<form action='homepage.html'>"+"<input type='submit' value='back to homepage'>"+"<br>"+"</form>");
		if(organizationList1!=null && !organizationList1.isEmpty()) {
			
			pw.println("<table id=\"table\" border=\"1\">"+
					"<tr>"+"<th>"+"Org Id"+"</th>"+"<th>"+"Name"+"</th>"+"<th>"+"Address"+"</th>"
					+"<th>"+"Description"+"</th>"+"<th>"+"Establishment date"+"</th>"+"<th>"+"SHOW"+"</th>"+"<th>"+"ADD"+"</th>"+"<th>"+"EDIT"+"</th>"+"</tr>");


			for(OrganizationDetails o:organizationList1) {

				pw.println("<tr id='"+j+"'>"+"<td>"+o.getOrgId()+"</td>"+"<td>"+ o.getOrgname()+"</td>"+"<td>"+o.getAddress()+"</td>"
						+"<td>"+o.getDescription()+"</td>"+"<td>"+o.getEstablishmentDate()+"</td>"+"<td>"+
						"<a href=\"/OrganizationApp/ShowEmp?ref="+o.getOrgname()+"\" method='get'><input type='Submit' name=\"showEmp\" value=\"showEmp\"></a>"+"</td>"
						+"<td>"+"<a href=\"/OrganizationApp/AddEmp?refname="+o.getOrgname()+"\" method='get'>"+"<input type='Submit' name=\"AddEmp\" value=\"AddEmp\" >"+"</a>"
						+"<td>"+"<a href=\"/OrganizationApp/EditOrg?id='"+o.getOrgId()+" '&name='"+o.getOrgname()+" '&address='"+o.getAddress()+" '&description='"+o.getDescription()+" '&edate='"+o.getEstablishmentDate()+"\">"+
						"<input type='Submit' name=\"EditOrg\" value=\"EditOrg\" >"+"</a>"
						+"</td>"+"</tr>");
				j++;

			}
			pw.println("</table>"+"</body>"+"</html>");		
		}
		else {
			pw.println("<html>"+"<body>"+
					"<h2>"+"<p>"+"No Organization found"+"</p>"+
					"<form>"+"<input type = 'submit' value = 'homePage'>"+"</form>"+
					"</body>"+"</html>");
		}	
		//hs.setAttribute("organizationList", organizationList);
	}
	
}
