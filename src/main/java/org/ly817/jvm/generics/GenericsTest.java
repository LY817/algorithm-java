package org.ly817.jvm.generics;

import java.util.ArrayList;

/**
 * @author LY
 * @date 2021/08/24 16:05
 * <p>
 * Description:
 */
public class GenericsTest {
    public int foo() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int result = list.get(0);
        return result;
    }
}
