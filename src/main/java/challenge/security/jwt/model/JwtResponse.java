package challenge.security.jwt.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 4551839894790953711L;
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		
			this.jwttoken = jwttoken;
	}
	
	public String getToken() {
		
		return this.jwttoken;
	}
}
