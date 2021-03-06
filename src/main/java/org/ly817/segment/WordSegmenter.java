package org.ly817.segment;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by LuoYu on 2021/7/1.
 *
 */
public interface WordSegmenter {
    /**
     * 获取文本的所有分词结果
     * @param text 文本
     * @return 所有的分词结果，去除重复
     */
    default public Set<String> seg(String text) {
        return segMore(text).values().stream().collect(Collectors.toSet());
    }
    /**
     * 获取文本的所有分词结果
     * @param text 文本
     * @return 所有的分词结果，KEY 为分词器模式，VALUE 为分词器结果
     */
    public Map<String, String> segMore(String text);
}
