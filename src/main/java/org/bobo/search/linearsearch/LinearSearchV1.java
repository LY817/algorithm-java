package org.bobo.search.linearsearch;

/**
 * @author LY
 * @date 2021/06/29 06:28
 * <p>
 * Description:
 * 课程2-2
 * for 循环遍历查询
 * 基本实现
 */
public class LinearSearchV1 {
    // 阻止外部创建对象
    private LinearSearchV1() {
    }

    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * 内部测试用例
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] data = {13, 455, 34, 5, 6, 45, 6457, 535, 3};
        search(data, 1);
        search(data, 222);
    }
}
