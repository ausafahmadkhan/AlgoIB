package com.questions.algo;

public class DuplicateLinkedListII
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
    public Node remove(Node start)
    {
        int dup;
        Node prev = null, current = start;
        while (current != null && current.next != null)
        {
            if (current.val == current.next.val)
            {
                dup = current.val;
                while (current != null && current.val == dup)
                {
                    if (current == start) {
                        start = start.next;
                        current = start;
                    }
                    else
                    {
                        prev.next = current.next;
                        current = current.next;
                    }
                }
            }
            else
            {
                prev = current;
                current = current.next;
            }
        }
        return start;
    }
    public static void main(String args[])
    {
        DuplicateLinkedListII dup = new DuplicateLinkedListII();
        dup.insert(1);
        dup.insert(1);
        dup.insert(1);
        dup.insert(2);
        dup.insert(2);
        dup.insert(2);
        dup.insert(3);
        dup.insert(4);
        dup.insert(5);
        dup.insert(5);
        dup.insert(6);
        dup.insert(7);
        dup.insert(7);
        dup.display(dup.head);
        dup.display(dup.remove(dup.head));

    }
}
