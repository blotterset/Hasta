/**
 * 
 */
package it.pierpalab.hastascrape.scrapers.factories;

import it.pierpalab.hastascrape.scrapers.Scraper;

/**
 * @author Pier
 * Base factory per la produzione di scraper
 */
public abstract class ScraperFactory {
	public abstract   Scraper getInstance(String url);
}
