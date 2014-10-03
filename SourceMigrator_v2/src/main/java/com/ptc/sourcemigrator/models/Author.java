package com.ptc.sourcemigrator.models;

public class Author {
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	private long id;
	private String name;
	private String email;
	
	
	public Author() {
		
	}
	
	public Author(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
