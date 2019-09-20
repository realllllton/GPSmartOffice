package com.itsol.smartoffice.model;

import java.io.Serializable;

/**
 * Create Response to send token web
 *
 * @author thainguyen283
 */
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
