package com.questions.algo;


public class PartitionLinkedList
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
    public ListNode partition(ListNode start, int k)
    {
        ListNode start1 = null, start2 = null;
        ListNode head1 = null, head2 = null;
        while (start != null)
        {
            if (start.val < k)
            {
                if (start1 == null)
                {
                    start1 = start;
                    head1 = start1;
                }
                else
                {
                    start1.next = start;
                    start1 = start1.next;
                }

            }
            else
            {
                if (start2 == null)
                {
                    start2 = start;
                    head2 = start2;
                }
                else
                {
                    start2.next = start;
                    start2 = start2.next;
                }
            }
            start = start.next;
        }
        if (start1 == null)
            return head2;
        if (start2 == null)
            return head1;
        start2.next = null;
        start1.next = head2;
        return head1;
    }
    public static void main(String args[])
    {
        PartitionLinkedList part = new PartitionLinkedList();
        /*for (int i = 10; i > 0; i--)
        {
            part.insert(i);
        }*/
        part.insert(1);
        part.insert(4);
        part.insert(3);
        part.insert(2);
        part.insert(5);
        part.insert(2);
        part.display(part.head);
        part.display(part.partition(part.head, 7));
    }
}
