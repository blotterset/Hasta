/**
 * 
 */
package firstSteps;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import firstSteps.beans.Annuncio;
import firstSteps.beans.Indirizzo;

/**
 * @author Pier
 *
 */
public class HastaScrapeResource extends ServerResource {
	
	private static final Logger log = Logger.getLogger(HastaScrapeResource.class);
	@Get
    public String represent() throws ResourceException, IOException {
		ClientResource clientResource = new ClientResource("http://www.asteannunci.it/aste-giudiziarie/elenco.php?Regione=4&T=&Provincia=MI&RangePrezzoDa=&RangePrezzoA=200000&Comune=F205&DataVendita=&CAP=&TipoProcedura=&I=&RGE=&RGE_anno=&TipoImmobile=&AE=&TIDettaglio=&AP=50&Q=&S=D3&H=1&tipologia_lotto=1&pagina=&numRisultatiPagina=649");
		Representation rapresentation = clientResource.get();
		InputStream pageReadInputStream = rapresentation.getStream();
		
		
		//call jsoup
		Document dom = Jsoup.parse(pageReadInputStream, null, "http://www.asteannunci.it");
		
		 Document.OutputSettings settings = dom.outputSettings();

		    settings.prettyPrint(true);
		    settings.escapeMode(Entities.EscapeMode.base);
		    

		
		//FIXME configurare log4j
		//log.info("dom letto : " + dom);
	Elements annunciNodes = dom.select("div[id^=asta_]");
	if (annunciNodes.size() == 0 )
	{
		System.out.println("Nessun annuncio trovato");
		return "Nessun annuncio trovato";
	}
	List<Annuncio> annunci = new ArrayList<Annuncio>();
	Annuncio annuncio;
	for (Element element : annunciNodes) {
		//System.out.println(element.toString());
		//System.out.println("------------------------------------------------------------------------");
		annuncio = parse(element);
		annunci.add(annuncio);
	}
	
	/*parsare
	<div id="asta_1024267">
    <div class="box_ricerca_top"></div>
    <div class="box_ricerca_centro">
    	<div class="box_ricerca_centro_sx" style="float:left;margin-left: 2px">
		    
    	<table class="scheda_elenco_sx" summary="elenco degli annunci trovati dalla presente ricerca e relativi dati generali" cellpadding="3" cellspacing="1">
        	<tbody><tr>
            	<th>Procedura</th>
            	<th>Tribunale</th>
            	<th>Tipologia</th>
            	<th>Quota</th>
            </tr>
        	<tr>
            	<td>
					<strong>
					692/2012                    Lotto 1	                </strong>
                </td>
            	<td>Milano&nbsp;</td>
                <td>Appartamento</td>
            	<td></td>
            </tr>
            <tr>
                <td valign="top">
                <div style="position: relative;">
				<img src="http://www.asteannunci.it/img/thumb_elenco.jpg" alt="nessuna miniatura per questo immobile" height="205" width="169">                                <img src="http://www.asteannunci.it/img/sfondo_img.png" class="sfondo_img_elenco" height="205" width="169">
                                </div>
                </td>
                <td colspan="3" valign="top"><p><strong>Milano (MI) </strong>Via F. De Sanctis   nr.16<br>Appartamento  ad  uso  abitazione  al  piano  2° </p></td>
            </tr>
        </tbody></table>
        </div>
        <div class="box_ricerca_centro_sx" style="float:left;">
    	<table class="scheda_elenco_dx" summary="elenco degli annunci trovati dalla presente ricerca e relativi dati generali" cellpadding="3" cellspacing="3">
        	            <tbody><tr>
            	<th colspan="2">Vendita senza Incanto</th>                
            </tr>
        	<tr>
                <td class="scheda_elenco_dx_td">Data e Ora</td>
                <td class="scheda_elenco_dx_td">Prezzo Base</td>
            </tr>
        	<tr>
                <td>11/11/2014 11:00:00</td>
                <td>€ 309.000,00</td>
            </tr>
                                            	            <tr>
            	<th colspan="2">Allegati</th>                
            </tr>
        	<tr>
            	<td colspan="2" style="padding: 0px;">
				                            <!-- BANDO -->
                            <div class="allegati"> <a class="Cbando" href="http://www.asteannunci.it/dl_pdf.php?id=2035828&amp;mod=att" title="scarica l'ordinanza di vendita, 1044 Kb in formato pdf [nc]" accesskey="B"><img src="http://www.asteannunci.it/img/button-ordinanza.jpg" alt="scarica l'ordinanza di vendita" class="tHide" height="92"></a></div>
                            <!-- ORDINANZA -->
              				               
                  
                              
		                                          
                            <!-- FOTO -->
              
                            <!-- ALTRO -->
              
                            <!-- VIDEO 	-->    
              
				             
                          
                </td>                
            </tr>
		</tbody></table>        
        </div>
    <div style="clear: left"></div>
      </div> 
      <div class="box_ricerca_bottom">
      <a href="http://www.asteannunci.it/aste-giudiziarie/scheda.php?id=1024267&amp;tipologia=Appartamento&amp;comune=Milano" title="apri la scheda dettagliata del lotto 1024267" accesskey="o" id="link_1024267" class="scheda_dettaglio_a">SCHEDA DETTAGLIATA</a>    <label for="lotticheck_2">  Seleziona per un confronto</label><input name="lotticheck" class="lotticheck" id="lotticheck_2" value="1024267" style="margin-top:10px;" type="checkbox"></div>     
    </div>
    
    */
	
	//ottenere oggeti annuncio piu coerenti
	
	
	//ricavare gli indirizzi
	
	//inserirli in googlemap
	
	StringBuilder retSb = new StringBuilder("Annunci trovati \n");
	for (Annuncio a : annunci) {
		retSb.append(a).append("\n").append("---").append("\n");
	}
		return retSb.toString();
    }

