package com.nirallan.db2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="BOOK_TBL")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Double bookPrice;
	
	
	public Book() {
		super();
	}


	public Book(int id, String name, Double bookPrice) {
		super();
		this.id = id;
		this.name = name;
		this.bookPrice = bookPrice;
	}


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


	public Double getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
}
