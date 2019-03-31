package com.questions.algo;

public class StrStr
{
    public void constructArray(String pattern, int []ar)
    {
        ar[0] = 0;
        int j = 0;
        for (int i = 1; i < pattern.length();)
        {
            if (pattern.charAt(i) == pattern.charAt(j))
            {
                ar[i] = j + 1;
                i++;
                j++;
            }
            else
            {
                if ( j!= 0)
                {
                    j = ar[j - 1];
                }
                else
                {
                    ar[i] = 0;
                    i++;
                }
            }
        }
    }
    public int strStr(final String needle, final String haystack)
    {
        if (needle.isEmpty() || haystack.isEmpty())
            return -1;
        int ar[] = new int[needle.length()];
        constructArray(needle, ar);
        int i, j = 0;
        for (i = 0; i < haystack.length() && j < needle.length();)
        {
            if (haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                if (j != 0)
                {
                    j = ar[j-1];
                }
                else
                {
                    i++;
                }
            }
        }
        if (j == needle.length())
            return i - needle.length();
        else
            return -1;
    }
    public static void main(String args[])
    {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("abc", "adshbjkfabcjkbdakjb"));
    }
}
