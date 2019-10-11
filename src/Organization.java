import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Organization")
public class Organization extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		HttpSession hs=((HttpServletRequest) req).getSession();
		
		int j=1;
		List<OrganizationDetails> organizationList=(ArrayList) hs.getAttribute("organizationList");
		
		OrganizationDetails od=new OrganizationDetails();
		
		od.setOrgId(req.getParameter("orgid"));
		od.setOrgname(req.getParameter("myname"));
		od.setAddress(req.getParameter("address"));
		od.setDescription(req.getParameter("desc"));
		od.setEstablishmentDate(req.getParameter("edate"));
		
		if(organizationList!=null && !organizationList.isEmpty()) {
			organizationList.add(od);
			
		}
		
		else {
			organizationList =new ArrayList<OrganizationDetails>();
			organizationList.add(od);
		}
		
		hs.setAttribute("organizationList", organizationList);
			
		 req.getServletContext().getRequestDispatcher("/homepage.html").include(req,res);
	}
}

