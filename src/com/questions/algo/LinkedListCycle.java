package com.questions.algo;

import java.util.Random;

public class LinkedListCycle
{
    private int size;
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
        size++;
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
    public ListNode hasCycle(ListNode start)
    {
        ListNode fast = start, slow = start;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                return slow;
            }
        }
        return null;
    }
    public ListNode getIntersection(ListNode start1, ListNode start2)
    {
        ListNode temp = start1;
        int size1 = 0, size2 = 0;
        while (temp != null)
        {
            temp = temp.next;
            size1++;
        }
        temp = start2;
        while (temp != null)
        {
            temp = temp.next;
            size2++;
        }
        ListNode cur1 = start1, cur2 = start2;
        if (size1 > size2)
        {
            int i = 0, l = size1 - size2;
            while (i < l)
            {
                cur1 = cur1.next;
                i++;
            }
        }
        else if (size2 > size1)
        {
            int i = 0, l = size2 - size1;
            while (i < l)
            {
                cur2 = cur2.next;
                i++;
            }
        }
        while (cur1 != null && cur2 != null)
        {
            if (cur1 == cur2)
                return cur1;
            else
            {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        return null;
    }
    public ListNode getCycleNode(ListNode start)
    {
        ListNode cycle = hasCycle(start);
        if (cycle == null)
            return null;
        ListNode temp = cycle.next;
        cycle.next = null;
        temp = getIntersection(start, temp);
        return temp;
    }
    public void createCycle(ListNode start)
    {
        ListNode fast = start;
        while (fast.next != null)
        {
            fast = fast.next;
        }
        ListNode slow = start;
        Random r = new Random();
        int i = 0, l = r.nextInt(size);
        while (i < l)
        {
            slow = slow.next;
            i++;
        }
        fast.next = slow;
    }
    public static void main(String args[])
    {
        LinkedListCycle listCycle = new LinkedListCycle();
        Random r = new Random();
        for (int i = 0; i < 15; i++)
        {
            listCycle.insert(r.nextInt(40));
        }
        listCycle.display(listCycle.head);
        listCycle.createCycle(listCycle.head);
        System.out.println(listCycle.getCycleNode(listCycle.head).val);
    }
}
