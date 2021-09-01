package org.leetcode.t203;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LuoYu on 2021/8/29.
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void removeElements2Test() {
        ListNode head = new ListNode(new int[]{1,2,6,3,4,5,6});
        head = solution.removeElements2(head,6 );
        System.out.println(head);
    }
    @Test
    public void removeElements2Test7() {
        ListNode head = new ListNode(new int[]{7,7,7,7});
        head = solution.removeElements2(head,7);
        System.out.println(head);
    }
}