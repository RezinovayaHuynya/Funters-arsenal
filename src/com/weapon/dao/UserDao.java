package com.weapon.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.weapon.bean.PageBean;
import com.weapon.bean.User;
import com.weapon.utils.C3P0Utils;

public class UserDao {
	public PageBean queryPageBean(int pageno,int pagesize) {
		//��η�ҳ��limit
		//select * from tbname where boolean1
		//group by columnname
		//having boolean2
		//order by columnname
		//limit ?,?
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from user limit ?,?";
		PageBean pageBean=new PageBean();
		try {
			List<User> users=qr.query(sql, new BeanListHandler<User>(User.class),(pageno-1)*pagesize,pagesize);
			pageBean.setPageNo(pageno);
			pageBean.setPageSize(pagesize);
			pageBean.setUser(users);
			//һ���ж���ҳ��
			Object object=qr.query("select count(*) from user", new ScalarHandler());
			long num=(Long)object;
			
			num=num/pagesize+(num%pagesize==0?0:1);
			pageBean.setPageSum(num);
			return pageBean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertToUser(String username,String password,String email, String message) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into user(username,password,email,message) values(?,?,?,?)";
		try {
			qr.update(sql,username,password,email,message);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateUser(int id,String username,String password,String email, String message) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="update user set username=?,password=?,email=?,message=? where id=?";
		try {
			qr.update(sql,username,password,email,message,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteUser(int id) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="delete from user where id=?";
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User selectUser(int id) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from user where id=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Boolean checkUser(String uname) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select count(*) from user where username=?";
		try {
			long c = (Long)qr.query(sql, new ScalarHandler(),uname);
			System.out.println(c);
			return (c>=1?false:true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}


	public interface UserDao1 {
		User selectUserByUsernameAndPassword(String username,String password);
		
	}
}
