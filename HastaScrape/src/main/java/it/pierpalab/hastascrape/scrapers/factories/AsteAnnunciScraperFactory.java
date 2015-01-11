package it.pierpalab.hastascrape.scrapers.factories;

import it.pierpalab.hastascrape.scrapers.AsteAnnunciScraper;
import it.pierpalab.hastascrape.scrapers.Scraper;

public class AsteAnnunciScraperFactory extends ScraperFactory
{

	@Override
	public Scraper getInstance(String url) {
		Scraper ret = AsteAnnunciScraper.getInstance();
		ret.setUrlToParse(url);
		return ret;
	}

}
