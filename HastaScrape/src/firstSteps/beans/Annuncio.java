package firstSteps.beans;

import static firstSteps.utils.Utils.trim;

import java.util.ArrayList;
import java.util.List;
public class Annuncio {
	String id;
	String sito;
	String baseUrl;
	String procedura;
	String tribunale;
	String tipologia;
	String quota;
	Vendita vendita;
	String descrzione;
	List<String> allegati;
	String urlSchedaDettagliata;
	Indirizzo indirizzo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = trim(id);
	}
	
	public String getSito() {
		return sito;
	}
	public void setSito(String sito) {
		this.sito = trim(sito);
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = trim(baseUrl);
	}
	public String getProcedura() {
		return procedura;
	}
	public void setProcedura(String procedura) {
		this.procedura = trim(procedura);
	}
	public String getTribunale() {
		return tribunale;
	}
	public void setTribunale(String tribunale) {
		this.tribunale = trim(tribunale);
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = trim(tipologia);
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = trim(quota);
	}
	public Vendita getVendita() {
		return vendita;
	}
	public void setVendita(Vendita vendita) {
		this.vendita = vendita;
	}
	public String getDescrzione() {
		return descrzione;
	}
	public void setDescrzione(String descrzione) {
		this.descrzione = trim(descrzione);
	}
	public List<String> getAllegati() {
		return allegati;
	}
	public void setAllegati(List<String> allegati) {
		if (allegati == null)
			this.allegati = new ArrayList<String>();
		else
			this.allegati = allegati;
	}
	public String getUrlSchedaDettagliata() {
		return urlSchedaDettagliata;
	}
	public void setUrlSchedaDettagliata(String urlSchedaDettagliata) {
		this.urlSchedaDettagliata = trim(urlSchedaDettagliata);
	}
	
	
	
	
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Annuncio [id=")
				.append(id)
				.append(", sito=")
				.append(sito)
				.append(", baseUrl=")
				.append(baseUrl)
				.append(", procedura=")
				.append(procedura)
				.append(", tribunale=")
				.append(tribunale)
				.append(", tipologia=")
				.append(tipologia)
				.append(", quota=")
				.append(quota)
				.append(", vendita=")
				.append(vendita)
				.append(", descrzione=")
				.append(descrzione)
				.append(", allegati=")
				.append(allegati != null ? allegati.subList(0,
						Math.min(allegati.size(), maxLen)) : null)
				.append(", urlSchedaDettagliata=").append(urlSchedaDettagliata)
				.append("]");
		return builder.toString();
	}
	
}
