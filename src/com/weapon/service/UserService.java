package com.weapon.service;

import com.weapon.bean.User;

//Serviceҵ���߼���
//ҵ���߼�������׿��κε����ݿ⡢�������󡭡�������̸
//����������û�ʹ�õ�ʱ����߼�ȥ���巽����
public interface UserService {
	//��¼��ҵ���߼�
	User login(String username,String password);
}
