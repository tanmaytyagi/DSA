package com.dsa.algorithms.LinkedList;

import static com.dsa.algorithms.LinkedList.LinkedListUtil.*;

public class MergeKSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }

        while(l1 != null) {
            temp.next = l1;
            temp = l1;
            l1 = l1.next;
        }

        while(l2 != null) {
            temp.next = l2;
            temp = l2;
            l2 = l2.next;
        }

        return head.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = lists[0];
        for(int i = 1 ; i < lists.length; i++) {
            ListNode l2 = lists[i];
            head = mergeTwoLists(head, l2);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode[] list = new ListNode[3];
        list[0] = generateLinkedList(new int[]{1, 4, 5});
        list[1] = generateLinkedList(new int[]{1, 3, 4});
        list[2] = generateLinkedList(new int[]{2, 6});

        ListNode head = mergeKLists(list);

        printLinkedList(head);
    }
}
