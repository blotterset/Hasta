package firstSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;

import org.restlet.data.Range;

import firstSteps.beans.Annuncio;
import firstSteps.beans.GoogleMapMarker;
import firstSteps.beans.Indirizzo;
import firstSteps.interfaces.MapManager;
import firstSteps.interfaces.MapMarker;

public class GoogleMapManager implements MapManager {
	
	GoogleMapManager(){
		
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
