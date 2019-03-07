package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rearrange
{
    public int search(List<Integer> A, int key)
    {
        for(int i = 0; i < A.size(); i++)
        {
            if(A.get(i) == key)
                return i;
        }
        return -1;
    }
    public void rearrange(List<Integer> A)
    {
        System.out.println(A);
        int index = 0;
        int val = A.get(index), t;
        int lastVisitedIndex = -1,count = 0;
        while(count < A.size() && index < A.size())
        {

            index = search(A,index);
            if(index == -1) {
                index = lastVisitedIndex + 1;
                val = A.get(index);
                lastVisitedIndex = index;
                continue;
            }
            t = A.get(index);
            A.set(index, val + A.size());
            val = t;
            count++;
        }
        for(index = 0; index < A.size(); index++)
        {
            A.set(index,A.get(index) - A.size());
        }
        System.out.println(A);
    }

        public void arrange(List<Integer> A) {
            int n = A.size();
            for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
            for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
        }


    public static void main(String args[])
    {
        Rearrange rearrange = new Rearrange();
        List<Integer> A = Arrays.asList(3,5,0,2,1,4);
        rearrange.arrange(A);
        System.out.println(A);

    }
}
