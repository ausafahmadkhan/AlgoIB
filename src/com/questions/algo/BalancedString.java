package com.questions.algo;

public class BalancedString
{
    private Stackk<Character> stackk;
    public BalancedString()
    {
        stackk = new Stackk<>();
    }
    public boolean isBalanced(String s)
    {
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stackk.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stackk.isEmpty()) {
                    return false;
                }
                if (ch == ')' && '(' != stackk.pop()) {
                    return false;
                } else if (ch == '}' && '{' != stackk.pop()) {
                    return false;
                } else if (ch == ']' && '[' != stackk.pop()) {
                    return false;
                }
            }
        }
        return stackk.isEmpty();
    }
    public static void main(String args[])
    {
        BalancedString bs = new BalancedString();
        System.out.println(bs.isBalanced("{gdajwh(hbj[ewvjh]ewhj)wew}ewjh(v)}"));
    }
}
