/**
 * 
 */
package it.pierpalab.hastascrape;

import it.pierpalab.hastascrape.applications.AppCaricaAnnunciSuDb;
import it.pierpalab.hastascrape.applications.AppMostraAnnunci;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.engine.Engine;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.routing.Router;

/**
 * @author Pier
 * Questa è la classe che si occupa del routing delle richieste (controller)
 */
public class HastaScrapeApplication extends Application {
	/**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of AppMostraAnnunci.
        Router router = new Router(getContext());
        //come collegare vari percosi : in base al percorso invoco un classe resuource che fa cose differenti
        router.attach("/rest/hastaScrapeList",          AppMostraAnnunci.class);
        router.attach("/rest/hastaScrapeCaricaAnnunciSuDb",          AppCaricaAnnunciSuDb.class);
       // router.attach("/rest/todos/{annuncioId}", TodoResource.class);
        //qui definisco un solo percorso , qualsiasi url invoca la classe hastaScrapeResouce
         //router.attachDefault(AppMostraAnnunci.class);
         
       //imposto il converter da usare
     	Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
     	
        return router;
    }
}
