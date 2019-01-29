package com.questions.algo;

public class TrailingZeroes
{
    public int trailingZeroes(int n)
    {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;

        return count;
    }
    public static void main(String args[])
    {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(9247));
    }
}
