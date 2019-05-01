package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiffK
{
    public int diffPossible(List<Integer> ar, int k)
    {
        int i, j, diff;
        for (i = 0, j = i + 1; j < ar.size();)
        {
            if (i == j)
                j++;
            if (j == ar.size())
                break;
            diff = ar.get(j) - ar.get(i);
            if (diff == k)
            {
                return 1;
            }
            if (diff < k)
                j++;
            else
            {
                i++;
                j--;
            }
        }
        return 0;
    }
    public static void main(String args[])
    {
        DiffK diffK = new DiffK();
        List<Integer> ar = Arrays.asList(1, 2, 3);
        System.out.println(diffK.diffPossible(ar,0 ));
    }
}
