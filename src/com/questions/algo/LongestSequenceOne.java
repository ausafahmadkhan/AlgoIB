package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSequenceOne
{
    public ArrayList<Integer> getSeries(List<Integer> ar, int n)
    {
        int i, j = 0, c = n;
        int count = 0, max = 0, start = 0, end = 0;
        if (n == 0)
        {
            for (i = 0; i < ar.size();)
            {
                if (ar.get(i) == 1)
                    count++;
                else
                {
                    count = 0;
                }
                if (max < count)
                {
                    max = count;
                    end = i + 1;
                    start = i + 1 - count;
                }
                i++;
            }
        }
        else {
            for (i = 0; i < ar.size(); ) {
                if (ar.get(i) == 0) {
                    c--;
                    i++;
                    if (c == -1) {
                        i = j;
                        c = n;
                        count = -1;
                    } else if (c == n - 1)
                        j = i;
                } else
                    i++;
                count++;
                if (max < count) {
                    max = count;
                    start = i - count;
                    end = i;
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (i = start; i < end; i++)
            arrayList.add(i);
        return arrayList;
    }
    public static void main(String args[])
    {
        LongestSequenceOne longestSequenceOne = new LongestSequenceOne();
        List<Integer> ar = Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1);
        System.out.println(longestSequenceOne.getSeries(ar, 0));
    }
}
