package com.questions.algo;

public class LongestPalindrome
{
    public int getLastIndex(char ch, String s, int before, int after)
    {
        for (int i = before; i > after; i--)
        {
            if (s.charAt(i) == ch)
                return i;
        }
        return -1;
    }
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
    public String longestPalindrome(String s)
    {
        int j = s.length() - 1;
        String st, longest = "";
        for (int i = 0; i < s.length(); i++)
        {
            j = getLastIndex(s.charAt(i), s, j, i);
            if (j == -1) {
                j = s.length() - 1;
                continue;
            }
            while (j != -1)
            {
                st= s.substring(i, j + 1);
                if (isPalindrome(st) == 1)
                {
                    longest = longest.length() < st.length() ? st : longest;
                    break;
                }
                else
                {
                    j--;
                    j = getLastIndex(s.charAt(i), s, j, i);
                }
            }
            j = s.length() - 1;
        }
        return longest != "" ? longest : s.charAt(0)+"";
    }
    public static void main(String args[])
    {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("aba"));
    }
}
