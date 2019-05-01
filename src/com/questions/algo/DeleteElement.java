package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteElement
{
    public int delete(List<Integer> ar, int n)
    {
        boolean present = false;
        if (ar.size() == 1 && ar.get(0) == n)
            return 0;
        int i, j = 1;
        for (i = 0; j < ar.size();)
        {
            if (ar.get(i).equals(n))
            {
                present = true;
                while (ar.get(j).equals(n))
                {
                    j++;
                    if (j == ar.size())
                        break;
                }
                if (j == ar.size())
                    break;
                swap(i, j, ar);
                i++;
                System.out.println(ar);
            }
            else {
                i++;
                j++;
            }
        }
        System.out.println(ar);
        return present ? i : i + 1;
    }

    public void swap(int i, int j, List<Integer> ar)
    {
        int temp = ar.get(i);
        ar.set(i, ar.get(j));
        ar.set(j, temp);
    }
    public static void main(String args[])
    {
        DeleteElement deleteElement = new DeleteElement();
        List<Integer> ar = Arrays.asList(2, 1, 1, 2, 1, 1, 2, 0, 3, 2, 1, 1, 3, 3, 3, 1, 2, 1, 3, 3, 2);
        System.out.println(deleteElement.delete(ar, 5));
    }
}
