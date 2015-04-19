package it.pierpalab.hastascrape.interfaces;



import it.pierpalab.hastascrape.scrapers.beans.Annuncio;

import java.util.List;

public interface MapManager {
	public List<Annuncio> addMapMarkers(List<Annuncio> annunci);
	
}
