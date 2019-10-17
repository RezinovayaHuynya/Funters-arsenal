package com.weapon.bean;

public class Product {
	private int id;
	private String username;
	private String weaponname;
	private int number;
	private String adress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getWeaponname() {
		return weaponname;
	}
	public void setWeaponname(String weaponname) {
		this.weaponname = weaponname;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", username=" + username + ", weaponname=" + weaponname + ", number=" + number + ", adress=" + adress
				+ "]";
	}
	
	
}
