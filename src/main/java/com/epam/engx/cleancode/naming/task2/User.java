package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;

public class User {

	private boolean isAdmin = false;

	private final String dateOfBirth;

	private final String name;

	private final User[] subordinates;

	private int rating;

	public User(String name, String dateOfBirth, User[] subordinates) {
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.subordinates = subordinates;
	}

	protected boolean isAdmin() {
		return isAdmin;
	}

	protected void setAdmin(boolean admin) {
		this.isAdmin = admin;
	}

	@Override
	public String toString() {
		return "User [dateOfBirth=" + dateOfBirth + ", name=" + name + ", isAdmin=" + isAdmin + ", subordinates="
				+ Arrays.toString(subordinates) + ", rating=" + rating + "]";
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
