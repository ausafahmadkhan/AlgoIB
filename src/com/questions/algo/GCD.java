package com.questions.algo;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GCD
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
    public static void main(String args[])
    {
        GCD obj = new GCD();
        System.out.println(obj.gcd(30,24));
    }
}
