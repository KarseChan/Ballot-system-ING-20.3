package com.Karse.event.entity;

public class Order {
	public int id;  //���
	public int content;  //�������ݣ��������������id
	public int number;   //����Ʊ��
	public double price;  //֧�����
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
