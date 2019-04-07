package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeArray
{
    public void merge(ArrayList<Integer> A, ArrayList<Integer> B)
    {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (true)
        {
            if (i == A.size())
                break;
            else if (j == B.size())
                break;
            else if (A.get(i) > B.get(j))
            {
                result.add(B.get(j));
                j++;
            }
            else
            {
                result.add(A.get(i));
                i++;
            }
        }
        if (i == A.size() && j < B.size())
        {
            while (j < B.size())
            {
                result.add(B.get(j));
                j++;
            }
        }
        else if (j == B.size() && i < A.size())
        {
            while (i < A.size())
            {
                result.add(A.get(i));
                i++;
            }
        }
        i = 0;
        j = A.size();
        for (Integer num : result)
        {
            if (i < j) {
                A.set(i, num);
                i++;
            }
            else
            {
                A.add(num);
            }
        }
    }
    public static void main(String args[])
    {
        MergeArray mergeArray = new MergeArray();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(-4);
        A.add(3);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(-2);
        B.add(-2);
        System.out.println(A);
        mergeArray.merge(A, B);
        System.out.println(A);
    }
}
