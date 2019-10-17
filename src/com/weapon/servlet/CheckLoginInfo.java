package com.weapon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weapon.bean.User;
import com.weapon.service.UserService;
import com.weapon.service.impl.UserServiceImpl;

/**
 * Servlet implementation class CheckLoginInfo
 */
@WebServlet("/checklogininfo")
public class CheckLoginInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private UserService userService=new UserServiceImpl();
	
	//���������javascript����ajax����
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=userService.login(username, password);
		 if(user!=null) {
			//����         
            	request.getSession().setAttribute("user", user);
    			response.getWriter().print("true");
		}
		else {
			//����
			response.getWriter().print("false");
		}
		
	}

}
