package com.questions.algo;

public class AddBinary
{
    public String addBinary(String a, String b)
    {
        System.out.println(a.length() + " " + b.length());
        int sum[][] = new int[2][2];
        sum[0][0] = 0;
        sum[0][1] = 1;
        sum[1][0] = 1;
        sum[1][1] = 0;
        int carry[][] = new int[2][2];
        carry[0][0] = 0;
        carry[0][1] = 0;
        carry[1][0] = 0;
        carry[1][1] = 1;
        StringBuffer stringBuffer = new StringBuffer();
        int s, c = 0, prevcarry, i, j;
        int l = a.length() < b.length() ? a.length() : b.length();
        for (i =  a.length() - 1,j = b.length() - 1; i >= a.length() - l && j >= b.length() - l; i--, j--)
        {
            prevcarry = c;
            s = sum[a.charAt(i) - 48][b.charAt(j) - 48];
            c = carry[a.charAt(i) - 48][b.charAt(j) - 48];
            if (c == 0)
            {
                c = carry[s][prevcarry];
            }
            s = sum[s][prevcarry];
            stringBuffer.insert(0, s);
        }
        if (i >= 0)
        {
            if (c != 1) {
                stringBuffer.insert(0, a.substring(0, i + 1));
                return stringBuffer.toString();
            }
            else
            {
                while (c == 1)
                {
                    s = sum[a.charAt(i) - 48][c];
                    c = carry[a.charAt(i) - 48][c];
                    stringBuffer.insert(0, s);
                    i--;
                    if (i < 0)
                    {
                        if (c == 1)
                           return stringBuffer.insert(0, 1).toString();
                        else
                            return stringBuffer.toString();
                    }
                }
                if (i >= 0) {
                    stringBuffer.insert(0, a.substring(0, i + 1));
                    return stringBuffer.toString();
                }

            }
        }
        else if (j >= 0)
        {
            if (c != 1) {
                stringBuffer.insert(0, b.substring(0, j + 1));
                return stringBuffer.toString();
            }
            else
            {
                while (c == 1)
                {
                    s = sum[b.charAt(j) - 48][c];
                    c = carry[b.charAt(j) - 48][c];
                    stringBuffer.insert(0, s);
                    j--;
                    if (j < 0)
                    {
                        if (c == 1)
                            return stringBuffer.insert(0, 1).toString();
                        else
                            return stringBuffer.toString();
                    }
                }
                if (j >= 0) {
                    stringBuffer.insert(0, b.substring(0, j + 1));
                    return stringBuffer.toString();
                }

            }
        }
        if (c == 1)
            stringBuffer.insert(0, c);
        return stringBuffer.toString();
    }
    public static void main(String args[])
    {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1001101100101110001010101011111111011110","10101100000000001010011001011010010000011101110001011101001001111110110101101001101010010"));
    }
}
