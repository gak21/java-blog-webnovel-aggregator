package com.webnovelscrossroads.service.impl;

import java.util.LinkedList;

import com.webnovelscrossroads.model.User;

public class UserWrapper extends LinkedList<User> {
	 private String title;

	 public UserWrapper(){
		 
	 }
	 
	public UserWrapper(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "UserWrapper [title=" + title + "]";
	}
}
