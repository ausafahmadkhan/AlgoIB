package com.questions.algo;

import java.util.List;

public class ReversePairs
{
    private ListNode head;
    private class ListNode
    {
        ListNode next;
        int val;
        public  ListNode(int val)
        {
            this.val = val;
        }
    }
    public void display(ListNode start)
    {
        ListNode temp = start;
        while (temp.next != null)
        {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
    public void insert(int data)
    {
        ListNode temp = new ListNode(data);
        if (head == null)
        {
            head = temp;
        }
        else
        {
            ListNode t = head;
            while (t.next != null)
            {
                t = t.next;
            }
            t.next = temp;
        }
    }
    public ListNode reversePair(ListNode start)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = start;
        ListNode prev = dummy;
        ListNode cur = start;
        while (cur != null && cur.next != null)
        {
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
    public static void main(String args[])
    {
        ReversePairs p = new ReversePairs();
        for (int i = 0; i < 7; i++)
        {
            p.insert(i + 1);
        }
        p.display(p.head);
        p.display(p.reversePair(p.head));

    }
}
