package com.dsa.algorithms.LinkedList;

import com.dsa.algorithms.LinkedList.LinkedListUtil.ListNode;
import static com.dsa.algorithms.LinkedList.LinkedListUtil.generateLinkedList;

public class MidPointOfLinkedList {

    public static ListNode midPointOfTheLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        head =  midPointOfTheLinkedList(head);
        System.out.println(head.val);
    }
}
