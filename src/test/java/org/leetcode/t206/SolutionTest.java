package org.leetcode.t206;

import org.junit.Test;
import org.leetcode.datastructure.ListNode;

/**
 * @author LY
 * @date 2021/09/02 16:53
 * <p>
 * Description:
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void removeElements2Test() {
        ListNode head = new ListNode(new int[]{1, 2, 3});
        System.out.println(head);
        head = solution.reverseList2(head);
        System.out.println(head);
    }
}
