package com.skilldistillery.xmasList.controllers;

import javax.validation.constraints.NotNull;

public class XmasListIdForm {

	@NotNull
	private Integer id;
	
	public XmasListIdForm() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
}
