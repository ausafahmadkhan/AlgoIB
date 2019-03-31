package com.questions.algo;

import java.math.BigInteger;
import java.util.Comparator;

public class CompareVersion implements Comparator<String>
{
    public int compare(String ver1, String ver2)
    {
        String s1[] = ver1.split("\\.");
        String s2[] = ver2.split("\\.");
        BigInteger temp1, temp2;
        int l = s1.length > s2.length ? s1.length : s2.length;
        for (int i = 0; i < l;)
        {
            if (i == s1.length)
            {
                if (checkIfZeros(s2, i))
                    return 0;
                else
                    return -1;
            }
            else if (i == s2.length)
            {
                if (checkIfZeros(s1, i))
                    return 0;
                else
                    return 1;
            }
            temp1 = new BigInteger(s1[i]);
            temp2 = new BigInteger(s2[i]);
            if (temp1.compareTo(temp2) > 0)
                return 1;
            else if (temp1.compareTo(temp2) < 0)
                return -1;
            else
                i++;
        }
        return 0;
    }
    public boolean checkIfZeros(String ar[], int begin)
    {
        for (int i = begin; i < ar.length; i++)
        {
            if (!ar[i].equals("0"))
                return false;
        }
        return true;
    }
    public static void main(String args[])
    {
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compare("1.0.0.0.0.0.0.5", "1"));
    }
}
