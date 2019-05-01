package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxWater
{
    public int maxArea(List<Integer> ar)
    {
        int i = 0, j = ar.size() - 1;
        int min, area, maxArea = 0;
        while (i < j)
        {
            min = Math.min(ar.get(i), ar.get(j));
            area = (j - i) * min;
            maxArea = Math.max(area, maxArea);
            if (ar.get(i) == min)
                i++;
            else
                j--;
        }
        return maxArea;
    }
    public static void main(String args[])
    {
        MaxWater maxWater = new MaxWater();
        List<Integer> ar = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        System.out.println(maxWater.maxArea(ar));
    }
}
