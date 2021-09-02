package org.leetcode.t203;

import org.leetcode.datastructure.ListNode;

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
    /**
     * 解法1 暴力循环
     * @param head
     * @param val
     * @return
     */
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

    /**
     * 解法2 dummyHead解决head维护问题
     * @param head
     * @param val
     * @return
     */
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

    /**
     * 解法3 使用递归调用来解决
     * - 定义元问题
     *   一个节点的链表，如果与val相等 就让他消失
     *   消失必须操作前一个node的指针
     * - 退出条件
     *
     * - 分解链表 最终分解到只有一个node
     *   关键是改写指针
     *   return的head是服务于递归的最小方法
     *   -
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        recursive(head,val);
        return head;
    }

    /**
     * 递归的错误示范
     * 1.递归方法的名字起的就有问题:recursive，应该声明一个"明确"目标的语义
     * 2.函数的返回值赋值作为递归函数，将子问题"回归"到原问题的方式
     * @param head
     * @param val
     * @return
     */
    private ListNode recursive(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 头部处理
        if (head.val == val) {
            head = head.next;
        } else {

            if (head.next == null) {
                return head;
            }
            if (head.next.val == val) {
                // 删除后一个节点
                head.next = head.next.next;
            }
            if (head.next == null) {
                return head;
            }
        }
        // 拆分链表 表节点和后面的子链表
        // 这个return不能实现问题的"等价"，所以这个递归怎么写都是有问题的
        return recursive(head.next,val);
    }

    /**
     * 递归正确示范 独立思考版
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        // 返回的是删除指定元素后的链表
        // 拆解原则：head节点 和 head后面的节点
        // 解决问题
        // - head这个节点是否需要被删除
        // - 拼上后面的链表
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }
        head.next = removeElements3(head.next,val);
        return head;
    }
}
