package org.ly817.segment;

import edu.stanford.nlp.io.NullOutputStream;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author LY
 * @date 2021/07/01 16:59
 * <p>
 * Description:
 */
public class StanfordNLPSegmenter implements WordSegmenter{
    private static final StanfordCoreNLP CTB = new StanfordCoreNLP("StanfordCoreNLP-chinese-ctb");
    private static final StanfordCoreNLP PKU = new StanfordCoreNLP("StanfordCoreNLP-chinese-pku");
    private static final PrintStream NULL_PRINT_STREAM = new PrintStream(new NullOutputStream(), false);

    @Override
    public Map<String, String> segMore(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("Stanford Beijing University segmentation", seg(PKU, text));
        map.put("Stanford Chinese Treebank segmentation", seg(CTB, text));
        return map;
    }

    private static String seg(StanfordCoreNLP stanfordCoreNLP, String text){
        PrintStream err = System.err;
        System.setErr(NULL_PRINT_STREAM);
        Annotation document = new Annotation(text);
        stanfordCoreNLP.annotate(document);
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        StringBuilder result = new StringBuilder();
        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);;
                result.append(word).append(" ");
            }
        }
        System.setErr(err);
        return result.toString();
    }
}
