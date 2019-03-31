package com.questions.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MultiplyStrings
{
    public String multiply(String a, String b)
    {
        if (a.equals("0") || b.equals("0"))
            return "0";
        ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>();
        int i, j, carry = 0, p = 1;
        i = 0;
        while (a.charAt(i) == '0')
        {
            i++;
        }
        if (i != 0)
            a = a.substring(i);
        i = 0;
        while (b.charAt(i) == '0')
        {
            i++;
        }
        if (i != 0)
            b = b.substring(i);
        for (i = b.length() - 1; i >= 0; i--)
        {
            ar.add(new ArrayList<>());
            for (j = a.length() - 1; j >= 0; j--)
            {
                p = Character.getNumericValue(b.charAt(i)) * Character.getNumericValue(a.charAt(j));
                p += carry;
                carry = p / 10;
                p = p % 10;
                ar.get(b.length() - i - 1).add(p);
            }
            if (carry != 0 )
                ar.get(b.length() - i - 1).add(carry);
            carry = 0;
        }
        for (i = 1; i < ar.size(); i++)
        {
            for (j = 0; j < i; j++)
            {
                ar.get(i).add(0,0);
            }
        }
        int max = 0, s = 0;
        carry = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for ( i = 0; i < ar.size(); i++)
        {
            max = max > ar.get(i).size() ? max : ar.get(i).size();
        }
        for (i = 0; i < max; i++)
        {
            for (j = 0; j < ar.size(); j++)
            {
                if (i >= ar.get(j).size()) {
                    continue;
                }
                s = s + ar.get(j).get(i);
            }
            s += carry;
            carry = s / 10;
            s = s % 10;
            result.add(s);
            s = 0;
        }
        if (carry != 0)
            result.add(carry);
        StringBuffer sb = new StringBuffer();
        for (i = result.size() - 1; i >= 0; i--)
            sb.append(result.get(i));
        return sb.toString();
    }
    public static void main(String args[])
    {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("0010", "45"));
    }
}
