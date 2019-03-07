package com.questions.algo;

public class CoprimeDivisor
{
    public int gcd(int m, int n)
    {
        if(m == 0)
            return n;
        else if (n == 0)
            return m;
        int s = m < n ? m : n;
        int g = m > n ? m : n;
        if(g % s == 0)
            return s;
        else
        {
            return gcd(s, g % s);
        }
    }
    public int cpFact(int A, int B)
    {
        int gcd;
        while(A >= 1)
        {
            gcd = gcd(A,B);
            if(gcd != 1)
                A = A / gcd;
            else
                return A;
        }
        return 0;
    }
    public static void main(String args[])
    {
        CoprimeDivisor coprimeDivisor = new CoprimeDivisor();
        System.out.println((coprimeDivisor.cpFact(30,24)));
    }
}
