package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumbersLessThanC
{
    public int solve(List<Integer> ar, int D, int N)
    {
        if(ar.isEmpty())
            return 0;
        int t = N,d = 0;
        while(t != 0)
        {
            d++;
            t /= 10;
        }
        if(D > d)
            return 0;
        else if (D < d)
        {
            int p;
            if(ar.get(0) == 0 && D != 1)
                p = (ar.size() - 1) * (int) Math.pow(ar.size(), D - 1);
            else
                p = (int) Math.pow(ar.size(),D);
            return p;
        }
        else
        {
            int s = 0, n = D;
            for(int i = 0; i < n; i++)
            {
                t = N / (int) Math.pow(10,D - 1);
                int c = 0;
                for(int j = 0; j < ar.size(); j++)
                {
                    if(ar.get(j) < t)
                        c++;
                }
                if(i == 0 && ar.get(i) == 0 && n != 1)
                    c--;
                int p = (int) Math.pow(ar.size(),D - 1);
                p = p * c;
                s = s + p;
                int keyIndex = Collections.binarySearch(ar,t);
                if(keyIndex < 0)
                    return s;
                N = N % (int) Math.pow(10,D - 1);
                D--;
            }
            return s;
        }
    }
    public static void main(String args[])
    {
        NumbersLessThanC numbersLessThanC = new NumbersLessThanC();
        List<Integer> ar = Arrays.asList(0, 1, 3, 4, 6, 7, 8 );
        System.out.println(numbersLessThanC.solve(ar, 5, 36321));
    }
}
