package com.questions.algo;

public class PalindromeString
{
    public int isPalindrome(String s)
    {
        int i = 0, j = s.length() - 1;
        char c1, c2;
        s = s.toLowerCase();
        while (i < j)
        {
            c1 = s.charAt(i);
            c2 = s.charAt(j);
            if (!Character.isLetterOrDigit(c1))
            {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(c2))
            {
                j--;
                continue;
            }
            if (c1 != c2)
                return 0;
            else
            {
                i++;
                j--;
            }
        }
        return 1;
    }
    public static void  main(String args[])
    {
        PalindromeString palindromeString = new PalindromeString();
        System.out.println(palindromeString.isPalindrome("A mann, a plan, a canal: Panama"));
    }
}
