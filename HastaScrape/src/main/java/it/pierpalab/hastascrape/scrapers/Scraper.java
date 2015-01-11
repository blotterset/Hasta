package it.pierpalab.hastascrape.scrapers;

import it.pierpalab.hastascrape.beans.Annuncio;
import it.pierpalab.hastascrape.scrapers.factories.AsteAnnunciScraperFactory;
import it.pierpalab.hastascrape.scrapers.factories.ScraperFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Claasse astratta di base per gli scraper dei vari siti di aste
 * @author Pier
 *
 */
public abstract class  Scraper {
	public enum SitiSupportati{asteAnnunci}
	private static final Logger log = LogManager.getLogger(Scraper.class);
	
	public String nomeSito = "";
	protected String dateFormat = "dd/MM/yyyy HH:mm:ss";
	protected String urlToParse = "";
	
	
	
	/** Ritorna una lista di annunci. Riesce a indagare il sito giusto in base alla url
	 * @param url http che contine il sito e tutti i parametri di ricerca
	 * @return una lista di annunci o lista vuota
	 * @throws IOException
	 */
	public  static List<Annuncio> getAnnunciFrom(String url) throws IOException{
		
		/*template pattern
		 * alcuni passi dell'algoritmo sono dichiarati astratti e verranno implementati dalle sottoclassi
		 * */
		//ricavo lo scraper in base alla url
		ScraperFactory scraperFactory = getScraperFactory(url);
		Scraper aScraper = scraperFactory.getInstance(url);
		//estraggo gli annunci dalla pagina
		List<Annuncio> annunci = aScraper.scrape();
		return annunci;
	}
	
	
	private  static ScraperFactory getScraperFactory(String url){
		ScraperFactory aScraperFactory = null;
		if (url.contains("asteannunci.it"))
		{	
			aScraperFactory = new AsteAnnunciScraperFactory();
		}
		else
		{
			throw new UnsupportedOperationException(
					String.format("si sta cercando di creare "
					+ "uno scraper per un sito non supportato. "
					+ "Il sito che si vuole creare ha url : %s", url));
		}
		
		return aScraperFactory;
	}
	
	
	/**Le specializzazionui implementeranno questo metodo */
	protected abstract List<Annuncio> scrape() throws IOException ;
	
	
	
	protected Date parseDate(String dateString){
		if (dateString == null || dateString.isEmpty())
			return(Date.from(Instant.EPOCH));
		DateFormat formatter = new SimpleDateFormat(dateFormat);
		Date date;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			log.error(String.format("Problemi nel parsing della data %s ritorno la data minima, motivo %s", dateString, e));
			return(Date.from(Instant.EPOCH));
		}
		return date;
	}
	
	
	public String getNomeSito() {
		return nomeSito;
	}

	protected void setNomeSito(SitiSupportati nomeSito) {
		this.nomeSito = nomeSito.toString();
	}


	protected String getUrlToParse() {
		return urlToParse;
	}


	public void setUrlToParse(String urlToParse) {
		this.urlToParse = urlToParse;
	}
	
	
	
}
