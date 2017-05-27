package jian.com.demo;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.miscellaneous.LengthFilter;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKTokenizer;

/**
 * Date: 2017年4月11日 下午4:22:44
 * 
 * @author Jihan
 */
public class CompanyAnalyzer extends Analyzer {

    // useSmart 当为true时，分词器进行智能切分,false 默认细粒度切分算法
    private boolean useSmart;

    public boolean useSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public CompanyAnalyzer() {
        this(false);
    }

    public CompanyAnalyzer(boolean useSmart) {
        super();
        this.useSmart = useSmart;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
        IKTokenizer ikTokenizer = new IKTokenizer(reader, useSmart());

        TokenStream tokenStream = new WhitespaceTokenizer(null, reader);

        // TokenStreamComponents tokenStreamComponents = new TokenStreamComponents(ikTokenizer);
        // TokenStream tokenStream = tokenStreamComponents.getTokenStream();

        tokenStream = new LengthFilter(Version.LUCENE_3_1, tokenStream, 3, Integer.MAX_VALUE);
        return new TokenStreamComponents(ikTokenizer, tokenStream);
    }

    public static void main(String[] args) {
        Analyzer a = new CompanyAnalyzer();
        try {
            TokenStream tokenStream = a.tokenStream("fieldName", new StringReader("中华人民共和国"));
            while (tokenStream.incrementToken()) {
                System.out.println("token:" + tokenStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
