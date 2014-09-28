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

        // Defines only one route
        router.attachDefault(HastaScrapeResource.class);

        return router;
    }
}
