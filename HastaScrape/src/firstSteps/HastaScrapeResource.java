/**
 * 
 */
package firstSteps;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import firstSteps.beans.Annuncio;
import firstSteps.interfaces.MapManager;
import firstSteps.scrapers.Scraper;

/**
 * @author Pier
 *
 */
public class HastaScrapeResource extends ServerResource {
	
	private static final Logger log = Logger.getLogger(HastaScrapeResource.class);
	
	
	
	@Get("json")
    public Representation represent() throws ResourceException, IOException {
		
			
	List<Annuncio> annunci = Scraper.getAnnunciFrom("http://www.asteannunci.it/aste-giudiziarie/elenco.php?Regione=4&T=&Provincia=MI&RangePrezzoDa=&RangePrezzoA=200000&Comune=F205&DataVendita=&CAP=&TipoProcedura=&I=&RGE=&RGE_anno=&TipoImmobile=&AE=&TIDettaglio=&AP=50&Q=&S=D3&H=1&tipologia_lotto=1&pagina=&numRisultatiPagina=649");
	
	//ricavare gli indirizzi
	
	//inserirli in googlemap
	
	StringBuilder retSb = new StringBuilder("Annunci trovati \n");
	for (Annuncio a : annunci) {
		retSb.append(a).append("\n").append("---").append("\n");
	}
	//valorizzo i marker della mappa
	
	MapManager mapManager = new GoogleMapManager();
		mapManager.addMapMarkers(annunci);
	
	return new JacksonRepresentation<>(annunci);
    }

	
	
	
}