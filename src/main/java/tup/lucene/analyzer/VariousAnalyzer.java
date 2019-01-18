package tup.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import javax.swing.*;
import java.io.StringReader;

public class VariousAnalyzer {
    private static String str = "中华人民共和国简称中国，是一个有13亿人口的打大国家";

    public static void main(String[] args) throws Exception{
        Analyzer analyzer = null;
        analyzer = new StandardAnalyzer();   //标准分词
        System.out.println("标准分词结果："+analyzer.getClass());
        printAnalyzer(analyzer);
        analyzer = new WhitespaceAnalyzer(); //空格分词
        System.out.println("空格分词："+analyzer.getClass());
        printAnalyzer(analyzer);
        analyzer = new SimpleAnalyzer();
        System.out.println("简单分词："+analyzer.getClass());   //简单分词
        printAnalyzer(analyzer);
        analyzer = new CJKAnalyzer();
        System.out.println("二分法分词："+analyzer.getClass());  //二分法分词
        printAnalyzer(analyzer);
        analyzer = new KeywordAnalyzer();   //关键字分词
        System.out.println("关键字分词："+ analyzer.getClass());
        printAnalyzer(analyzer);
        //analyzer = new StopAnalyzer();
    }
    public static void printAnalyzer(Analyzer analyzer)throws Exception{
        StringReader reader = new StringReader(str);
        TokenStream tokenStream = analyzer.tokenStream(str,reader);
        tokenStream.reset();           //清空流
        CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
        while(tokenStream.incrementToken()){
            System.out.print(charTermAttribute.toString()+"|");
        }
        System.out.println("\n");
        analyzer.close();
    }
}
