package de.shop.kundenverwaltung.rest;

import java.net.URI;

import java.lang.invoke.MethodHandles;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;

import de.shop.kundenverwaltung.domain.Kunde;
import de.shop.util.Log;

@ApplicationScoped
@Log
public class UriHelperKunde {
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	public URI getUriKunde(Kunde kunde, UriInfo uriInfo) {
		final URI uri = uriInfo.getBaseUriBuilder()
		                       .path(KundeResource.class)
		                       .path(KundeResource.class, "findKundeById")
		                       .build(kunde.getId());
		return uri;
	}
	
	
	public void updateUriKunde(Kunde kunde, UriInfo uriInfo) {
		// URI fuer Bestellungen setzen
		URI uri = uriInfo.getBaseUriBuilder()
                         .path(KundeResource.class)
                         .path(KundeResource.class, "findBestellungenByKundeId")
                         .build(kunde.getId());
		kunde.setBestellungenUri(uri);

		uri = getUriDownload(kunde.getId(), uriInfo);
		kunde.setFileUri(uri);
		
		LOGGER.trace(kunde);
	}
	
	
	public URI getUriDownload(Long kundeId, UriInfo uriInfo) {
		final URI uri = uriInfo.getBaseUriBuilder()
		                       .path(KundeResource.class)
		                       .path(KundeResource.class, "download")
		                       .build(kundeId);
		return uri;
	}
}
