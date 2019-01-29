package com.questions.algo;


public class ReverseInteger {
    public int reverse(int n)
    {
        if(n == 0)
            return 0;
        int t;
        if(n < 0)
            t = -n;
        else
            t = n;
        int r = 0;
        int d = 0;
        while(t != 0)
        {
            d = t % 10;
            t = t / 10;
            r = r * 10 + d;
        }
        int l = r % 10;
        if(n < 0) {
            r = r * -1;
        }
        if(l != d)
            return 0;
        else
            return r;
    }
    public static void main(String args[])
    {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-4757658));
    }

}
