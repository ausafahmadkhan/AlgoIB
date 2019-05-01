package com.questions.algo;

import java.util.*;

public class ArrayIntersection
{
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b)
    {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < a.size() && j < b.size())
        {
            if (a.get(i) < b.get(j))
                i++;
            else if (a.get(i) > b.get(j))
                j++;
            else {
                result.add(a.get(i));
                i++;
                j++;
            }
        }
        return result;
    }
    public static void main(String args[])
    {
        ArrayIntersection arrayIntersection = new ArrayIntersection();
        List<Integer> a = Arrays.asList(1, 2, 3, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> b = Arrays.asList(3, 3, 9, 11);
        System.out.println(arrayIntersection.intersect(a, b));
    }
}
