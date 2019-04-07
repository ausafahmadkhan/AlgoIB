package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiffBitsSum
{
    public int cntBits(List<Integer> ar)
    {
        int ones = 0, zeroes;
        int hammingDistance = 0;
        for (int i = 0; i < 32; i++)
        {
            ones = 0;
            for (int j = 0; j < ar.size(); j++)
            {
                ones += (ar.get(j) & 1 << i) != 0 ? 1 : 0;
            }
            zeroes = ar.size() - ones;
            hammingDistance += (int)((2L * ones * zeroes) % 1000000007);
            hammingDistance %= 1000000007;
        }
        return hammingDistance;
    }
    public static void main(String args[])
    {
        DiffBitsSum h = new DiffBitsSum();
        List<Integer> ar = Arrays.asList(2, 2, 2);
        System.out.println(h.cntBits(ar));
    }
}
