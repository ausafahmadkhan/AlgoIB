package com.questions.algo;

public class RemoveNthLinkedList
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
    public Node remove(Node start, int n)
    {
        Node fast = start;
        for (int i = 0; i <= n; i++)
        {
            fast = fast.next;
            if (fast == null)
                return start.next;
        }
        Node slow = start;
        while (fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start;
    }
    public static void main(String args[])
    {
        RemoveNthLinkedList rem = new RemoveNthLinkedList();
        for (int i = 1; i < 6; i++)
        {
            rem.insert(i);
        }
        rem.display(rem.head);
        rem.display(rem.remove(rem.head, 6));
    }
}
