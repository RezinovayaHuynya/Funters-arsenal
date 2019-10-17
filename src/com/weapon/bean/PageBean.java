package com.weapon.bean;

import java.util.List;

public class PageBean {
	//ҳ��
	private long pageNo;
	//ҳ����
	private long pageSum;
	//��һҳ��Ӧ������
	private List<User> user;
	//ҳ�Ĵ�С
	private int pageSize;
	public long getPageNo() {
		return pageNo;
	}
	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}
	public long getPageSum() {
		return pageSum;
	}
	public void setPageSum(long pageSum) {
		this.pageSum = pageSum;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageBean [pageNo=" + pageNo + ", pageSum=" + pageSum + ", user=" + user + ", pageSize=" + pageSize
				+ "]";
	}
	
	
}
