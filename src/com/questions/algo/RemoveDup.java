package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDup
{

    public int removeDuplicates(List<Integer> ar)
    {
        int i, j;
        boolean dup = false;
        int last = 0;
        if (!ar.get(ar.size() - 1).equals(ar.get(ar.size() - 2)))
            last++;
        for (i = 0; i < ar.size() - 1; i++)
        {
            if (ar.get(i).equals(ar.get(i + 1)))
            {
                dup = true;
                break;
            }
        }
        if (!dup)
            return ar.size();
        i = 0;
        for (j = i + 1; j < ar.size();)
        {
            while (ar.get(j).equals(ar.get(i))) {
                j++;
                if (j == ar.size()) {
                    break;
                }
            }
            if (j == ar.size())
                break;
            swap(i + 1, j, ar);
            j++;
            i++;
            System.out.println(ar);
        }
        System.out.println(i +"  " + j);
        return i + last;
    }

    public void swap(int i, int j, List<Integer> ar)
    {
        int temp = ar.get(i);
        ar.set(i, ar.get(j));
        ar.set(j, temp);
    }
    public static void main(String args[])
    {
        RemoveDup removeDup = new RemoveDup();
        List<Integer> ar = Arrays.asList(0, 0, 0, 1, 1, 2, 2, 3);
        //List<Integer> ar = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        System.out.println(removeDup.removeDuplicates(ar));
    }
}
