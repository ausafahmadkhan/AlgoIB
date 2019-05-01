package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumOfTriangles
{
    public int nTriang(List<Integer> ar)
    {
        int j, k;
        long c = 0;
        Collections.sort(ar);
        for (int i = 0; i < ar.size() - 2; i++)
        {
            k = i + 2;
            for (j = i + 1; j < ar.size(); j++)
            {
                while (k < ar.size() && ar.get(i) + ar.get(j) > ar.get(k))
                    k++;
                if (k > j)
                {
                    c += k - j  - 1;
                    c %= 1000000007;
                }

            }
        }
        return (int) (c % 1000000007);
    }
    public static void main(String args[])
    {
        NumOfTriangles numOfTriangles = new NumOfTriangles();
        List<Integer> ar = Arrays.asList(1, 1, 1, 2, 2);
        System.out.println(numOfTriangles.nTriang(ar));
    }
}
