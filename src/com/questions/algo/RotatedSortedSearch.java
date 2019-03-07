package com.questions.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotatedSortedSearch
{
    public int search(final List<Integer> ar, int key)
    {
        int index;
        int pivot = getPivot(ar);
        System.out.println(pivot);
        if (pivot == 0)
            return  binarySearch(ar, key);
        if (key < ar.get(0))
        {
            index = binarySearch(ar.subList(pivot, ar.size()), key);
            index = (index == -1) ? index : index + pivot;
        }
        else
        {
            index = binarySearch(ar.subList(0, pivot), key);
        }
            return index;
    }
    public int getPivot(List<Integer> ar)
    {
        int l = 0, h = ar.size() - 1;
        int m;
        while (ar.get(l) > ar.get(h)) {
            m = l + (h - l) / 2;
            if (ar.get(m) < ar.get(h)) {
                h = m;
            }
            else {
                l = m + 1;
            }
        }

        return l;
    }
    public int binarySearch(List<Integer> ar, int key)
    {
        int l = 0, h = ar.size() - 1, mid;
        while (l <= h)
        {
            mid = l + (h - l) / 2;
            if (ar.get(mid) == key)
                return mid;
            else if (ar.get(mid) > key)
            {
                h = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        RotatedSortedSearch rotatedSortedSearch = new RotatedSortedSearch();
        List<Integer> ar = Arrays.asList(1, 7, 67, 133, 178);
        System.out.println(rotatedSortedSearch.search(ar, 1));
    }
}
