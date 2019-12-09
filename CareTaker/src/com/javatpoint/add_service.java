package com.javatpoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Service;
import bean.ServiceDao;
import bean.VendorDao;

/**
 * Servlet implementation class add_service
 */
@WebServlet("/add_service")
public class add_service extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_service() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("t1");
		String service=request.getParameter("t2");
		String charges=request.getParameter("t3");
		String warranty=request.getParameter("t4");
		String email=request.getParameter("t5");
		Service obj=new Service();
		obj.setService_type(type);
		obj.setService(service);
		obj.setCharges(charges);
		obj.setWarranty(warranty);
		obj.setEmail(email);
		int r=ServiceDao.save(obj);
		if(r>0)
		{
			response.sendRedirect("add_service.jsp");
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
		
		
	}

}
