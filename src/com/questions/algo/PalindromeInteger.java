package com.questions.algo;

public class PalindromeInteger
{

    public int isPalindrome(int n)
    {
        if (n == 0)
            return  1;
        else if( n < 0)
            return  0;
        int t = n, d = 0;
        while(t != 0)
        {
            t = t / 10;
            d++;
        }
        int a = (int)Math.pow(10,d - 1);
        int b = 10;
        while(n / a == n % b)
        {
            n = n % a;
            n = n / b;
            a /= 100;
            if(n == 0 || a == 1 )
                return 1;
        }
        return 0;
    }
    public static void  main(String args[])
    {
        PalindromeInteger palindromeInteger = new PalindromeInteger();
        System.out.println(palindromeInteger.isPalindrome(134731));
    }

}
