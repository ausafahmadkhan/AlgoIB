package com.questions.algo;

import java.util.Arrays;
import java.util.List;

public class SingleNumber2
{
    public int singleNumber(final List<Integer> ar)
    {
        int count, result = 0;
        for (int i = 0; i < Integer.SIZE; i++)
        {
            count = 0;
            for (int j = 0; j < ar.size(); j++)
            {
                count += (ar.get(j) & 1 << i) != 0 ? 1 : 0;
            }
            if (count % 3 != 0)
            {
                result |= (count % 3) << i;
            }
        }
        return result;
    }
    public static void main(String args[])
    {
        SingleNumber2 singleNumber2 = new SingleNumber2();
        List<Integer> ar = Arrays.asList(1, 2, 78, 3, 3, 2, 2, 3, 1, 1);
        System.out.println(singleNumber2.singleNumber(ar));
    }
}
