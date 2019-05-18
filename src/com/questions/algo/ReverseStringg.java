package com.questions.algo;

import java.util.Stack;

public class ReverseStringg
{
    private Stack<Character> stackk = new Stack<>();;
    public String reverse(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            stackk.push(s.charAt(i));
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stackk.isEmpty())
        {
            stringBuffer.append(stackk.pop());
        }
        return stringBuffer.toString();
    }

    public static void main(String args[])
    {
        ReverseStringg reverseStringg = new ReverseStringg();
        System.out.println(reverseStringg.reverse("Ausaf Ahmad Khan"));
    }
}
