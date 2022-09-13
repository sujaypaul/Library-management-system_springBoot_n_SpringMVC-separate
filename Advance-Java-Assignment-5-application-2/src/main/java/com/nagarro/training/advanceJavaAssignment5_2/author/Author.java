package com.nagarro.training.advanceJavaAssignment5_2.author;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
	
	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String name) {
		super();
		this.name = name;
	}

}
