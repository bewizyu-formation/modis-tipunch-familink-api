package org.gestion.entite;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class Token {

	private String corps;

	private boolean isValide;

	public Token() {
		super();
	}

	public Token(int idUtilisateur) {
		super();
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public String creerToken(int idUtilisateur) {

		try {

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			Date date = new Date();

			date.setTime(timestamp.getTime());

			String formattedDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
			String aCoder = Integer.toString(idUtilisateur) + "-" + formattedDate;
			corps = Base64.getEncoder().encodeToString(aCoder.getBytes("utf-8"));

			return corps;

		} catch (Exception e) {

		} finally {

			return corps;
		}

	}

	public String creerToken() {

		try {

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			Date date = new Date();
			date.setTime(timestamp.getTime());

			String formattedDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

			String aCoder = formattedDate;
			corps = "1-" + Base64.getEncoder().encodeToString(aCoder.getBytes("utf-8"));

			return corps;

		} catch (Exception e) {

			System.out.println("Error :" + e.getMessage());

		} finally {
			return corps;
		}
	}

	public boolean tokenIsValide(String monToken) {

		isValide = true;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

		try {
			
			byte[] base64decodedBytes = Base64.getDecoder().decode(monToken);
			String monTokenDecode = new String(base64decodedBytes, "utf-8");
			String[] parts = monTokenDecode.split("-");

			
			try {
				Date date = new Date();
				date.setTime(date.getTime());
				String formattedDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
				Date date1 = formatter.parse(formattedDate);
				
				Date date2 = formatter.parse(parts[1]);
				date2.setTime(date2.getTime()+ 10 * 60 * 1000);

				return isValide = (date1.before(date2));

			} catch (Exception e) {
				isValide = false;
				System.out.println(e.getMessage());
			}

		} catch (UnsupportedEncodingException e) {
			isValide = false;
			System.out.println("Error :" + e.getMessage());
		}
		return isValide;
	}

}
