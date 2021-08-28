package org.leetcode.t203;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        // 循环指针
        ListNode currentNode = head;
        // 在循环过程中维护head
        while (currentNode != null) {
            // 无dummyHead处理
            if (currentNode == head && currentNode.val == val) {
                head = head.next;
            }
            if (currentNode.next.val == val) {
                // delete currentNode
                currentNode.next = currentNode.next.next;
                // side effect:循环指针自动后移一位 不需要手动在向后移动一位
            }
            currentNode = currentNode.next;
        }
        return head;
    }
}
