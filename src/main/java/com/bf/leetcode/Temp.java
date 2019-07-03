package com.bf.leetcode;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Temp {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy, p1 = l1, p2 = l2;
        int carrier = 0;
        while (p1 != null || p2 != null || carrier != 0) {
            int sum = 0;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            sum += carrier;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carrier = sum / 10;
        }
        return dummy.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0, sum;
        ListNode head = new ListNode(0);
        ListNode ln1 = l1, ln2 = l2, node = head;

        while (carry != 0 || ln1 != null || ln2 != null) {
            sum = carry; // reset sum to value of carry

            if (ln1 != null) {
                sum += ln1.val;
                ln1 = ln1.next;
            }
            if (ln2 != null) {
                sum += ln2.val;
                ln2 = ln2.next;
            }

            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }
        return head.next;
    }
}

