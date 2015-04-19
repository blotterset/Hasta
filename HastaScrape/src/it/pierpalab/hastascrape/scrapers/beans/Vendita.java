package it.pierpalab.hastascrape.scrapers.beans;

import java.util.Date;

public class Vendita {
String tipo;
String prezzoBase;
Date dataEOra;
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getPrezzoBase() {
	return prezzoBase;
}
public void setPrezzoBase(String prezzoBase) {
	this.prezzoBase = prezzoBase;
}
public Date getDataEOra() {
	return dataEOra;
}
public void setDataEOra(Date dataEOra) {
	this.dataEOra = dataEOra;
}

}
