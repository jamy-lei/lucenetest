package tup.lucene.queries;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonTestDemo1 {
    public static void main(String[] args) {
        JSONObject requestOrder = new JSONObject();
        Map<String,JSONArray> passenger = new HashMap<>();
        JSONArray detail = new JSONArray();
        for(int i = 0;i < 2;i++) {
            Map<String, String> detail1 = new HashMap<>();
            detail1.put("name", "Marcus/Tom");
            detail1.put("ageType", "0");
            detail1.put("gender", "M");
            detail1.put("cardType", "PP");
            detail1.put("cardExpired", "20250101");
            detail1.put("cardIssuePlace", "CN");
            detail1.put("nationality", "CN");
            detail.add(detail1);
        }
        requestOrder.put("passengers",detail);
        System.out.println(requestOrder.toString());
        Integer.parseInt("1");
        String[] a = new String[Integer.parseInt("10")];

        JSONObject routing = new JSONObject();
        JSONArray fromSegments = new JSONArray();
        routing.put("data","q");
        routing.put("fromSegments",fromSegments);
        JSONArray retSegments = new JSONArray();
        routing.put("retSegments",retSegments);


        String routingStr = routing.toString();
        System.out.println(routingStr);
        String content = " [{\"cabinClass\":3,\"carrier\":\"HX\",\"stopCities\":\"\",\"codeShare\":true,\"depTime\":\"201902131350\",\"aircraftCode\":\"320\",\"cabin\":\"Y\",\"arrAirport\":\"KHN\",\"depAirport\":\"HKG\",\"arrTime\":\"201902131540\",\"flightNumber\":\"HX270\"},{\"cabinClass\":3,\"carrier\":\"ZH\",\"stopCities\":\"\",\"codeShare\":true,\"depTime\":\"201902131935\",\"aircraftCode\":\"737\",\"cabin\":\"V\",\"arrAirport\":\"PEK\",\"depAirport\":\"KHN\",\"arrTime\":\"201902132205\",\"flightNumber\":\"ZH1578\"}]";

    }
}
