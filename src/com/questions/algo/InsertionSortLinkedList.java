package com.questions.algo;

import java.util.Random;

public class InsertionSortLinkedList
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
    public  ListNode insSort(ListNode start)
    {
        ListNode beg = start, cur = start, nextCur = cur.next;
        ListNode dummy = new ListNode(0);
        dummy.next = start;
        ListNode prev = null;
        while (nextCur != null)
        {
            if (nextCur.val <= beg.val) {
                if (prev == null) {
                    dummy.next = nextCur;
                    cur.next = nextCur.next;
                    nextCur.next = beg;
                    beg = nextCur;
                    nextCur = cur.next;
                }
                else
                {
                    prev.next = nextCur;
                    cur.next = nextCur.next;
                    nextCur.next = beg;
                    beg = dummy.next;
                    prev = null;
                    nextCur = cur.next;
                }
            }
            else
            {
                while (nextCur.val > beg.val)
                {
                    prev = beg;
                    beg = beg.next;
                    if (nextCur == beg)
                    {
                        beg = dummy.next;
                        prev = null;
                        cur = nextCur;
                        nextCur = nextCur.next;
                        break;
                    }
                }
            }
        }
        return dummy.next;
    }
    public static void main(String args[])
    {
        InsertionSortLinkedList sortLinkedList = new InsertionSortLinkedList();
        Random r = new Random();
        for (int i = 0; i < 10; i++)
        {
            sortLinkedList.insert(r.nextInt(20));
        }
        sortLinkedList.display(sortLinkedList.head);
        sortLinkedList.display(sortLinkedList.insSort(sortLinkedList.head));
    }
}
