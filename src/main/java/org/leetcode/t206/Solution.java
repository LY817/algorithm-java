package org.leetcode.t206;

import org.leetcode.datastructure.ListNode;

/**
 * @author LY
 * @date 2021/09/02 08:53
 * <p>
 * Description:
 * 翻转链表
 */
class Solution {
    /**
     * 遍历链表实现 独立思考版本
     * 修改指针
     *
     * 思路很重要 在链表里面用冒泡 真的傻的冒泡
     * @param head
     * @return
     */
    public ListNode reverseList0(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode lastBubble = dummyHead.next;
        while (lastBubble != null) {
            // 冒泡
            ListNode thisBubble = dummyHead.next;
            while (thisBubble.next != null && thisBubble.next != lastBubble) {
                dummyHead = exchangeNextNode(dummyHead);
                thisBubble = thisBubble.next;
            }
            lastBubble = lastBubble.next;
        }
        return dummyHead.next;
    }

    /**
     * 基本方法 交换链表两个节点的位置
     * @param pev
     * @return
     */
    public ListNode exchangeNextNode(ListNode pev) {
        ListNode current = pev.next;
        ListNode nxt = pev.next.next;
        current.next = nxt.next;
        nxt.next = current;
        pev.next = nxt;
        return pev;
    }

    /**
     * 独立思考+思路提示
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pev = null;
        ListNode current = head;
        ListNode next = current.next;
        // current必须走到尾部 此时next == null
        // 还需要执行链表反向
        while (next != null) {
            // 翻转current指针
            current.next = pev;
            // 移动p/c/n
            pev = current;
            current = next;
            next = next.next;
        }
        // 在翻转一次current指针
        current.next = pev;
        return current;
    }
}
