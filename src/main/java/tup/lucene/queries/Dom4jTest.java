package tup.lucene.queries;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Documented;
import java.util.List;

public class Dom4jTest {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("./pom.xml");
        String a = "<a></a>";
        SAXReader reader = new SAXReader();
        Document document = reader.read(fis);
        List ab = document.selectNodes("//project//dependency");
        for(Object ac : ab){
            System.out.println(a);
        }


//        String text = document.asXML();
//        System.out.println(text);
//        Element element = document.getRootElement();
//        System.out.println(element);
//        List<Element> childElement = element.elements();
//        for(Element child : childElement){
////            System.out.println("id" + child);
//            List<Attribute> attributes = child.attributes();
//            for(Attribute att: attributes){
//                System.out.println(att.getName() + ":" +att.getValue());
//            }
//            List<Element> elementList = child.elements();
//            for(Element e : elementList){
//                System.out.println(e.getName() + ":"+e.getStringValue());
//            }
//        }
    }

}