	private Annuncio parse(Element elementAnnuncio) {
		if (elementAnnuncio == null) {
			throw new IllegalArgumentException(
					"element di un annuncio passato nullo al partser");
		}
		Annuncio ret = new Annuncio();
		String tempStr = "";
		//id
		
		tempStr = elementAnnuncio.select("div[id^=asta_]").attr("id");
		String id = tempStr.substring(tempStr.lastIndexOf("asta_")+5);
		ret.setId(id);
		
		
		//procedura
		//tutti i tr
		Elements trs = elementAnnuncio.select("table.scheda_elenco_sx tbody tr");
		// il secondo tr (contiene procedura, tribunale
		 Element tr2 = trs.get(1);
		//il 1 td del 2 tr
		Elements tds = tr2.select("td");
		Element td1 = tds.get(0);
		Elements td1Strong = td1.select("strong");
		tempStr = td1Strong.html();
		
		
		ret.setProcedura(tempStr);
		
		
		//tribunale
		Element td2 = tds.get(1);
		tempStr = td2.html();
		ret.setTribunale(tempStr);
		
		
		//tipologia
		Element td3 = tds.get(2);
		tempStr = td3.html();
		ret.setTipologia(tempStr);
		
		//quota
		Element td4 = tds.get(3);
		tempStr = td4.html();
		ret.setQuota(tempStr);

		//3 tr contiene indirizo
		
		 Element tr3 = trs.get(2);
		 tds = tr3.select("td");
		 td2 = tds.get(1);
		 Elements paragrafi = td2.select("p");
		 Element p = paragrafi.get(0);
		 Elements strongElements = p.select("strong");
		 Element strong = strongElements.get(0);
		 String citta = strong.html();
		 Indirizzo indirizzo = new Indirizzo();
		 indirizzo.setCitta(citta);
		Node indirizzoNode = strong.nextSibling();
		String indirizzoStrRaw = indirizzoNode.toString();
		indirizzoStrRaw = indirizzoStrRaw.toLowerCase();
		String viaStr = "";
		//numero civico
		String nCivico = "";
		if (indirizzoStrRaw.contains("nr.")){
			viaStr = indirizzoStrRaw.substring(0, indirizzoStrRaw.lastIndexOf("nr."));
			nCivico = indirizzoStrRaw.substring(indirizzoStrRaw.lastIndexOf("nr.")+3);
		}
		indirizzo.setVia(viaStr);
		indirizzo.setnCivico(nCivico);
		System.out.println(indirizzoStrRaw + " --- " + viaStr + " --- " + nCivico);
		return ret;
	}
}