package it.pierpalab.hastascrape.beans;

import static it.pierpalab.hastascrape.utils.Utils.trim;

public class Indirizzo {
	String via;
	String numeroCivico;
	String citta;
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = trim(via);
		if (via.isEmpty()){
			this.via = "piazza Duomo 1";
		}
	}
	
	public String getNumeroCivico() {
		return numeroCivico;
	}
	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = trim(citta);
	}
	
	
}
