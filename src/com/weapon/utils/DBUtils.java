package com.weapon.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.weapon.bean.User;


public class DBUtils {
	private static String url;
	private static String driverClass;
	private static String user;
	private static String password;
	//�������ļ���ȡ�������ĸ�ֵ
	static {
		ResourceBundle bundle=ResourceBundle.getBundle("dbconfig");
		//bundle��͵�����map������
		driverClass=bundle.getString("driverClass");
		url=bundle.getString("url");
		user=bundle.getString("user");
		password=bundle.getString("password");
		
		try {
			//ע������
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	public static void closeAll(ResultSet rs,Statement st,Connection conn) throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
	
	//Ҫ���ܹ�ֱ��ָ��һ����ѯ��sql��䣬ֱ�ӷ���һ��User����һ��List<User>�ͺ���
	//����Java������Ʋ�ѯ���ݿ�
	//���ز�ѯUser
	public User getUser(String sql,String username,String password) {
		User user=null;
		try {
			Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			//��һ���ɺϣ������Ϊ֮
			//1��������ֺ��������һ����
			//2�����е��ֶ��������еĳ�Ա��һ����
			Class<User> cls=User.class;
			Field [] fields= cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				//���ÿɼ��ԣ�ʹ��private��Ч��
				fields[i].setAccessible(true);
				
			}
			//��ѯ�Ľ����һ��ResultSet������������Ҫ����User
			if(rs!=null) {
				
				for (;rs.next();) {
					user=new User();
					//getColumnCount��ȡ�е�����
					for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
						//id,username,password,sex,age
						Object object=rs.getObject(fields[i].getName());
						fields[i].set(user, object);
					}
					
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	
	}
	
	public User getUser(String sql) {
		User user=null;
		try {
			Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			//��һ���ɺϣ������Ϊ֮
			//1��������ֺ��������һ����
			//2�����е��ֶ��������еĳ�Ա��һ����
			Class<User> cls=User.class;
			Field [] fields= cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				//���ÿɼ��ԣ�ʹ��private��Ч��
				fields[i].setAccessible(true);
				
			}
			//��ѯ�Ľ����һ��ResultSet������������Ҫ����User
			if(rs!=null) {
				user=new User();
				for (;rs.next();) {
					//getColumnCount��ȡ�е�����
					for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
						//id,username,password,sex,age
						Object object=rs.getObject(fields[i].getName());
						fields[i].set(user, object);
					}
					
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	
	
	
	
	
	
}
