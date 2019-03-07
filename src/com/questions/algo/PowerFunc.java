package com.questions.algo;

public class PowerFunc
{
    public int pow(int x, int y, int d)
    {
        if (y == 1)
            return (x < 0) ? (x + d) % d : x % d;
        else if (y == 0)
            return 1 % d;
        else
        {
            if (y % 2 == 0)
            {
                int p = (int)(((long)x * x) % d);
                return pow(p, y / 2, d);
            }
            else
            {
                int p = (int)(((long)x * x) % d);
                int q = pow(p, (y - 1) / 2, d);
                return (int)(((long)x * q) % d);
            }
        }

    }
    public static void main(String args[])
    {
        PowerFunc powerFunc = new PowerFunc();
        System.out.println(powerFunc.pow(71045970, 41535484, 64735492));
        //System.out.println(powerFunc.pow(3, 6, 6));
    }
}
