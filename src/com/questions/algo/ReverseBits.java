package com.questions.algo;

public class ReverseBits
{
    public long reverse(long n)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = Integer.SIZE - 1; i >= 0; i--)
        {
            if ((n & (1 << i)) >= 1)
                sb.insert(0, "1");
            else
                sb.insert(0, "0");
        }
        long num = 0L;
        for (int i = 0; i < sb.length(); i++)
        {
            if (sb.charAt(i) == '1')
            {
                num += Math.pow(2, sb.length() - i - 1);
            }
        }
        return num;
    }
    public static void main(String args[])
    {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverse(3));
    }
}
