package com.questions.algo;

public class ReverseString
{
    public String reverseWords(String s)
    {
        s.trim();
        s += ' ';
        String temp = "";
        boolean inserted = false;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
            {
                if (!inserted)
                {
                    stringBuffer.insert(0, temp + ' ');
                    temp = "";
                    inserted = true;
                }
                else
                    continue;
            } else {
                inserted = false;
                temp += s.charAt(i);
            }
        }
        return stringBuffer.toString().trim();
    }
    public static void main(String args[])
    {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseWords("hi hello how are you"));
    }
}
