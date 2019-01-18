package tup.lucene.ik;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;

public class IKTokenizer6x extends Tokenizer {
    //IK分词器实现
    private IKSegmenter _IKImplement;
    //词元文本属性
    private final CharTermAttribute termAtt;
    //词元位移属性
    private final OffsetAttribute offsetAtt;
    //词元分类属性
    //(该属性分类参考分类常量)
    private final TypeAttribute typeAtt;
    //记录最后一个词元的结束位置
    private int endPosition;
    //Lucene 6x构造函数
    public IKTokenizer6x(boolean userSmart){
        super();
        offsetAtt = addAttribute(OffsetAttribute.class);
        termAtt = addAttribute(CharTermAttribute.class);
        typeAtt = addAttribute(TypeAttribute.class);
        _IKImplement  = new IKSegmenter(input,userSmart);
    }
    @Override
    public boolean incrementToken()throws IOException {
        clearAttributes();
        Lexeme nextLexeme = _IKImplement.next();
        if(nextLexeme !=null){
            //将Lexeme转换为attribute
            termAtt.append(nextLexeme.getLexemeText());         //设置词元文本
            termAtt.setLength(nextLexeme.getLength());          //设置词元长度
            offsetAtt.setOffset(nextLexeme.getBeginPosition(),nextLexeme.getEndPosition());          //设置词元的位移
            //记录分词的最后位置
            endPosition = nextLexeme.getEndPosition();
            typeAtt.setType(nextLexeme.getLexemeText());          //设置词元分类
            return true;
        }
        return false;                 //返回false告知词元输出完毕
    }
    @Override
    public void reset()throws IOException{
        super.reset();
        _IKImplement.reset(input);
    }
    @Override
    public final void end(){
        int finalOffset = correctOffset(this.endPosition);
        offsetAtt.setOffset(finalOffset,finalOffset);
    }
}
