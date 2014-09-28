/**
 * 
 */
package firstSteps;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * @author Pier
 *
 */
public class HastaScrapeApplication extends Application {
	/**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of HastaScrapeResource.
        Router router = new Router(getContext());
        
        //come collegare vari percosi : in base al percorso invoco un classe resuource che fa cose differenti
        router.attach("/rest/hastaScrapeList",          HastaScrapeResource.class);
       // router.attach("/rest/todos/{annuncioId}", TodoResource.class);
        
        //qui definisco un solo percorso , qualsiasi url invoca la classe hastaScrapeResouce
        // Defines only one route
        // router.attachDefault(HastaScrapeResource.class);

        return router;
    }
}
