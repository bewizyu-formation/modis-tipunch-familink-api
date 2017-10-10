package org.gestion.entite;

import java.util.Base64;

public class Login {
	
	private String ation;
	
	private String description;
	
	private String token;

	public Login() {
		super();
	}

	public Login(String ation, String description, String token) {
		super();
		this.ation = ation;
		this.description = description;
		this.token = token;
	}

	public String getAtion() {
		return ation;
	}

	public void setAtion(String ation) {
		this.ation = ation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public void creerToken(int idUtilisateur) {
		String aCoder = Integer.toString(idUtilisateur);
		//String encoded = Base64.getEncoder().encodeToString(idUtilisateur);
		
		//int[] encodedBytes = Base64.encode(aCoder.getBytes());
	    //return new String(encodedBytes, Charset.forName("UTF-8"));
//		String encodedString = new String(Base64.encodeBase64(aCoder.getBytes()));
//		String decodedString = new String(Base64.decodeBase64(encodedString.getBytes()));

	}
	

}
