package com.questions.algo;

public class MergeLinkedLists
{
    private Node head;
    private class Node
    {
        Node next;
        int val;
        public Node(int val)
        {
            this.val = val;
        }
    }
    public void insert(int data)
    {
        Node temp = new Node(data);
        if (head == null)
        {
            head = temp;
        }
        else
        {
            Node t = head;
            while (t.next != null)
            {
                t = t.next;
            }
            t.next = temp;
        }
    }
    public void display(Node start)
    {
        Node temp = start;
        while (temp.next != null)
        {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
    public Node merge(Node start1, Node start2)
    {
        Node current1 = start1, current2 = start2, prev2 = null;
        while (current1 != null && current2 != null)
        {
            if (current1.val <= current2.val)
            {
                if (prev2 == null)
                {
                    prev2 = current1;
                    current1 = current1.next;
                    start2 = prev2;
                    prev2.next = current2;
                }
                else
                {
                    prev2.next = current1;
                    current1 = current1.next;
                    prev2.next.next = current2;
                    prev2 = prev2.next;
                }
            }
            else
            {
                while (current1.val > current2.val)
                {
                    prev2 = current2;
                    current2 = current2.next;
                    if (current2 == null)
                        break;
                }
            }
        }
        if (current2 == null && current1 != null)
        {
            prev2.next = current1;
        }
        return start2;
    }
    public static void main(String args[])
    {
        MergeLinkedLists mergeLinkedLists1 = new MergeLinkedLists();
        MergeLinkedLists mergeLinkedLists2 = new MergeLinkedLists();
        for (int i = 1; i < 6; i++)
        {
            mergeLinkedLists1.insert(i);
            mergeLinkedLists2.insert(i + 2);
        }
        mergeLinkedLists1.insert(8);
        mergeLinkedLists1.insert(10);
        mergeLinkedLists1.display(mergeLinkedLists1.head);
        mergeLinkedLists2.display(mergeLinkedLists2.head);
        mergeLinkedLists1.display(mergeLinkedLists1.merge(mergeLinkedLists1.head, mergeLinkedLists2.head));
    }
}
