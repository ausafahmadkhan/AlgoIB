package com.questions.algo;

public class DivideIntegers
{
    public int divide(int a, int b) {
        long A = (long)a;
        long B = (long)b;
        long sign = ((A<0)^(B<0))?-1:1;
        A = Math.abs(A);
        B = Math.abs(B);
        long quot = 0,temp = 0;
        for(int i=31;i>=0;--i){
            if((temp+(B<<i))<=A){
                temp += (B<<i);
                quot = quot|(1L<<i);
            }
        }
        long result = (sign*quot);
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)result;
    }
    public static void main(String args[])
    {
        DivideIntegers divideIntegers = new DivideIntegers();
        System.out.println(divideIntegers.divide(61, 9));
    }
}
