package org.leetcode.t20;

/**
 * @author LY
 * @date 2021/07/11 10:44
 * <p>
 * Description:
 */
class Solution {
    public boolean isValid(String s) {

        // 将括号分为两类 开始和结束
        // 遇到开始括号 压入栈中
        // 遇到结束括号 比较栈顶的是否与结束符合匹配
        // 匹配则继续、不匹配这返回false
        char[] stack = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                // 压栈
                stack[top] = c;
                top++;
            } else {
                if (top == 0) {
                    return false;
                }
                char topChar = stack[top - 1];
                // 检查栈顶
                if ((c == ')' && topChar == '(') |
                        (c == '}' && topChar == '{') |
                        (c == ']' && topChar == '[')) {
                    // 匹配成功 出栈
                    top--;
                } else {
                    return false;
                }

            }
        }
        return top <= 0;
    }
}