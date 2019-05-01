package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbsoluteDiff
{
    public int absdiff(List<Integer> a, List<Integer> b, List<Integer> c)
    {
        int min, max, i = 0, j = 0, k = 0, num;
        long gap = Integer.MAX_VALUE;
        while (i < a.size() && j < b.size() && k < c.size())
        {
            min = Math.min(Math.min(a.get(i), b.get(j)), c.get(k));
            max = Math.max(Math.max(a.get(i), b.get(j)), c.get(k));
            gap = Math.min(gap,max - min);
            if (min == a.get(i))
                i++;
            else if (min == b.get(j))
                j++;
            else if (min == c.get(k))
                k++;
        }
        return (int)gap;
    }
    public static void main(String args[])
    {
        AbsoluteDiff absoluteDiff = new AbsoluteDiff();
        List<Integer> a = Arrays.asList(-1);
        List<Integer> b = Arrays.asList(-6);
        List<Integer> c = Arrays.asList(-3);
        System.out.println(absoluteDiff.absdiff(a, b, c));
    }
}
