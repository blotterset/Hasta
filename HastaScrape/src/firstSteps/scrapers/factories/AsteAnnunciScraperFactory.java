package firstSteps.scrapers.factories;

import firstSteps.scrapers.AsteAnnunciScraper;
import firstSteps.scrapers.Scraper;

public class AsteAnnunciScraperFactory extends ScraperFactory
{

	@Override
	public Scraper getInstance(String url) {
		Scraper ret = AsteAnnunciScraper.getInstance();
		ret.setUrlToParse(url);
		return ret;
	}

}
