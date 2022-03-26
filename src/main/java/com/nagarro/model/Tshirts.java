package com.nagarro.model;

import javax.persistence.*;

@Entity
public class Tshirts {
	@Id
	private String ID;		//making ID a primary key
	private String name;
	private String color;
	private String gender;
	private String size;
	private float price;
	private float rating;
	private String availability;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String display() {
		if(getGender().equals("M"))
			return getID()+" "+getName()+" "+getColor()+" Male "+getSize()+" "+getPrice()+" "+getRating();
		
		else if(getGender().equals("F"))
			return getID()+" "+getName()+" "+getColor()+" Female "+getSize()+" "+getPrice()+" "+getRating();
		
		return getID()+" "+getName()+" "+getColor()+" Unisex "+getSize()+" "+getPrice()+" "+getRating();
	}
}
