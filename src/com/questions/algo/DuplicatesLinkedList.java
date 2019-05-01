package com.questions.algo;

public class DuplicatesLinkedList
{
    private class ListNode
    {
        ListNode next;
        int val;
        public ListNode(int val)
        {
            this.val = val;
        }
    }
    public ListNode remove(ListNode start)
    {
        ListNode prev = start;
        ListNode next = start.next;
        while (next != null)
        {
            if (next.val == prev.val)
            {
                prev.next = next.next;
                next = next.next;
            }
            else
            {
                prev = next;
                next = next.next;
            }
        }
        return start;
    }
}
