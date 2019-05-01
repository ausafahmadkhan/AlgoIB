package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortBalls
{
    public void sort(List<Integer> ar)
    {
        int i, j = 1;
        for (i = 0; j < ar.size() && i < ar.size();)
        {
            if (ar.get(j) == 0) {
                swap(i, j, ar);
                i++;
                if (i == j)
                    j++;
            }
            else
                j++;
        }
        System.out.println(ar);
        System.out.println(i);
        for (j = i + 1; j < ar.size() && i < ar.size();)
        {
            if (ar.get(j) == 1) {
                swap(i, j, ar);
                i++;
                if (i == j)
                    j++;
            }
            else
                j++;
        }
        System.out.println(ar);
    }
    public void swap(int i, int j, List<Integer> ar)
    {
        int temp = ar.get(i);
        ar.set(i, ar.get(j));
        ar.set(j, temp);
    }
    public static void main(String args[])
    {
        SortBalls sortBalls = new SortBalls();
        List<Integer> ar = Arrays.asList(1, 0, 0, 1, 1, 0, 0, 2, 1, 2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0, 0, 2, 0, 2, 2, 2, 0, 0, 1, 1, 1, 2, 2, 0, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, 1, 1, 0, 0, 1, 2, 1, 1, 0, 1, 0, 2, 0, 2, 1, 0, 1, 1, 0, 0, 1, 2, 0, 1, 0, 2, 1, 0, 1, 0, 1, 0, 1, 2, 2, 2, 0, 1, 1, 0, 2, 2, 2, 0, 0, 0, 0, 1, 1, 2, 1, 0, 1, 0, 1, 2, 2, 1, 0, 2, 0, 0, 1, 2, 1, 0, 2, 1, 0, 2, 0, 2, 1, 1, 1, 1, 1, 0, 1, 2, 0, 0, 1, 0, 1, 2, 0, 1, 1, 2, 1, 0, 2, 0, 0, 0, 2, 0, 1, 0, 2, 1, 1, 0, 1, 2, 1, 0, 0);
        sortBalls.sort(ar);
    }
}
