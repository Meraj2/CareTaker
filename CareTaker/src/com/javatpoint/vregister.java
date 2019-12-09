package com.javatpoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Vendor;
import bean.VendorDao;

/**
 * Servlet implementation class vregister
 */
@WebServlet("/vregister")
public class vregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vregister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("t1");
		String lname=request.getParameter("t2");
		String pass=request.getParameter("t3");
		String email=request.getParameter("t4");
		String mobile=request.getParameter("t5");
		String type=request.getParameter("t6");
		Vendor obj=new Vendor();
		obj.setUser_type(type);
		obj.setFname(fname);
		obj.setLname(lname);
		obj.setPassword(pass);
		obj.setEmail(email);
		obj.setMobile(mobile);
		HttpSession session=request.getSession();
		int r=VendorDao.save(obj);
		if(r>0)
		{
			session.setAttribute("msg","Please login");
			response.sendRedirect("login.jsp");
		}
		else
		{
			session.setAttribute("msg","Registration fail");
			response.sendRedirect("register.jsp");
		}
		
	}

}
