package ux.hackathon.reply.it.neartoyou.recommendations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ux.hackathon.reply.it.neartoyou.model.Recommendation;

/**
 * Created by c.rauso on 20/03/2016.
 */
public class RecommendationData {

    public static HashMap<String, List<Recommendation>> getData() {
        HashMap<String, List<Recommendation>> expandableListDetail = new HashMap<String, List<Recommendation>>();

        // restaurants
        List<Recommendation> restaurants = new ArrayList<Recommendation>();
        Recommendation toAdd = new Recommendation();
        toAdd.setName("Joia");
        toAdd.setDescription("Rinomato ristorante italiano noto per le specialità di mare.");
        toAdd.setLatitude(45.649283);
        toAdd.setLongitude(13.766630);
        if(Math.random() < 0.5) {
            restaurants.add(toAdd);
        }

        toAdd = new Recommendation();
        toAdd.setName("Sushi bar");
        toAdd.setDescription("Ottimo ristorante giapponese con cucina a vista.");
        toAdd.setLatitude(45.649486);
        toAdd.setLongitude(13.767011);
        restaurants.add(toAdd);

        // art
        List<Recommendation> monuments = new ArrayList<Recommendation>();
        toAdd = new Recommendation();
        toAdd.setName("Piazza Unità d'Italia");
        toAdd.setDescription("Piazza Unità d'Italia è la piazza principale di Trieste. Si trova ai piedi del colle di San Giusto, tra il Borgo Teresiano e Borgo Giuseppino.\n" +
                "Di pianta rettangolare, la piazza si apre da un lato sul Golfo di Trieste ed è circondata da numerosi palazzi ed edifici pubblici.");
        toAdd.setLatitude(45.650208);
        toAdd.setLongitude(13.767849);
        monuments.add(toAdd);

        toAdd = new Recommendation();
        toAdd.setName("Salone degli Incanti");
        toAdd.setDescription("L'ex mercato del pesce, riqualificato per accogliere mostre ed esposizioni.");
        toAdd.setLatitude(45.647868);
        toAdd.setLongitude(13.762226);
        monuments.add(toAdd);

        // leisure
        List<Recommendation> leisure = new ArrayList<Recommendation>();
        toAdd = new Recommendation();
        toAdd.setName("Night Club Mexico");
        toAdd.setDescription("Night club storico di Trieste, da provare almeno una volta.");
        toAdd.setLatitude(45.652148);
        toAdd.setLongitude(13.774474);
        leisure.add(toAdd);

        toAdd = new Recommendation();
        toAdd.setName("Streaming Discoteca");
        toAdd.setDescription("Discoteca dalla frequentazione molto variegata, appuntamento fisso del sabato triestino.");
        toAdd.setLatitude(45.656669);
        toAdd.setLongitude(13.804542);
        if(Math.random() < 0.5) {
            leisure.add(toAdd);
        }

        // museums
        List<Recommendation> museums = new ArrayList<Recommendation>();
        toAdd = new Recommendation();
        toAdd.setName("Museo Ferroviario");
        toAdd.setDescription("Il Museo ferroviario di Trieste Campo Marzio è un museo triestino dedicato alla storia delle ferrovie del Friuli e della Venezia Giulia, e i relativi mezzi di locomozione, personale, sistemi di manutenzione e gestione.");
        toAdd.setLatitude(45.646324);
        toAdd.setLongitude(13.755310);
        museums.add(toAdd);

        toAdd = new Recommendation();
        toAdd.setName("Civico museo sartorio");
        toAdd.setDescription("Il civico museo Sartorio si trova a Trieste. Custodisce arredi ed oggetti d'epoca, ceramiche, biblioteca, raccolte di quadri, disegni di Giambattista Tiepolo ed una gipsoteca-gliptoteca.");
        toAdd.setLatitude(45.646106);
        toAdd.setLongitude(13.763013);
        if(Math.random() < 0.5) {
            museums.add(toAdd);
        }
        // shopping
        List<Recommendation> shopping = new ArrayList<Recommendation>();
        toAdd = new Recommendation();
        toAdd.setName("Atelier Aimée Trieste");
        toAdd.setDescription("Storico negozio di abiti da sposa.");
        toAdd.setLatitude(45.647986);
        toAdd.setLongitude(13.764665);
        shopping.add(toAdd);

        toAdd = new Recommendation();
        toAdd.setName("Falconeri Maglieria e Abbigliamento in Cashmere");
        toAdd.setDescription("Negozio di abbigliamento, offre capi ricercati in un ambiente elegante.");
        toAdd.setLatitude(45.650401);
        toAdd.setLongitude(13.771431);
        shopping.add(toAdd);

        expandableListDetail.put("ART", monuments);
        expandableListDetail.put("LEISURE", leisure);
        expandableListDetail.put("MUSEUM", museums);
        expandableListDetail.put("RESTAURANTS", restaurants);
        expandableListDetail.put("SHOPPING", shopping);

        return expandableListDetail;
    }

}
