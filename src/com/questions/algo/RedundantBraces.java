package com.questions.algo;

import java.util.Stack;

public class RedundantBraces
{
    public int hasRedundant(String s)
    {
        Stack<Character> characterStack = new Stack<>();
        char ch;
        boolean operator, operand;
        for (int i = 0; i < s.length(); i++)
        {
            ch = s.charAt(i);
            if (ch == ')')
            {
                operand = false;
                operator = false;
                ch = characterStack.pop();
                if (ch == '(')
                    return 1;
                while (ch != '(')
                {
                    if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
                        operator = true;
                    if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57))
                        operand = true;
                    ch = characterStack.pop();
                }
                if (!(operand && operator))
                    return 1;
            }
            else
            {
                characterStack.push(s.charAt(i));
            }
        }
        return 0;
    }
    public static void main(String args[])
    {
        RedundantBraces redundantBraces = new RedundantBraces();
        System.out.println(redundantBraces.hasRedundant("(a/(a+b))"));
    }
}
