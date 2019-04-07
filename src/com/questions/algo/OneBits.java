package com.questions.algo;

public class OneBits
{
    public int numSetBits(long n)
    {
        int c = 0;
        for (int i = 0; i < Long.SIZE; i++)
        {
            c = (n & (1L << i)) >= 1 ? c + 1 : c;
        }
        return c;
    }
    public static void main(String args[])
    {
        OneBits oneBits = new OneBits();
        System.out.println(oneBits.numSetBits(11));
    }
}
