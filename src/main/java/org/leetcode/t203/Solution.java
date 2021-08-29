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
    public ListNode removeElements(ListNode head, int val) {
        // 循环指针
        ListNode currentNode = head;
        // 在循环过程中维护head
        while (currentNode != null) {
            // 无dummyHead处理
            if (currentNode == head && currentNode.val == val) {
                // 删除链表头结点
                head = head.next;
                currentNode = head;
            } else if (currentNode.next != null && currentNode.next.val == val) {
                // delete currentNode
                currentNode.next = currentNode.next.next;
                // side effect:循环指针自动后移一位 不需要手动在向后移动一位
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHeader = new ListNode(-1);
        dummyHeader.next = head;
        // 循环指针
        ListNode currentNode = dummyHeader;
        // 在循环过程中维护head
        while (currentNode != null) {
            if (currentNode.next != null && currentNode.next.val == val) {
                // delete currentNode
                currentNode.next = currentNode.next.next;
                // side effect:循环指针自动后移一位 不需要手动在向后移动一位
            } else {
                currentNode = currentNode.next;
            }
        }
        return dummyHeader.next;
    }
}
