package com.questions.algo;

import java.math.BigInteger;

public class TwoToK
{
    public int power(String s)
    {
        int i = 0, r = 0;
        BigInteger q = BigInteger.ZERO;
         while (true)
         {
             while (i < s.length()) {
                 r += (s.charAt(i) - 48);
                 q = q.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(r/2));
                 r = (r % 2) * 10;
                 i++;
             }
             if (q.intValue() == 1)
                 return 1;
             if (r != 0)
                 return 0;
             s = q + "";
             q = BigInteger.ZERO;
             i = 0;
         }
    }
    public static void main(String args[])
    {
        TwoToK twoToK = new TwoToK();
        System.out.println(twoToK.power("147573952589676412928"));
    }
}
