package org.ly817.segment;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.StringUtils;

import java.util.List;
import java.util.Properties;

/**
 * @author LY
 * @date 2021/07/01 17:56
 * <p>
 * Description:
 */
public class StanfordNLPSeg {
    public static void main(String[] args) {
        segInCh("菲律宾");
    }


    public static void segInCh(String text){
        //载入properties 文件
        StanfordCoreNLP pipline = new StanfordCoreNLP("StanfordCoreNLP-chinese.properties");

        //1.2 自定义功能 （1）
//        Properties properties = new Properties();
//        properties.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
//        StanfordCoreNLP pipline = new StanfordCoreNLP(properties);

        //自定义功能(2) 自己在项目中建一个properties 文件，然后在文件中设置模型属性，可以参考1中的配置文件
//        String[] args = new String[] {"-props", "properies/CoreNLP-Seg-CH.properties"};
//        Properties properties = StringUtils.argsToProperties(args);
//        StanfordCoreNLP pipline = new StanfordCoreNLP(properties);

        //自定义功能(3)
        /*
        StanfordCoreNLP pipline = new StanfordCoreNLP(PropertiesUtils.asProperties(
                "annotators", "tokenize,ssplit",
                "ssplit.isOneSentence", "true",
                "tokenize.language", "zh",
                "segment.model", "edu/stanford/nlp/models/segmenter/chinese/ctb.gz",
                "segment.sighanCorporaDict", "edu/stanford/nlp/models/segmenter/chinese",
                "segment.serDictionary", "edu/stanford/nlp/models/segmenter/chinese/dict-chris6.ser.gz",
                "segment.sighanPostProcessing", "true"
        ));
        */
        //创建一个解析器，传入的是需要解析的文本
        Annotation annotation = new Annotation(text);

        //解析
        pipline.annotate(annotation);

        //根据标点符号，进行句子的切分，每一个句子被转化为一个CoreMap的数据结构，保存了句子的信息()
//        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        pipline.annotate(annotation);
        pipline.prettyPrint(annotation, System.out);
        //从CoreMap 中取出CoreLabel List ,打印
//        for (CoreMap sentence : sentences){
//            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)){
//                String word = token.get(CoreAnnotations.TextAnnotation.class);
//                System.out.println(word);
//            }
//        }
    }
}
