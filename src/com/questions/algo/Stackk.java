package com.questions.algo;

import java.util.NoSuchElementException;
import java.util.Random;

public class Stackk<T>
{
    private Node top;
    private class Node
    {
        Node next;
        T val;
        public Node(T val)
        {
            this.val = val;
        }
    }
    public boolean isEmpty()
    {
        return top == null;
    }
    public void push(T val)
    {
        Node temp = new Node(val);
        if (isEmpty())
        {
            top = temp;
        }
        else
        {
            temp.next = top;
            top  = temp;
        }
    }
    public T pop()
    {
        if (!isEmpty()) {
            T val = top.val;
            top = top.next;
            return val;
        }
        else
        {
            throw new NoSuchElementException();
        }
    }
    public void display()
    {
        while (!isEmpty())
        {
            T val = pop();
            System.out.print(val + " ");
        }
    }
    public static void main(String args[])
    {
        Stackk<Integer> s = new Stackk<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++)
        {
            s.push(r.nextInt(30));
        }
        s.display();
    }
}
