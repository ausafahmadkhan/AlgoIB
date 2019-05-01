package com.questions.algo;

public class PalindromicLinkedList
{
    private Node left;
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
    public void display(Node start)
    {
        Node temp = start;
        while (temp.next != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
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
    public int lPalin(Node right)
    {
        left = right;
        return isPalin(right) ? 1 : 0;
    }
    public boolean isPalin(Node right)
    {
        if (right == null)
            return true;
        if (!isPalin(right.next))
            return false;
        System.out.println(left.data + " " + right.data);
        if (left.data != right.data)
            return false;
        left = left.next;
        return true;
    }
    public Node reverse(Node start)
    {
        Node prev = null, current = start, next;
        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current = prev;
        return current;
    }
    public Node mid(Node start)
    {
        Node slow = start, fast = start;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public int isPalindrome(Node start)
    {
        Node mid = mid(start);
        Node start2 = mid.next;
        System.out.println(mid.data);
        System.out.println(start2.data);
        mid.next = null;
        start2 = reverse(start2);
        while (start != null && start2 != null)
        {
            if (start.data != start2.data)
                return 0;
            start = start.next;
            start2 = start2.next;
        }
        return 1;
    }

    public static void main(String args[])
    {
        PalindromicLinkedList palindromicLinkedList = new PalindromicLinkedList();
//        for (int i = 0; i < 5; i++)
//        {
//            palindromicLinkedList.insert(i + 1);
//        }
//        for (int i = 5; i > 0; i--)
//        {
//            palindromicLinkedList.insert(i);
//        }
        palindromicLinkedList.insert(1);
        palindromicLinkedList.insert( 2);
        palindromicLinkedList.insert(1);
        palindromicLinkedList.display(palindromicLinkedList.head);
        System.out.println(palindromicLinkedList.isPalindrome(palindromicLinkedList.head));
    }
}
