package com.Karse.event.entity;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.xml.crypto.Data;

public class Match {
	public int id;  //±àºÅ
	public String name;  //ÈüÊÂÃû
	public Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
