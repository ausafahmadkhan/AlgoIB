package com.questions.algo;

public class ValidNumber
{
    public int isNumber(final String s)
    {
        if (s.contains("e"))
        {
            String sarray[] = s.split("e");
            if (sarray.length != 2)
                return 0;
            else
            {
                if (sarray[1].contains("."))
                    return 0;
                else
                {
                    if (validateCoeff(ltrim(sarray[0])) == 1 && validateDigits(rtrim(sarray[1])) == 1)
                        return 1;
                    else
                        return 0;
                }

            }
        }
        else
        {
            return validateCoeff(s.trim());
        }
    }
    public int validateCoeff(String s)
    {
        if (s.contains("."))
        {
            String sarray[] = s.split("\\.");
            if (sarray.length != 2)
                return 0;
            else
            {
                if (s.charAt(0) == '.')
                {
                    if (sarray[1].charAt(0) == '+' || sarray[1].charAt(0) == '-')
                        return 0;
                    return validateDigits(sarray[1]);
                }
                else {
                    if (sarray[1].charAt(0) == '+' || sarray[1].charAt(0) == '-')
                        return 0;
                    if (validateDigits(sarray[0]) == 1 && validateDigits(sarray[1]) == 1)
                        return 1;
                    else
                        return 0;
                }
            }
        }
        else
        {
            return validateDigits(s);
        }
    }
    public int validateDigits(String s)
    {
        if (((s.contains("+") || s.contains("-")) && s.length() == 1)  || s.length() == 0)
            return 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0)
                    return 0;
                else
                    continue;
            }
            else if (!Character.isDigit(s.charAt(i)))
            {
                return 0;
            }
        }
        return 1;
    }
    public  String ltrim(String s) {
        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))){
            i++;
        }
        return s.substring(i);
    }

    public  String rtrim(String s) {
        int i = s.length()-1;
        while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        return s.substring(0,i+1);
    }
    public static void main(String args[])
    {
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber("  -45ee34 "));
    }
}
