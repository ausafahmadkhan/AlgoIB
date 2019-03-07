package com.questions.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSearch
{
    public int searchMatrix(List<List<Integer>> ar, int key)
    {
        int C = ar.get(0).size(), R = ar.size();
        int r, c, l = 0, h = R * C - 1;
        int mid;
        while (l <= h)
        {
            mid = l + (h - l) / 2;
            r = mid / C;
            c = mid % C;
            if (ar.get(r).get(c) == key)
            {
                return 1;
            }
            else if (ar.get(r).get(c) > key)
            {
                h = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return 0;
    }
    public static void main(String args[])
    {
        MatrixSearch matrixSearch  = new MatrixSearch();
//        ArrayList<Integer> ar = new ArrayList<>();
//        ar.add(15);
//        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
//        arr.add(ar);

//        [1, 4, 5, 5, 6, 14, 14, 16, 19]
//  [22, 24, 28, 33, 35, 37, 38, 40, 41]
//  [45, 50, 52, 55, 56, 56, 57, 60, 60]
//  [63, 64, 66, 68, 68, 71, 78, 78, 79]
//  [84, 89, 90, 91, 93, 94, 94, 97, 98]
//]
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(1, 4, 5, 5, 6, 14, 14, 16, 19),
                Arrays.asList(22, 24, 28, 33, 35, 37, 38, 40, 41),
                Arrays.asList(45, 50, 52, 55, 56, 56, 57, 60, 60),
                Arrays.asList(63, 64, 66, 68, 68, 71, 78, 78, 79),
                Arrays.asList(84, 89, 90, 91, 93, 94, 94, 97, 98));
//                Arrays.asList(57, 60, 60, 61, 61, 62, 63),
//                Arrays.asList(64, 65, 66, 67, 68, 71, 71),
//                Arrays.asList(75, 77, 77, 77, 78, 79, 80),
//                Arrays.asList(81, 83, 84, 85, 86, 88, 88),
//                Arrays.asList(91, 92, 93, 93, 95, 95, 98));
        System.out.println(matrixSearch.searchMatrix(arr, 45));
    }
}
