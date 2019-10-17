package com.weapon.service.impl;

import com.weapon.bean.User;
import com.weapon.dao.UserDao.UserDao1;
import com.weapon.dao.impl.UserDaoImpl;
import com.weapon.service.UserService;
//MVC  ģ��-��ͼ-������(����ҵ���߼����������ݳ־û������ʾ����ͼ����)
//ҵ���߼���ʵ���������ݳ־ò㡣
public class UserServiceImpl implements UserService{

	private UserDao1 userDao1=new UserDaoImpl();
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user=userDao1.selectUserByUsernameAndPassword(username, password);
		return user;
		
	}

}
