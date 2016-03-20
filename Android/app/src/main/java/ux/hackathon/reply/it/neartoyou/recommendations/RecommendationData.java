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

        List<Recommendation> restaurants = new ArrayList<Recommendation>();

        Recommendation toAdd = new Recommendation();
        toAdd.setName("Joia");
        toAdd.setDescription("Rinomato ristorante italiano noto per le specialità di mare.");
        toAdd.setLatitude(45.650208);
        toAdd.setLongitude(13.767849);
        restaurants.add(toAdd);

        toAdd = new Recommendation();
        toAdd.setName("Sushi bar");
        toAdd.setDescription("Ottimo ristorante giapponese con cucina a vista.");
        toAdd.setLatitude(45.650208);
        toAdd.setLongitude(13.767849);
        restaurants.add(toAdd);

        List<Recommendation> monuments = new ArrayList<Recommendation>();
        toAdd = new Recommendation();
        toAdd.setName("Piazza Unità d'Italia");
        toAdd.setDescription("Piazza Unità d'Italia è la piazza principale di Trieste. Si trova ai piedi del colle di San Giusto, tra il Borgo Teresiano e Borgo Giuseppino.\n" +
                "Di pianta rettangolare, la piazza si apre da un lato sul Golfo di Trieste ed è circondata da numerosi palazzi ed edifici pubblici.");
        toAdd.setLatitude(45.650208);
        toAdd.setLongitude(13.767849);
        monuments.add(toAdd);

        toAdd = new Recommendation();
        toAdd.setName("Sala degli Incanti");
        toAdd.setDescription("Ex mercato del pesce.");
        toAdd.setLatitude(45.650208);
        toAdd.setLongitude(13.767849);
        monuments.add(toAdd);

        expandableListDetail.put("RESTAURANTS", restaurants);
        expandableListDetail.put("MONUMENTS", monuments);
        return expandableListDetail;
    }

}
