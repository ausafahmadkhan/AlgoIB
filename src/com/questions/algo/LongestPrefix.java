package com.questions.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestPrefix
{
    public String longestCommonPrefix(List<String> s)
    {
        String st = s.get(0);
        for (int i = 1; i < s.size(); i++)
        {
            st = st.length() < s.get(i).length() ? st : s.get(i);
        }
        System.out.println(st);
        int l = 0, h = st.length() - 1;
        int mid;
        String prefix;
        while (l <= h)
        {
            mid = (l + h) / 2;
            prefix = st.substring(0, mid + 1);
            if (!startsWith(prefix, s))
                h = mid - 1;
            else
                l = mid + 1;
        }
        return st.substring(0, l);
    }
    public boolean startsWith(String prefix, List<String> s)
    {
        for (String st : s)
        {
            if (!st.startsWith(prefix))
                return false;
        }
        return true;
    }
    public static void  main(String args[])
    {
        LongestPrefix longestPrefix = new LongestPrefix();
        List<String> s = Arrays.asList("abcd", "abcde", "abcdf","abcdefgs");
        System.out.println(longestPrefix.longestCommonPrefix(s));
    }
}
