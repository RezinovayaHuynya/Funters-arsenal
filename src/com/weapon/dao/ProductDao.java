package com.weapon.dao;

import com.weapon.bean.PageBean_p;
import com.weapon.bean.Product;
import com.weapon.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
	public PageBean_p queryPageBean(int pageno,int pagesize) {
		//��η�ҳ��limit
		//select * from tbname where boolean1
		//group by columnname
		//having boolean2
		//order by columnname
		//limit ?,?
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from product limit ?,?";
		PageBean_p pageBean_p=new PageBean_p();
		try {
			List<Product> products=qr.query(sql, new BeanListHandler<Product>(Product.class),(pageno-1)*pagesize,pagesize);
			pageBean_p.setPageNo(pageno);
			pageBean_p.setPageSize(pagesize);
			pageBean_p.setProduct(products);
			//һ���ж���ҳ��
			Object object=qr.query("select count(*) from product", new ScalarHandler());
			long num=(Long)object;

			num=num/pagesize+(num%pagesize==0?0:1);
			pageBean_p.setPageSum(num);
			return pageBean_p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insertToProduct(String username,String weaponname,int number, String adress) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into product(username,weaponname,number,adress) values(?,?,?,?)";
		try {
			qr.update(sql,username,weaponname,number,adress);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateProduct(int id,String username,String weaponname,int number, String adress) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="update product set username=?,weaponname=?,number=?,adress=? where id=?";
		try {
			qr.update(sql,username,weaponname,number,adress,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteProduct(int id) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="delete from product where id=?";
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Product selectProduct(int id) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from product where id=?";
		try {
			return qr.query(sql, new BeanHandler<Product>(Product.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
