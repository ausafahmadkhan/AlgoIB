package com.questions.algo;

public class MakePalindromic
{
    public int solve(String s)
    {
        if (isPalindrome(s) == 1)
            return 0;
        int index = s.length() / 2;
        String pattern = s.substring(0, index);
        StringBuffer sb = new StringBuffer(pattern);
        sb.reverse();
        pattern = sb.toString();
        int patternIndex = searchPatternKMP(pattern, s, index);
        while (patternIndex - index > 1)
        {
            index--;
            if (index == 0)
                return s.length() - 1;
            pattern = s.substring(0, index);
            sb = new StringBuffer(pattern);
            sb.reverse();
            pattern = sb.toString();
            patternIndex = searchPatternKMP(pattern, s, index);
        }
        return s.length() - (patternIndex + pattern.length());
    }
    public int isPalindrome(String s)
    {
        int i = 0, j = s.length() - 1;
        char c1, c2;
        s = s.toLowerCase();
        System.out.println(s);
        while (i < j)
        {
            c1 = s.charAt(i);
            c2 = s.charAt(j);
            if (!Character.isLetterOrDigit(c1))
            {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(c2))
            {
                j--;
                continue;
            }
            if (c1 != c2)
                return 0;
            else
            {
                i++;
                j--;
            }
        }
        return 1;
    }
    public void constructArray(String pattern, int[] ar)
    {
        ar[0] = 0;
        int j = 0;
        for (int i = 1; i < pattern.length();)
        {
            if (pattern.charAt(i) == pattern.charAt(j))
            {
                ar[i] = j + 1;
                i++;
                j++;
            }
            else
            {
                if (j != 0)
                {
                    j = ar[j - 1];
                }
                else
                {
                    ar[i] = 0;
                    i++;
                }
            }
        }
    }
    public int searchPatternKMP(String pattern, String text, int fromIndex)
    {
        int ar[] = new int[pattern.length()];
        constructArray(pattern, ar);
        text = text.substring(fromIndex);
        int i, j = 0;
        for (i = 0; i < text.length() && j < pattern.length();)
        {
            if (text.charAt(i) == pattern.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                if (j != 0 ) {
                    j = ar[j - 1];
                }
                else {
                    i++;
                }
            }
        }
        if (j == pattern.length())
            return i + fromIndex - pattern.length();
        else return Integer.MAX_VALUE;
    }


    //method2
    public int solve2(String A) {
        int n = A.length();
        int ans = n;
        while(n>1 && !isPalindrome(A, n)) {
            n--;
        }
        return ans-n;
    }
    public boolean isPalindrome(String A, int len) {
        int i=0, j=len-1;
        while(i<=j && (A.charAt(i) == A.charAt(j))) {
            i++;j--;
        }
        if(i>j) {
            return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        MakePalindromic makePalindromic = new MakePalindromic();
        //System.out.println(makePalindromic.searchPatternKMP("t","mmtatbdzqsoemuvnpppsu", 0));
        System.out.println(makePalindromic.solve("Abc"));
    }
}
