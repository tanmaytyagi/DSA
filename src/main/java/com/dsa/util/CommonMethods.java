package com.dsa.util;

import static com.dsa.algorithms.LinkedList.CycleDetectionInLinkedList.hasCycle;
import static com.dsa.algorithms.LinkedList.FindStartingPointOfCycle.findStartingPointOfCycle;

public class CommonMethods {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static ListNode generateLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        if(hasCycle(head)) {
            ListNode start = findStartingPointOfCycle(head);
            while(head != start) {
                System.out.print(head.val + " -> ");
                head = head.next;
            }
            System.out.print(start.val + " -> ");
            while (head.next != start) {
                head = head.next;
                System.out.print(head.val + " -> ");
            }
            System.out.println(start.val + " (prev)");
            return;
        }

        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
