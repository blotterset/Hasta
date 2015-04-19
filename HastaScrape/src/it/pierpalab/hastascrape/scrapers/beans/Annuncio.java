package it.pierpalab.hastascrape.scrapers.beans;

import static it.pierpalab.hastascrape.utils.Utils.trim;
import it.pierpalab.hastascrape.interfaces.MapMarker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Annuncio {
	private String id;
	private String sito;
	private String baseUrl;
	private String procedura;
	private String tribunale;
	private String tipologia;
	private String quota;
	private Vendita vendita;
	private String descrzione;
	private List<String> allegati;
	private String urlSchedaDettagliata;
	private Indirizzo indirizzo;
	private Date dataAsta = new Date(1);
	private String prezzoBaseAsta;
	private String tipoDiVendita;
	private MapMarker mapMarker;

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

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Date getDataAsta() {
		return dataAsta;
	}

	public void setDataAsta(Date dataAsta) {
		this.dataAsta = dataAsta;
	}

	public String getPrezzoBaseAsta() {
		return prezzoBaseAsta;
	}

	public void setPrezzoBaseAsta(String prezzoBaseAsta) {
		this.prezzoBaseAsta = prezzoBaseAsta;
	}

	public String getTipoDiVendita() {
		return tipoDiVendita;
	}

	public void setTipoDiVendita(String tipoDiVendita) {
		this.tipoDiVendita = tipoDiVendita;
	}

	public void setMapMarker(MapMarker mapMarker) {
		this.mapMarker = mapMarker;

	}

	public MapMarker getMapMarker() {
		return mapMarker;
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
				.append(", indirizzo=").append(indirizzo).append(", dataAsta=")
				.append(dataAsta).append(", prezzoBaseAsta=")
				.append(prezzoBaseAsta).append(", tipoDiVendita=")
				.append(tipoDiVendita).append("]");
		return builder.toString();
	}

}
