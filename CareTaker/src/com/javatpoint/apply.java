package com.javatpoint;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Vendor;
import bean.VendorDao;

/**
 * Servlet implementation class apply
 */
@WebServlet("/apply")
public class apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public apply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("t1");
		Vendor v=new Vendor();
		v.setEmail(email);
		Vendor data=VendorDao.search(v);
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		out.print("<hr><br >Vendor name :"+data.getFname()+" "+data.getLname());
		out.print("<br >E-mail :"+data.getEmail());
		out.print("<br >Mobile :"+data.getMobile());
		out.print("<hr></body></html>");
		
	}

}
