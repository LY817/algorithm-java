package org.ly817.segment;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by LuoYu on 2021/7/1.
 */
public class StanfordNLPSegmenterTest {
    public static void main(String[] args) {
        StanfordNLPSegmenter seg = new StanfordNLPSegmenter();
        Map<String, String> map = seg.segMore("非律宾");
        System.out.println(map);
    }
}