package com.questions.algo;

public class Sqrt
{
    public int sqrt(int n)
    {
        long m,ms ;
        long l = 0, h = n;
        while(h >= l)
        {
            m = (l + h) / 2;
            ms = m * m;
            if(ms == n)
                return (int) m;
            else if ( ms > n )
                h = m - 1;
            else
                l = m + 1;
        }
        return (int)h;
    }
    public static void main(String args[])
    {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(2147483647));
    }
}
