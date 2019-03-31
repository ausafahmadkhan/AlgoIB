package com.questions.algo;

import java.util.ArrayList;

public class NumberToRoman
{
    public String intToRoman(int n)
    {
        ArrayList<Character> ar = new ArrayList<>();
        ar.add('I');
        ar.add('V');
        ar.add('X');
        ar.add('L');
        ar.add('C');
        ar.add('D');
        ar.add('M');
        int d, a = 0, b = 1, c = 2;
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            d = n % 10;
            n = n / 10;
            if (d < 4) {
                while (d > 0) {
                    sb.insert(0, ar.get(a));
                    d--;
                }
            } else if (d == 4) {
                sb.insert(0, ar.get(a).toString() + ar.get(b).toString());
            } else {
                if (d != 9) {
                    sb.insert(0, ar.get(b));
                    while (d > 5) {
                        sb.insert(1, ar.get(a));
                        d--;
                    }
                } else {
                    sb.insert(0, ar.get(a).toString() + ar.get(c).toString());
                }
            }
            a += 2;
            b += 2;
            c += 2;
        }
        return sb.toString();
    }
    public static void main(String arg[])
    {
        NumberToRoman numberToRoman= new NumberToRoman();
        System.out.println(numberToRoman.intToRoman(3999));
    }
}
