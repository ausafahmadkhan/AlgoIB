package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSearch
{
    public ArrayList<Integer> searchRange(final List<Integer> arr, int key)
    {
        ArrayList<Integer> ar = new ArrayList<>();
        int index = isPresent(arr, key);
        if (index == -1) {
            ar.add(-1);
            ar.add(-1);
        }
        else {
            ar.add(leftSearch(arr, key));
            ar.add(rightSearch(arr, key));
        }
        return ar;
    }
    public int isPresent(List<Integer> ar, int key)
    {
        int l = 0, h = ar.size() - 1, mid;
        while (l <= h)
        {
            mid = l + (h - l) / 2;
            if (ar.get(mid) < key)
                l = mid + 1;
            else if (ar.get(mid) == key)
                return mid;
            else
                h = mid - 1;
        }
        return -1;
    }
    public int leftSearch(List<Integer> ar, int key)
    {
       int l = 0, h = ar.size() - 1, mid;
       while (l <= h)
       {
           mid = l + (h - l) / 2;
           if (ar.get(mid) < key)
               l = mid + 1;
           else
               h = mid - 1;
       }
       return l;
    }
    public int rightSearch(List<Integer> ar, int key)
    {
        int l = 0, h = ar.size() - 1, mid;
        while (l <= h)
        {
            mid = l + (h - l) / 2;
            if (ar.get(mid) <= key)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h;
    }
    public static void main(String args[])
    {
        RangeSearch rangeSearch = new RangeSearch();
        List<Integer> ar = Arrays.asList(5, 7, 7, 8, 8, 10);
        System.out.println(rangeSearch.searchRange(ar, 8));
    }
}
