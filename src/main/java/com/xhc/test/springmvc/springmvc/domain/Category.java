package com.xhc.test.springmvc.springmvc.domain;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7637694419363217200L;

	private int id;
	private String name;
	
	
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
}
