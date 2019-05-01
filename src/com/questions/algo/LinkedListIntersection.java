package com.questions.algo;

public class LinkedListIntersection
{
    private class ListNode
    {
        public int val;
        public ListNode next;
        ListNode(int x)
        {
            val = x; next = null;
        }
    }
    public int size(ListNode l)
    {
        if (l == null)
            return 0;
        int c = 0;
        ListNode temp = l;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        int size1, size2;
        size1 = size(l1);
        size2 = size(l2);
        if (size1 == 0 || size2 == 0)
            return null;
        int diff = Math.abs(size1 - size2);
        ListNode t1 = l1;
        ListNode t2 = l2;
        if (size1 > size2) {
            int i = 0;
            while (i < diff) {
                t1 = t1.next;
                i++;
            }
        } else {
            int i = 0;
            while (i < diff) {
                t2 = t2.next;
                i++;
            }
        }
        while (t1 != null && t2 != null) {
            if (t1.equals(t2))
                return t1;
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }
}
