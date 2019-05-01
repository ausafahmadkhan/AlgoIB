package com.questions.algo;


public class AddLinkedList
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
    public ListNode add(ListNode start1, ListNode start2)
    {
        int carry = 0, sum;
        boolean flag = false;
        ListNode tmp = start1, start = start1;
        while (start1 != null && start2 != null)
        {
            sum = start1.val + start2.val;
            sum += carry;
            carry = sum / 10;
            sum %= 10;
            start1.val = sum;
            start1 = start1.next;
            start2 = start2.next;
        }
        if (start2 != null)
        {
            flag = true;
            while (start2 != null)
            {
                sum = start2.val + carry;
                carry = sum / 10;
                sum %= 10;
                insert(sum);
                start2 = start2.next;
            }
        }
        else if (start1 != null)
        {
            while (start1 != null)
            {
                sum = start1.val + carry;
                carry = sum / 10;
                sum %= 10;
                start1.val = sum;
                start1 = start1.next;
            }
        }
        if (flag) {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = head;
        }
        if (carry != 0)
            insert(carry);
        return start;
    }
    public static void main(String args[])
    {
        AddLinkedList add1 = new AddLinkedList();
        AddLinkedList add2 = new AddLinkedList();
        add1.insert(2);
        add1.insert(4);
        add1.insert(7);
        add1.insert(5);
        add1.insert(6);
        add2.insert(5);
        add2.insert(6);
        add2.insert(4);
        add1.display(add1.head);
        add2.display(add2.head);
        AddLinkedList add3 = new AddLinkedList();
        add3.display(add3.add(add1.head, add2.head));
    }
}
