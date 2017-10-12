package org.gestion.entite;

public class Login {
	
	private String email;
	
	private String motDePasse;

	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Login(String email) {
		super();
		this.email = email;
	}



	public Login(String email, String motDePasse) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	

}
