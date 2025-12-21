package com.dsa.datastructure.linkedlist;

import com.dsa.util.CommonMethods;
import com.dsa.util.ListNode;

public class MidPointOfLinkedList {

    public static ListNode midPointOfTheLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = CommonMethods.generateLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        head =  midPointOfTheLinkedList(head);
        System.out.println(head.val);
    }
}
