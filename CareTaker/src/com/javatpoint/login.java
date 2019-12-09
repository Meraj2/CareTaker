package com.javatpoint;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ServiceDao;
import bean.Vendor;
import bean.VendorDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("t1");
		String email=request.getParameter("t2");
		String pass=request.getParameter("t3");
		Vendor v=new Vendor();
		v.setUser_type(type);
		v.setEmail(email);
		v.setPassword(pass);
		boolean flag=VendorDao.login(v);
		if(flag)
		{
			HttpSession session=request.getSession();
			session.setAttribute("user", v);
			if(v.getUser_type().equals("Vendor"))
			{
				
				response.sendRedirect("success.jsp");
			}
			else
			{
				List list=ServiceDao.displayAll();
				session.setAttribute("services", list);
				response.sendRedirect("all_service.jsp");
			}
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
	}

}
