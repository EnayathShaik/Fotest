package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ir.model.District;
import com.ir.util.HibernateUtil;
/**
 * Servlet implementation class DeleteState
 */

public class ChangeStatusDistrict extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusDistrict() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		System.out.println("passing name   :" + name);
		String[] totalConnected = name.split("&");
		String id,status,distName;
		
		
		id = (totalConnected[0].split("="))[1];
		status = (totalConnected[1].split("="))[1];
		distName = (totalConnected[2].split("="))[1];
		//districtIdH = (totalConnected[4].split("="))[1];
		System.out.println("check status:"+status);
		System.out.println("district name==>"+distName);
		
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.openSession();
		
		String newList = null;
	
			District d = (District) session.load(District.class,Integer.parseInt( id));			
			System.out.println("else");
			d.setStatus(status);
			d.setDistrictName(distName);
			session.update(d);
			session.beginTransaction().commit();
			session.close();
			newList = "Status changet to In-Active" ;
	//	}
		out.write(newList);
		out.flush();
		

	}

}
