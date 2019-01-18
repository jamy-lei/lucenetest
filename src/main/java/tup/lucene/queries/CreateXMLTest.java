package tup.lucene.queries;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;
import sun.misc.BASE64Encoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.font.GlyphJustificationInfo;
import java.io.File;
import java.io.StringReader;
import java.util.*;

public class CreateXMLTest {
    public static void main(String[] args) throws Exception {
        String response = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<payVerifyRequest>\n" +
                "\t<orderID>918121520053644099</orderID>\n" +
                "\t<hbgjOrderID>181021634127638</hbgjOrderID>\n" +
                "\t<settlePrice>287.0</settlePrice>\n" +
                "\t<flightSegments>\n" +
                "\t\t <flightSegment>\n" +
                "          <departCityCode>PEK</departCityCode>\n" +
                "          <arriveCityCode>HKG</arriveCityCode>\n" +
                "          <flyno>CA6523</flyno>\n" +
                "          <cabin>Q</cabin>\n" +
                "          <chdCabin>Q</chdCabin>\n" +
                "          <price>341</price>\n" +
                "          <chdPrice>0.0</chdPrice>\n" +
                "          <rateFee>24</rateFee>\n" +
                "          <airportFee>0.0</airportFee>\n" +
                "          <chdRateFee>0.0</chdRateFee>\n" +
                "          <chdAirportFee>0.0</chdAirportFee>\n" +
                "          <baseCabin>Y</baseCabin>\n" +
                "          <flydate>2018-12-29</flydate>\n" +
                "          <arrdate>2018-12-30</arrdate>\n" +
                "          <deptime>21:10</deptime>\n" +
                "          <arrtime>00:45</arrtime>\n" +
                "          <tripType>OB</tripType>\n" +
                "          <tripSeq>1</tripSeq>\n" +
                "        </flightSegment>\n" +
                "        <flightSegment>\n" +
                "          <departCityCode>PEK</departCityCode>\n" +
                "          <arriveCityCode>HKG</arriveCityCode>\n" +
                "          <flyno>CA6523</flyno>\n" +
                "          <cabin>Q</cabin>\n" +
                "          <chdCabin>Q</chdCabin>\n" +
                "          <price>341</price>\n" +
                "          <chdPrice>0.0</chdPrice>\n" +
                "          <rateFee>24</rateFee>\n" +
                "          <airportFee>0.0</airportFee>\n" +
                "          <chdRateFee>0.0</chdRateFee>\n" +
                "          <chdAirportFee>0.0</chdAirportFee>\n" +
                "          <baseCabin>Y</baseCabin>\n" +
                "          <flydate>2018-12-29</flydate>\n" +
                "          <arrdate>2018-12-30</arrdate>\n" +
                "          <deptime>21:10</deptime>\n" +
                "          <arrtime>00:45</arrtime>\n" +
                "          <tripType>OB</tripType>\n" +
                "          <tripSeq>1</tripSeq>\n" +
                "        </flightSegment>\n" +
                "\t</flightSegments>\n" +
                "\t<extraData>eyJjaWQiOiIxOXJZWGtJOWRKeG9CNmY1dHo0K2lkR1JCUkU9In0=</extraData>\n" +
                "</payVerifyRequest>";
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("payVerifyRequest");
        Element orderID = root.addElement("orderID");
        Element hbgjOrderID = root.addElement("hbgjOrderID");
        Element settlePrice = root.addElement("settlePrice");
        Element flightSegments = root.addElement("flightSegments");

        flightSegments.addText("11111");
        settlePrice.setText("22222");

        String text = document.asXML();
        System.out.println(text);


        String a = new BASE64Encoder().encodeBuffer(text.getBytes());
        System.out.println(a);

        JSONObject cancel = new JSONObject();
        Map<String,Map<String,String>> authentication= new HashMap<>();
        Map<String,String> param = new HashMap<>();
        param.put("partnerId","XuZF80s14JnXjuCB3Mxgf0WCujU=");
        param.put("sign","a1e9c8f9fc753c47d7433664a743f09b");
        authentication.put("authentication",param);
        Map<String,Map<String,String>> cancelParam = new HashMap<>();
        Map<String,String> cancelAdults = new HashMap<>();
        cancelAdults.put("orderNum","1187751430");
        cancelAdults.put("virtualPnr","QT85HJ");
        cancelParam.put("cancel",cancelAdults);
        cancel.putAll(authentication);
        cancel.putAll(cancelParam);
        String t = cancel.toString();
//        String t1 = new BASE64Encoder().encodeBuffer(t.getBytes());
        String encode = Base64.getUrlEncoder().encodeToString(t.getBytes());


        System.out.println(encode);






//        File fis = new File("./text.xml");
//        SAXReader reader = new SAXReader();
//        Document document = reader.read(response);

//        Document document = DocumentHelper.parseText(response);
//        List<Element> e = document.selectNodes("/payVerifyRequest/flightSegments");
//        Element gen = document.getRootElement();
//        Element flight = gen.element("flightSegments");
////        Element flightSegment = flight.element("flightSegment");
////        List<Element>  nodes = flightSegment.elements();
//        List<Element> nodes = flight.selectNodes("//flightSegment");
//
//        for(Iterator iterator  = nodes.iterator();iterator.hasNext();){
//            Element element = (Element) iterator.next();
//            System.out.println(element.getName());
//            System.out.println(element.getStringValue());
//           List <Element> flights1 = element.elements();
//           for(Iterator iterator1 = flights1.iterator();iterator1.hasNext();){
//               Element element1 = (Element) iterator1.next();
//               System.out.println(element1.getName());
//           }
//        }


//        List<Element> fiss = flight.elements("flightSegment");
//        for (int i = 0; i < fiss.size(); i++) {
//            Element a = fiss.get(i);
//            System.out.println(a.getName());
//        }


//        Document d = DocumentHelper.createDocument();
//        Element root = d.addElement("root");
//         Element clas = root.addElement("clas");
//        for(Element c : nodes){
//            Element a = clas.addElement(c.getName());
//            a.addText(c.getStringValue());
//        }
////
//        for(Element a : e){
//        Element c = root.addElement(a.getName());
//        c.addText(a.getStringValue());
////    }
//        String x = root.asXML();
//        System.out.println(x);
//}
    }
}
