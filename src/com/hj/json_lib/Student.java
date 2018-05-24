package com.hj.json_lib;

import java.util.Arrays;

public class Student {
	private String name;
	private int age;
	private Book[] books;
	
	public Student() {
	}

	public Student(String name, int age, Book[] books) {
		this.name = name;
		this.age = age;
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", books=" + Arrays.toString(books) + "]";
	}
}
