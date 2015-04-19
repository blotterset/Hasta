package it.pierpalab.hastascrape.applications;

import it.pierpalab.hastascrape.GoogleMapManager;
import it.pierpalab.hastascrape.interfaces.MapManager;
import it.pierpalab.hastascrape.scrapers.Scraper;
import it.pierpalab.hastascrape.scrapers.beans.Annuncio;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class AppMostraAnnunci extends ServerResource {

	@Inject
	Logger log;

	@Get("json")
	public Representation represent() throws ResourceException, IOException {
		// ricavare gli indirizzi
		List<Annuncio> annunci = Scraper
				.getAnnunciFrom("http://www.asteannunci.it/aste-giudiziarie/elenco.php?Regione=4&T=&Provincia=MI&RangePrezzoDa=&RangePrezzoA=200000&Comune=F205&DataVendita=&CAP=&TipoProcedura=&I=&RGE=&RGE_anno=&TipoImmobile=&AE=&TIDettaglio=&AP=50&Q=&S=D3&H=1&tipologia_lotto=1&pagina=&numRisultatiPagina=649");
		// la url per invocare l'app è http://localhost:8080/HastaScrape
		// salvataggio su db

		// inserirli in googlemap

		StringBuilder retSb = new StringBuilder("Annunci trovati \n");
		for (Annuncio a : annunci) {
			retSb.append(a).append("\n").append("---").append("\n");
		}
		// aggiungo agli annunci informazioni sul marker della mappa
		MapManager mapManager = new GoogleMapManager();
		annunci = mapManager.addMapMarkers(annunci);

		return new JacksonRepresentation<>(annunci);
	}

}
