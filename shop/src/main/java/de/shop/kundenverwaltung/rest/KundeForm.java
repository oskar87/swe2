package de.shop.kundenverwaltung.rest;

import javax.ws.rs.FormParam;

public class KundeForm {
	@FormParam("nachname")
	private String nachname;

	@FormParam("vorname")
	private String vorname;

	@FormParam("email")
	private String email;

	@FormParam("plz")
	private String plz;

	@FormParam("ort")
	private String ort;

	@FormParam("strasse")
	private String strasse;

	@FormParam("hausnummer")
	private String hausnummer;

	@FormParam("agb")
	private boolean agbAkzeptiert;
	
	@Override
	public String toString() {
		return "KundeForm [nachname=" + nachname + ", vorname=" + vorname
				+ ", email=" + email + ", plz=" + plz
				+ ", ort=" + ort + ", strasse=" + strasse + ", hausnummer="
				+ hausnummer + ", agbAkzeptiert=" + agbAkzeptiert + "]";
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnr) {
		this.hausnummer = hausnr;
	}

	public boolean isAgbAkzeptiert() {
		return agbAkzeptiert;
	}

	public void setAgbAkzeptiert(boolean agbAkzeptiert) {
		this.agbAkzeptiert = agbAkzeptiert;
	}
}
