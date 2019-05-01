package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsDiff
{
    public int diff(List<Integer> a, List<Integer> b, List<Integer> c)
    {
        int i, j, k, gap = Integer.MAX_VALUE;
        int min;
        int max;
        for (i = 0, j = 0, k = 0; i < a.size() && j < b.size() && k < c.size();)
        {
            min  = Math.min(Math.min(a.get(i), b.get(j)), c.get(k));
            max = Math.max(Math.max(a.get(i), b.get(j)), c.get(k));
            gap = Math.min(gap, max - min);
            if (a.get(i).equals(min))
                i++;
            else if (b.get(j).equals(min))
                j++;
            else
                k++;
        }
        return gap;
    }
    public static void main(String args[])
    {
        MinAbsDiff minAbsDiff = new MinAbsDiff();
        List<Integer> a = Arrays.asList(1, 4, 10);
        List<Integer> b = Arrays.asList(2, 15, 20);
        List<Integer> c = Arrays.asList(10, 12);
        System.out.println(minAbsDiff.diff(a, b, c));
    }
}
