package com.questions.algo;

import com.sun.javafx.scene.NodeHelper;

public class ReverseLinkedList
{
    private Node head;
    private class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
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
    public void display()
    {
        Node temp = head;
        while (temp.next != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    public Node reverse(Node start)
    {
        Node p1 = start, p2 = start, p3 = start;
        if (p1.next == null)
            return start;
        else if (p1.next.next == null)
        {
            p2 = p1.next;
            p2.next = p1;
            p1.next = null;
            head = p2;
            return p2;
        }
        while (p2 != null)
        {
            if (p1 == p2 && p2 == p3)
            {
                p2 = p1.next;
                p3 = p2.next;
                p1.next = null;
            }
            else
            {
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                if (p2 == null)
                {
                    head = p1;
                    break;
                }
                p3 = p3.next;
            }
        }
        return head;
    }
    public static void main(String args[])
    {
        ReverseLinkedList reverse = new ReverseLinkedList();
        for (int i = 1; i < 2; i++)
        {
            reverse.insert(i);
        }
        reverse.display();
        reverse.reverse(reverse.head);
        reverse.display();
    }
}
