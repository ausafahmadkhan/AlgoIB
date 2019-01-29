package com.questions.algo;


import java.util.ArrayList;
import java.util.Collections;

public class SortedPermRank
{
    public int fact(int n)
    {
        if( n == 0 || n == 1)
        {
            return  1;
        }
        else
        {
            return (n * fact(n - 1)) % 1000003;
        }
    }
    public int getRank(char c, ArrayList<Character> ar)
    {
        int l = 0, u = ar.size() - 1;
        int mid;
        while(l <= u)
        {
            mid = (l + u) / 2;
            if(ar.get(mid) == c)
                return mid + 1;
            else if (ar.get(mid) > c)
                u = mid - 1;
            else if (ar.get(mid) < c)
                l = mid + 1;
        }
        return 0;
    }
    public long getPos(ArrayList<Character> ar, String s, int index)
    {
        long buckets = fact(ar.size());
        long bucketSize = buckets / ar.size();
        if (ar.size() == 1)
            return 1;
        else
        {
            int t = getRank(s.charAt(index),ar);
            long pos = (t - 1) * bucketSize;
            pos %= 1000003;
            ar.remove(t - 1);
            return pos + getPos(ar, s, index + 1);
        }
    }
    public int findRankk(String s)
    {
        ArrayList<Character> ar = new ArrayList<>();
        for(int i = 0; i < s.length(); i++)
        {
            ar.add(s.charAt(i));
        }
        Collections.sort(ar);
        long pos = getPos(ar,s,0);
        int position = (int) pos % 1000003;
        return position;

    }

    //Method 2

    public int countLesserRight(String s, int index)
    {
        int i = index + 1, count = 0;
        while(i < s.length())
        {
            if(s.charAt(index) > s.charAt(i))
                count++;
            i++;
        }
        return count;
    }
    public int findRank(String s)
    {
        int rank = 0, length = s.length();
        for(int i = 0; i < s.length() - 1; i++)
        {
            rank += countLesserRight(s,i) * fact(length - 1);
            rank %= 1000003;
            length--;
        }
        return rank + 1;
    }
    public static void main(String args[])
    {
        SortedPermRank sortedPermRank = new SortedPermRank();
        System.out.println(sortedPermRank.findRank("ZCSFLVHXRYJQKWABGT"));
        System.out.println(sortedPermRank.findRankk("ZCSFLVHXRYJQKWABGT"));
    }
}
