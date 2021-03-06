package tup.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import tup.lucene.ik.IKAnalyzer6x;

import java.io.IOException;
import java.io.StringReader;

public class ExtDictTest {
    private static String str = "厉害了我的哥！中国环保部门即将发布治理北京雾霾的方法！";

    public static void main(String[] args) throws IOException {
        Analyzer analyzer = null;
        analyzer = new IKAnalyzer6x(true);
        StringReader reader = new StringReader(str);
        TokenStream tokenStream = analyzer.tokenStream(str,reader);
        tokenStream.reset();
        CharTermAttribute termAttribute = tokenStream.getAttribute(CharTermAttribute.class);
        while (tokenStream.incrementToken()){
            System.out.print(termAttribute.toString()+"|");
        }
        System.out.println("\n");
        analyzer.close();
    }
}
