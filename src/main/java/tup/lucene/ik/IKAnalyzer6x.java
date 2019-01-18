package tup.lucene.ik;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

public class IKAnalyzer6x extends Analyzer {
    private boolean useSmart;
    public boolean useSmart(){
        return useSmart;
    }
    public void setUseSmart(boolean useSmart){
        this.useSmart = useSmart;
    }
    public IKAnalyzer6x(){
        this(false);
    }
    public IKAnalyzer6x(boolean useSmart){
        super();
        this.useSmart = useSmart;
    }
    //重写最新版本的createComponents,重载Analyzer接口，构造分词组件
    @Override
    protected TokenStreamComponents createComponents(String fieldName){
        Tokenizer _IKTokenizer = new IKTokenizer6x(this.useSmart());
        return new TokenStreamComponents(_IKTokenizer);
    }

}
