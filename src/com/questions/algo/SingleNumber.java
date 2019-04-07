package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber
{
    public int singleNumber(final List<Integer> ar)
    {
        int single = 0;
        for (int i = 0; i < ar.size(); i++)
        {
            single = single ^ ar.get(i);
            System.out.println(single);
        }
        return single;
    }
    public static void main(String args[])
    {
        SingleNumber singleNumber = new SingleNumber();
        List<Integer> ar = Arrays.asList(1,2,1,4,3,4,3);
        System.out.println(singleNumber.singleNumber(ar));
    }
}
