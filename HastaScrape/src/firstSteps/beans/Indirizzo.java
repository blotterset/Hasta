package firstSteps.beans;

import static firstSteps.utils.Utils.trim;

public class Indirizzo {
	String via;
	String nCivico;
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
	public String getnCivico() {
		return nCivico;
	}
	public void setnCivico(String nCivico) {
		this.nCivico = trim(nCivico);
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = trim(citta);
	}
	
}
