package com.jana.designpattern.facade;

import java.util.Objects;

public class AuthenticationService {

	public boolean authenticate(String user) {
		//isBlank() introduced in java 11
		if (Objects.isNull(user) || user.isEmpty() || user.isBlank()) {
			System.out.println("User Authentication Failed.");
			return false;
		}
		System.out.println("User Authentication Successfull.");

		return true;

	}
}
