package tup.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import tup.lucene.ik.IKAnalyzer6x;

import java.io.IOException;
import java.io.StringReader;

public class IkSmartcn {
    private static String str = "公路局正在治理解放大道路面积积水问题";
    private static String str2 = "IKAnalyzer是一个开源的，基于java语言开发的轻量级的中文分词工具包";

    public static void main(String[] args) throws IOException{
        Analyzer analyzer = null;
        System.out.println("句子一："+str);
        System.out.println("SmartChineseAnalyzer分词结果：");
        analyzer = new SmartChineseAnalyzer();
        IkSmartcn.printAnalyzer(analyzer,str);
        System.out.println("IKAnalyzer分词结果：");
        analyzer = new IKAnalyzer6x(true);
        IkSmartcn.printAnalyzer(analyzer,str);
        System.out.println("---------------------");
        System.out.println("句子二："+str2);
        System.out.println("SmartChineseAnalyzer分词结果：");
        analyzer = new SmartChineseAnalyzer();
        IkSmartcn.printAnalyzer(analyzer,str2);
        System.out.println("IKAnalyzer分词结果：");
        analyzer = new IKAnalyzer6x(true);
        IkSmartcn.printAnalyzer(analyzer,str2);
        analyzer.close();

    }
    public static void printAnalyzer(Analyzer analyzer,String str)throws IOException {
        StringReader reader = new StringReader(str);
        TokenStream tokenStream = analyzer.tokenStream(str,reader);
        tokenStream.reset();
        CharTermAttribute toAttribute = tokenStream.getAttribute(CharTermAttribute.class);
        while (tokenStream.incrementToken()){
            System.out.print(toAttribute.toString()+"|");
        }
        System.out.println("\n");
    }
}
