package it.pierpalab.hastascrape;


import it.pierpalab.hastascrape.beans.GoogleMapMarker;
import it.pierpalab.hastascrape.interfaces.MapManager;
import it.pierpalab.hastascrape.interfaces.MapMarker;
import it.pierpalab.hastascrape.scrapers.beans.Annuncio;
import it.pierpalab.hastascrape.scrapers.beans.Indirizzo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoogleMapManager implements MapManager {
	
	public GoogleMapManager(){
		
	}
	@Override
	public List<Annuncio> addMapMarkers(List<Annuncio> annunci) {
		//read address
		//create a marker
		//set to annuncio
		//add to list
		
		
		List<Annuncio> ret = new ArrayList<Annuncio>();
		for (Annuncio annuncio : annunci) {
			
			MapMarker mapMarker = mapMarkerByAddress(annuncio);
			annuncio.setMapMarker(mapMarker);
			ret.add(annuncio);
		}
		return ret;
	}

	private MapMarker mapMarkerByAddress(Annuncio annuncio) {
		//Call google api to geocoding
		//See https://developers.google.com/maps/documentation/geocoding/
		
		//FIXME remove this
		//genero valori random tra
		Indirizzo currAddr = annuncio.getIndirizzo();
		 double latitudine = getDoubleRandom(45.500919, 45.446750);
		 double longitudine = getDoubleRandom(9.138859, 9.228809);
		MapMarker mapMarker = new GoogleMapMarker(longitudine + "", latitudine + "", annuncio.getDescrzione());
		return mapMarker;
	}
	
	private double getDoubleRandom(double startValue, double endValue){
		double rand = new Random().nextDouble();
		return rand * (endValue - startValue) + startValue;
	}

	
	
}
