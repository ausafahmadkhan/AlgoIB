package com.questions.algo;

public class AmazingSubArrays
{
    public int solve(String s)
    {
        char ch;
        int count = 0;
        for (int i = 0; i < s.length(); i++)
        {
            ch = s.charAt(i);
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' ||
                    ch == 'i' || ch == 'o' || ch == 'u')
            {
                count = count + (s.length() - i);
                count %= 10003;
            }
        }
        return count % 10003;
    }
    public static void main(String args[])
    {
        AmazingSubArrays amazingSubArrays = new AmazingSubArrays();
        System.out.println(amazingSubArrays.solve("ABEhdvqewdhvhjfeifhvhjcukeC"));
    }
}
