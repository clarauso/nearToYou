package ux.hackathon.reply.it.neartoyou.recommendations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by c.rauso on 20/03/2016.
 */
public class RecommendationData {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> restaurants = new ArrayList<String>();
        restaurants.add("Joia");
        restaurants.add("Sushi bar");

        List<String> monuments = new ArrayList<String>();
        monuments.add("Piazza Unità d'Italia");
        monuments.add("Sala degli Incanti");

        expandableListDetail.put("RESTAURANTS", restaurants);
        expandableListDetail.put("MONUMENTS", monuments);
        return expandableListDetail;
    }

}
