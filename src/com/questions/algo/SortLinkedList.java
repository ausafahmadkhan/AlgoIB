package com.questions.algo;


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
    public ListNode sort(ListNode start)
    {

    }
}
