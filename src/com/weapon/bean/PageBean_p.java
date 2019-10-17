package com.weapon.bean;

import java.util.List;

public class PageBean_p {

	//ҳ��
	private long pageNo;
	//ҳ����
	private long pageSum;
	//��һҳ��Ӧ������
	private List<Product> product;
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
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageBean_p [pageNo=" + pageNo + ", pageSum=" + pageSum + ", product=" + product + ", pageSize=" + pageSize
				+ "]";
	}
	
	
}
