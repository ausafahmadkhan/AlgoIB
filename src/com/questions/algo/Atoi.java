package com.questions.algo;

public class Atoi
{
    public int atoi(final String s)
    {
        boolean started = false, negative = false;
        int result = 0;
        try
        {
            for (char c : s.toCharArray())
            {
                if (Character.isWhitespace(c) && !started)
                {
                    continue;
                }
                else if (!started && (c == '+' || c == '-'))
                {
                    started = true;
                    negative = c == '-';
                }
                else if (Character.isDigit(c))
                {
                    started = true;
                    result = Math.multiplyExact(result, 10);
                    result = Math.addExact(result, Character.getNumericValue(c));
                }
                else
                    break;
            }
        }
        catch (ArithmeticException e)
        {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return negative ? -result : result;
    }
    public static void  main(String args[])
    {
        Atoi atoi = new Atoi();
        System.out.println(atoi.atoi("    -78646589+    hgdjhv"));
    }
}
