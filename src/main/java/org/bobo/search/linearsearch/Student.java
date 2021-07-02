package org.bobo.search.linearsearch;

import java.util.HashMap;

/**
 * @author LY
 * @date 2021/06/30 21:09
 * <p>
 * Description:
 * equals套路
 */
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        // 是否为同一个对象
        if (this == obj)
            return true;

        // 是否为空
        if (obj == null)
            return false;

        // 对象的class不相同
        if (this.getClass() != obj.getClass())
            return false;

        // 类型强转
        Student student = (Student) obj;
        // 定义自定义比较逻辑
        return this.name.equals(student.name);
    }
}
