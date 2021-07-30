package com.mbb.ib.model;

public class AuthResponse {

	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthResponse(String jwt) {
		this.jwt = jwt;
	}
}
