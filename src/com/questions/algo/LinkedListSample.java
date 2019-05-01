package com.questions.algo;

import java.util.Arrays;
import java.util.List;

public class LinkedListSample
{
    private Node head;
    private class Node
    {
        Node next;
        int data;
        public Node(int data)
        {
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
    public static void main(String args[])
    {
        LinkedListSample linkedListSample = new LinkedListSample();
        for (int i = 0; i < 10; i++)
        {
            linkedListSample.insert(i * 3);
        }
        linkedListSample.display();
        java.util.LinkedList<Integer> l = new java.util.LinkedList<>();

        List<Integer> ar = Arrays.asList(2, 4, 6, 8, 10);
        l.addAll(ar);
        System.out.println(l);
    }
}
