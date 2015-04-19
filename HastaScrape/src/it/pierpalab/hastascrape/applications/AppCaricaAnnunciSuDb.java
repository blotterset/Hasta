package it.pierpalab.hastascrape.applications;

import it.pierpalab.hastascrape.dao.DAO;
import it.pierpalab.hastascrape.dao.factories.DAOFactory;
import it.pierpalab.hastascrape.scrapers.beans.Annuncio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.restlet.engine.Engine;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class AppCaricaAnnunciSuDb extends ServerResource {

	@Inject
	private Logger log;

	@Get("json")
	public Representation represent() throws ResourceException, IOException {
		log.info("[AppCaricaAnnunciSuDb] Invocato salvataggio annunci su db");
		// imposto il converter da usare
		Engine.getInstance().getRegisteredConverters()
				.add(new JacksonConverter());
		// ricavare gli indirizzi
		// List<Annuncio> annunci =
		// Scraper.getAnnunciFrom("http://www.asteannunci.it/aste-giudiziarie/elenco.php?Regione=4&T=&Provincia=MI&RangePrezzoDa=&RangePrezzoA=200000&Comune=F205&DataVendita=&CAP=&TipoProcedura=&I=&RGE=&RGE_anno=&TipoImmobile=&AE=&TIDettaglio=&AP=50&Q=&S=D3&H=1&tipologia_lotto=1&pagina=&numRisultatiPagina=649");

		List<Annuncio> annunci = new ArrayList<>();

		StringBuilder retSb = new StringBuilder("Annunci trovati \n");
		for (Annuncio a : annunci) {
			retSb.append(a).append("\n").append("---").append("\n");
		}
		log.info("salvo annunci sul db...");
		DAO dao = DAOFactory.getInstance();
		return new JacksonRepresentation<>("salvati annunci sul db");
	}
}
