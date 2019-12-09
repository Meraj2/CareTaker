package com.javatpoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Service;
import bean.ServiceDao;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("t1");
		String type=request.getParameter("t2");
		String service=request.getParameter("t3");
		String charges=request.getParameter("t4");
		String warranty=request.getParameter("t5");
		int id=Integer.valueOf(request.getParameter("t6"));
		Service obj=new Service();
		obj.setService_type(type);
		obj.setService(service);
		obj.setCharges(charges);
		obj.setWarranty(warranty);
		obj.setEmail(email);
		obj.setId(id);
		int r=ServiceDao.update(obj);
		response.sendRedirect("success.jsp");
		
	}

}
