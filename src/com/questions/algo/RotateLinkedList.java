package com.questions.algo;

public class RotateLinkedList
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
    public int size(Node l)
    {
        if (l == null)
            return 0;
        int c = 0;
        Node temp = l;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }
    public Node rotate(Node start, int k)
    {
        int size = size(start);
        if (k == size)
            return start;
        if (k > size)
            k %= size;
        Node fast = start;
        for (int i = 0; i <= k; i++)
        {
            fast = fast.next;
            if (fast == null)
                return start;
        }
        Node slow = start;
        while (fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow = slow.next;
        fast.next = start;
        start = slow.next;
        slow.next = null;
        return start;
    }
    public static void main(String args[])
    {
        RotateLinkedList rotateLinkedList = new RotateLinkedList();
        for (int i = 1; i < 6; i++)
        {
            rotateLinkedList.insert(i);
        }
        rotateLinkedList.display(rotateLinkedList.head);
        rotateLinkedList.display(rotateLinkedList.rotate(rotateLinkedList.head, 23));
    }
}
