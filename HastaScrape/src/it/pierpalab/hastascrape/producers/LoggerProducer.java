package it.pierpalab.hastascrape.producers;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;




public class LoggerProducer {

	@Produces
	public Object getLogger(InjectionPoint injectionPoint)
	{
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}
