package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertPosition
{
    public int searchInsert(List<Integer> ar, int key)
    {
        int l = 0, h = ar.size() - 1, mid;
        while (l <= h)
        {
            mid = l + (h - l) / 2;
            if (ar.get(mid) >= key)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
    public static void main(String args[])
    {
        InsertPosition insertPosition = new InsertPosition();
        List<Integer> ar = Arrays.asList(1,3,5,6);
        System.out.println(insertPosition.searchInsert(ar, 1));
    }
}
