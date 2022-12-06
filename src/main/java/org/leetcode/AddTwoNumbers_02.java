package org.leetcode;

import java.util.List;

public class AddTwoNumbers_02 {

    public static void main(String[] args) {
        ListNode node = new ListNode(2, new ListNode(4, new ListNode(9, null)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9, null))));

        addTwoNumbers(node, node2);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode tail = head;

        while (l1 != null || l2 != null) {
            if(l1 == null) {
                ListNode old = tail;
                tail = new ListNode();
                tail.val = l2.val % 10;
                if ((l2.val )/10 > 0) {
                    if (l2.next != null) {
                        l2.next.val += 1;
                    } if (l2.next == null) {
                        l2.next = new ListNode(1);
                    }
                }
                old.next = tail;
                l2 = l2.next;
            }  else  if (l2 == null) {
                ListNode old = tail;
                tail = new ListNode();
                tail.val = l1.val % 10;
                if ((l1.val )/10 > 0) {
                    if (l1.next != null) {
                        l1.next.val += 1;
                    }if (l1.next == null) {
                        l1.next = new ListNode(1);
                    }
                }
                old.next = tail;
                l1 = l1.next;
            } else {
                ListNode old = tail;
                tail = new ListNode();
                tail.val =  (l1.val + l2.val) % 10;
                if ((l1.val + l2.val)/10 > 0) {
                    if (l1.next != null) {
                        l1.next.val += 1;
                    }
                    if (l1.next == null && l2.next != null) {
                        l2.next.val += 1;
                    }
                    if (l1.next == null && l2.next == null) {
                        l2.next = new ListNode(1);
                    }
                }
                old.next = tail;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


