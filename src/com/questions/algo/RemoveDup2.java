package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDup2
{
    public int removeDuplicates(ArrayList<Integer> ar)
    {
        if (ar.size() < 3)
            return ar.size();
        int third = ar.size() - 1;
        int second = ar.size() - 2;
        for (int first = ar.size() - 3; first >= 0 ;)
        {
            if (ar.get(first).equals(ar.get(second)) && ar.get(first).equals(ar.get(third))) {
                ar.remove(first);
            }
            first--;
            second--;
            third--;
        }
        return ar.size();
    }
    public static void main(String args[])
    {
        RemoveDup2 removeDup = new RemoveDup2();
        List<Integer> ar = Arrays.asList(0);
        //List<Integer> ar = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
              //  0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer i : ar)
        {
            arrayList.add(i);
        }
        System.out.println(removeDup.removeDuplicates(arrayList));
    }
}
