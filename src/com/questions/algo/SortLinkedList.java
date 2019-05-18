package com.questions.algo;

import java.util.Random;

public class SortLinkedList
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
    public ListNode partition(ListNode start)
    {
        if (start.next == null) {
            return start;
        }
        else
        {
            ListNode slow = start;
            ListNode fast = start;
            if (fast.next.next != null) {
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
            }
            ListNode temp = slow.next;
            slow.next = null;
            ListNode start1 = partition(start);
            ListNode start2 = partition(temp);
            return mergeNodes(start1, start2);
        }
    }
    public ListNode mergeNodes(ListNode start1, ListNode start2)
{
        ListNode current1 = start1, current2 = start2, prev2 = null;
        while (current1 != null && current2 != null) {
            if (current1.val <= current2.val) {
                if (prev2 == null) {
                    prev2 = current1;
                    current1 = current1.next;
                    start2 = prev2;
                    prev2.next = current2;
                } else {
                    prev2.next = current1;
                    current1 = current1.next;
                    prev2.next.next = current2;
                    prev2 = prev2.next;
                }
            } else {
                while (current1.val > current2.val) {
                    prev2 = current2;
                    current2 = current2.next;
                    if (current2 == null)
                        break;
                }
            }
        }
        if (current2 == null && current1 != null) {
            prev2.next = current1;
        }
        return start2;
    }
    public ListNode merge(ListNode start1, ListNode start2)
    {
        if (start1 == null)
            return start2;
        if (start2 == null)
            return start1;
        if (start1.val < start2.val)
        {
            start1.next = merge(start1.next, start2);
            return start1;
        }
        else
        {
            start2.next = merge(start1, start2.next);
            return start2;
        }
    }
    public static void main(String args[])
    {
        SortLinkedList linkedList = new SortLinkedList();
        Random r = new Random();
        for (int i = 0; i < 11; i++)
        {
            linkedList.insert(r.nextInt(50));
        }
        linkedList.display(linkedList.head);
        linkedList.display(linkedList.partition(linkedList.head));
    }
}
