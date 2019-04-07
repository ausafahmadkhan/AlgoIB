package com.questions.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinXOR
{
    public int findMinXor(List<Integer> ar)
    {
        Collections.sort(ar);
        int min = Integer.MAX_VALUE, temp;
        for (int i = 0; i < ar.size() - 1; i++)
        {
            temp = ar.get(i) ^ ar.get(i + 1);
            min = min < temp ? min : temp;
        }
        return min;
    }
    public static void main(String args[])
    {
        MinXOR minXOR = new MinXOR();
        List<Integer> ar = Arrays.asList(0, 4, 7, 9);
        System.out.println(minXOR.findMinXor(ar));
    }
}
