package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookAllocation
{
    public int books(List<Integer> ar, int N)
    {
        if (N > ar.size())
            return -1;
        int max = Integer.MIN_VALUE, s = 0;
        for (int i = 0; i < ar.size(); i++)
        {
            max = Math.max(ar.get(i), max);
            s+= (int)((long)ar.get(i) % 10000003);
            s = (int)((long)s % 10000003);
        }
        int l = max , h = s, mid;
        while (l < h)
        {
            mid = (l + h) / 2;
            if (readers(mid, ar) <= N) {
                h = mid;
            }
            else
                l = mid + 1;
        }
        return h;
    }
    public int readers(int averageBook, List<Integer> ar)
    {
        int currentCount = 0, students = 1;
        for (int i = 0; i < ar.size(); i++)
        {
            currentCount +=  ar.get(i);
            if (currentCount > averageBook)
            {
                currentCount = ar.get(i);
                students++;
            }
        }
        return students;
    }


    public static void main(String args[])
    {
        BookAllocation bookAllocation = new BookAllocation();
        List<Integer> ar = Arrays.asList(31, 54, 69, 75, 86, 93, 112);
        //System.out.println(bookAllocation.books(ar,12));
        System.out.println(bookAllocation.books(ar, 4));
    }
}
