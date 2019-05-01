package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum
{
    public int threeSumClosest(List<Integer> a, int target)
    {
        Collections.sort(a);
        int j, k, sum, gap = Integer.MAX_VALUE, diff, res = 0;
        for (int i = 0; i < a.size() - 2; i++)
        {
            j = i + 1;
            k = a.size() - 1;
            while (j < k)
            {
                sum = a.get(i) + a.get(j) + a.get(k);
                diff = Math.abs(sum - target);
                if (diff == 0)
                    return sum;
                if (gap > diff)
                {
                    gap = diff;
                    res = sum;
                }
                if (sum < target)
                    j++;
                else
                    k--;
            }
        }
        return res;
    }
    public static void main(String args[])
    {
        ThreeSum threeSum = new ThreeSum();
        List<Integer> a = Arrays.asList(-6, -4, -2, 1, 4, 9, 21);
        System.out.println(threeSum.threeSumClosest(a, 1));
    }

}
