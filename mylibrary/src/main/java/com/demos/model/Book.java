package com.demos.model;

import java.time.LocalDate;

public class Book {
private int id;
private String name;
private LocalDate publishDate;
private float price;
private String authorName;
public Book(int id, String name, LocalDate publishDate, float price, String authorName) {
	super();
	this.id = id;
	this.name = name;
	this.publishDate = publishDate;
	this.price = price;
	this.authorName = authorName;
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
public LocalDate getPublishDate() {
	return publishDate;
}
public void setPublishDate(LocalDate publishDate) {
	this.publishDate = publishDate;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getAuthorName() {
	return authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
@Override
public String toString() {
	return "Book [id=" + id + ", name=" + name + ", publishDate=" + publishDate + ", price=" + price + ", authorName="
			+ authorName + "]";
}

}
