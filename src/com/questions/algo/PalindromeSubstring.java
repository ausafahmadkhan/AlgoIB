package com.questions.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeSubstring
{
    public boolean isPalindrome(String s)
    {
        int i = 0, j = s.length() - 1;
        char c1, c2;
        while (i < j)
        {
            c1 = s.charAt(i);
            c2 = s.charAt(j);
            if (c1 != c2)
                return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }
    public int getLastIndex(char ch, String s, int from, int to)
    {
        for (int i = to; i >= from; i--)
        {
            if (s.charAt(i) == ch)
                return i;
        }
        return -1;
    }
    public int countPalindromes(String s)
    {
        int i = 0, index = s.length() - 1, count = 0, l = s.length();
        char ch;
        while (i < l)
        {
            ch = s.charAt(i);
            index = getLastIndex(ch, s, i, index);
            while (index != -1)
            {
                if (index == i)
                    count++;
                else
                {
                    if (isPalindrome(s.substring(i, index + 1)))
                        count++;
                }
                index = getLastIndex(ch, s, i, index - 1);
            }
            i++;
            index = s.length() - 1;
        }
        return count;
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string");
        String s = br.readLine();
        PalindromeSubstring palindromeSubstring = new PalindromeSubstring();
        System.out.println(palindromeSubstring.countPalindromes(s));
    }
}
