package com.weapon.dao.impl;

import com.weapon.bean.User;
import com.weapon.dao.UserDao.UserDao1;
import com.weapon.utils.DBUtils;

public class UserDaoImpl implements UserDao1{

	@Override
	public User selectUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		User user=new DBUtils().getUser("select * from user where username=? and password=?",username,password);
		return user;
	}

}
