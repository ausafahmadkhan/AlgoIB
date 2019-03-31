package com.questions.algo;

public class LengthLastWord
{
    public int lengthOfLastWord(final String s)
    {
        boolean started = false;
        int c = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) == ' ') {
                if (!started)
                    continue;
                else
                    break;
            }
            else
            {
                started = true;
                c++;
            }
        }
        return c;
    }
    public static void  main(String args[])
    {
        LengthLastWord lengthLastWord = new LengthLastWord();
        System.out.println(lengthLastWord.lengthOfLastWord("xDGBklKecz IAcOJYOH O WY WPi"));
    }
}
