package com.weapon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weapon.bean.PageBean_p;
import com.weapon.dao.ProductDao;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/info_p")
public class InfoServlet_p extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet_p() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private ProductDao productDao=new ProductDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����ҳ�롢ҳ�Ĵ�С��Ȼ���ҷ�������
		String pageNoStr=request.getParameter("pageno");
		String pageSizeStr=request.getParameter("pagesize");
		int pageno=Integer.parseInt(pageNoStr);
		int pagesize=Integer.parseInt(pageSizeStr);
		
		
		PageBean_p pageBean_p=productDao.queryPageBean(pageno, pagesize);
		
		if(pageBean_p!=null) {
			JSONObject jsonObject=JSONObject.fromObject(pageBean_p);
			
			response.setContentType("text/html;charset=utf-8");
			
			response.getWriter().print(jsonObject.toString());
		}else {
			response.getWriter().print("error");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from user";
		try {
			List<User> list=qr.query(sql, new BeanListHandler<User>(User.class));
			//���json
			JSONArray jsonArray=JSONArray.fromObject(list);
			response.setContentType("text/html;charset=utf-8");
			
			response.getWriter().print(jsonArray.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
