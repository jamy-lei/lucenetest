package tup.lucene.queries;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class JsonTest {
    private static String arrival = "BJS";
    private static String origin = "HKG";
    private static  String adultsNum = "1";
    private  static String childrenNum = "0";
    private static String cabinClass = "Y";
    private static String confirmPara = "eyJjaWQiOiIxOXJZWGtJOWRKeG9CNmY1dHo0K2lkR1JCUkU9IiwicHJlY2lzZVByaWNpbmdEVE8iOnsiYWR1bHRzIjoxLCJjaGlsZHJlbiI6MCwiam91cm5leXMiOnsiam91cm5leV8wIjpbeyJhaXJsaW5lIjoiQ1giLCJhcnJpdmFsIjoiSEtHIiwiYXJyaXZhbERhdGUiOiIyMDE4LTEyLTI5IiwiYXJyaXZhbFRpbWUiOiIxMTo0NSIsImFycml2aW5nVGVybWluYWwiOiIxIiwiYm9va2luZ0NvZGUiOiJTIiwiZGVwYXJ0dXJlIjoiUEVLIiwiZGVwYXJ0dXJlRGF0ZSI6IjIwMTgtMTItMjkiLCJkZXBhcnR1cmVUZXJtaW5hbCI6IjMiLCJkZXBhcnR1cmVUaW1lIjoiMDg6MDAiLCJmbGlnaHROdW0iOiI1OTA1In1dfX19";

    private static String departureDate = LocalDate.now().plusDays(10).toString();
    public static void main(String[] args) {
        JSONObject shopping = new JSONObject();
        List<Object> tripList = new ArrayList<>();
        HashMap<String,String> originTrip =  new HashMap<>();
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        originTrip.put("fromCity",origin);
        originTrip.put("toCity",arrival);
        originTrip.put("date",departureDate);
        tripList.add(originTrip);
//        list.add(originTrip);
        System.out.println(originTrip);
        shopping.put("tripList",originTrip);
        shopping.put("adultsNum",adultsNum);
        shopping.put("childrenNum",childrenNum);
        shopping.put("cabinClass",cabinClass);
        System.out.println(shopping);

        JSONObject pricing = new JSONObject();
        pricing.put("tripList",originTrip);
        pricing.put("adultsNum",adultsNum);
        pricing.put("childrenNum",childrenNum);
        pricing.put("cabinClass",cabinClass);
        pricing.put("confirmPara",confirmPara);
        System.out.println(pricing);


        System.out.println("------------------------------------------------------");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int aftDay = (int)(Math.random()*100+1);
        System.out.println(aftDay);
        date.setDate(aftDay);
        String date1 = sdf.format(date);
        System.out.println(date1);

        System.out.println(date);
        System.out.println(date.getTime());
        String response = "{\n" +
                "  \"flights\": [\n" +
                "    {\n" +
                "      \"aircraftCode\": \"333\",\n" +
                "      \"at\": \"2019-03-18 12:35\",\n" +
                "      \"dst\": \"KIX\",\n" +
                "      \"dstt\": \"1\",\n" +
                "      \"dt\": \"2019-03-18 08:00\",\n" +
                "      \"fn\": \"JL7068\",\n" +
                "      \"id\": 1,\n" +
                "      \"meal\": \"0\",\n" +
                "      \"optfn\": \"CX562\",\n" +
                "      \"org\": \"HKG\",\n" +
                "      \"orgt\": \"1\",\n" +
                "      \"stops\": []\n" +
                "    },\n" +
                "    {\n" +
                "      \"aircraftCode\": \"320\",\n" +
                "      \"at\": \"2019-03-18 17:55\",\n" +
                "      \"dst\": \"PEK\",\n" +
                "      \"dstt\": \"\",\n" +
                "      \"dt\": \"2019-03-18 15:30\",\n" +
                "      \"fn\": \"JL5677\",\n" +
                "      \"id\": 2,\n" +
                "      \"meal\": \"0\",\n" +
                "      \"optfn\": \"MU526\",\n" +
                "      \"org\": \"KIX\",\n" +
                "      \"orgt\": \"2\",\n" +
                "      \"stops\": []\n" +
                "    }\n" +
                "  ],\n" +
                "  \"solutions\": [\n" +
                "    {\n" +
                "      \"fares\": [\n" +
                "        {\n" +
                "          \"adultPenalty\": {\n" +
                "            \"change\": {\n" +
                "              \"charges\": [\n" +
                "                {\n" +
                "                  \"fee\": 0,\n" +
                "                  \"from\": -525600,\n" +
                "                  \"to\": -2880\n" +
                "                },\n" +
                "                {\n" +
                "                  \"fee\": -1,\n" +
                "                  \"from\": -2880,\n" +
                "                  \"to\": 0\n" +
                "                }\n" +
                "              ],\n" +
                "              \"partEnable\": true,\n" +
                "              \"serviceCharge\": 446.0,\n" +
                "              \"usedEnable\": false\n" +
                "            },\n" +
                "            \"noshowChange\": {\n" +
                "              \"fee\": 446,\n" +
                "              \"minuteBeforeTakeOff\": 2880\n" +
                "            },\n" +
                "            \"noshowRefund\": {\n" +
                "              \"fee\": 446,\n" +
                "              \"minuteBeforeTakeOff\": 2880\n" +
                "            },\n" +
                "            \"refund\": {\n" +
                "              \"charges\": [\n" +
                "                {\n" +
                "                  \"fee\": -1,\n" +
                "                  \"from\": -525600,\n" +
                "                  \"to\": 525600\n" +
                "                }\n" +
                "              ],\n" +
                "              \"serviceCharge\": 446.0,\n" +
                "              \"usedEnable\": false\n" +
                "            }\n" +
                "          },\n" +
                "          \"adultPrice\": 2183,\n" +
                "          \"adultPrintPrice\": 2183,\n" +
                "          \"adultTax\": 91,\n" +
                "          \"cabins\": [\n" +
                "            {\n" +
                "              \"adultBaggage\": {\n" +
                "                \"allowedPieces\": 2,\n" +
                "                \"allowedWeight\": -1\n" +
                "              },\n" +
                "              \"bct\": \"Y\",\n" +
                "              \"childBaggage\": {\n" +
                "                \"allowedPieces\": 2,\n" +
                "                \"allowedWeight\": -1\n" +
                "              },\n" +
                "              \"ct\": \"H\",\n" +
                "              \"left\": \"2\",\n" +
                "              \"seq\": 0\n" +
                "            },\n" +
                "            {\n" +
                "              \"adultBaggage\": {\n" +
                "                \"allowedPieces\": 2,\n" +
                "                \"allowedWeight\": -1\n" +
                "              },\n" +
                "              \"bct\": \"Y\",\n" +
                "              \"childBaggage\": {\n" +
                "                \"allowedPieces\": 2,\n" +
                "                \"allowedWeight\": -1\n" +
                "              },\n" +
                "              \"ct\": \"Y\",\n" +
                "              \"left\": \"2\",\n" +
                "              \"seq\": 0\n" +
                "            }\n" +
                "          ],\n" +
                "          \"childPenalty\": {\n" +
                "            \"change\": {\n" +
                "              \"charges\": [\n" +
                "                {\n" +
                "                  \"fee\": 0,\n" +
                "                  \"from\": -525600,\n" +
                "                  \"to\": -2880\n" +
                "                },\n" +
                "                {\n" +
                "                  \"fee\": -1,\n" +
                "                  \"from\": -2880,\n" +
                "                  \"to\": 0\n" +
                "                }\n" +
                "              ],\n" +
                "              \"partEnable\": true,\n" +
                "              \"serviceCharge\": 446.0,\n" +
                "              \"usedEnable\": false\n" +
                "            },\n" +
                "            \"noshowChange\": {\n" +
                "              \"fee\": 446,\n" +
                "              \"minuteBeforeTakeOff\": 2880\n" +
                "            },\n" +
                "            \"noshowRefund\": {\n" +
                "              \"fee\": 446,\n" +
                "              \"minuteBeforeTakeOff\": 2880\n" +
                "            },\n" +
                "            \"refund\": {\n" +
                "              \"charges\": [\n" +
                "                {\n" +
                "                  \"fee\": -1,\n" +
                "                  \"from\": -525600,\n" +
                "                  \"to\": 525600\n" +
                "                }\n" +
                "              ],\n" +
                "              \"serviceCharge\": 446.0,\n" +
                "              \"usedEnable\": false\n" +
                "            }\n" +
                "          },\n" +
                "          \"childPrice\": 1678,\n" +
                "          \"childPrintPrice\": 1678,\n" +
                "          \"childTax\": 76,\n" +
                "          \"currency\": \"EUR\",\n" +
                "          \"orderPara\": \"a6e4b66b-1012-4309-b94a-a0a11760f575-hbgj\",\n" +
                "          \"productTag\": 0,\n" +
                "          \"productType\": \"C2P\",\n" +
                "          \"tags\": 2,\n" +
                "          \"ticketTime\": 2.0\n" +
                "        }\n" +
                "      ],\n" +
                "      \"requestTrips\": [\n" +
                "        {\n" +
                "          \"date\": \"2019-03-18\",\n" +
                "          \"flights\": [\n" +
                "            1,\n" +
                "            2\n" +
                "          ],\n" +
                "          \"fromCity\": \"HKG\",\n" +
                "          \"toCity\": \"PEK\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": 0\n" +
                "}";
        JSONObject responseJson = JSON.parseObject(response);
//        String content = responseJson.getString("tripList.fromCity".toString());
//        System.out.println(content);

        String flights = String.valueOf(JSONPath.read(response,"$.flights"));
        System.out.println(flights);
        String[] filt = flights.split("},");
        ArrayList flight = new ArrayList(Arrays.asList(flights.split("},")));
        String a = String.valueOf(JSONPath.read(flights,"$[0].dt")).split(" ")[0];
        System.out.println(a);
        System.out.println(flight.size());
//        String str ="1,2,3,4,5";
//        ArrayList<String> b =  new ArrayList<>(Arrays.asList( str.split(",")));
//        System.out.println(b.size());
    }
}
