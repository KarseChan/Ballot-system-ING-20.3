package com.Karse.event.entity;

public class Order {
	private int id;  //编号
	private int content;  //订单内容，外键，连接赛事id
	private int number;   //购买票数
	private double price;  //支付金额
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
