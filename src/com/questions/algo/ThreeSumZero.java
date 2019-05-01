package com.questions.algo;

import java.util.*;

public class ThreeSumZero
{
    public ArrayList<ArrayList<Integer>> threeSum(List<Integer> ar)
    {
        Collections.sort(ar);
        int sum, j, k;
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr;
        for (int i = 0; i < ar.size() - 2; i++)
        {
            j = i + 1;
            k = ar.size() - 1;
            while (j < k) {
                sum = ar.get(i) + ar.get(j) + ar.get(k);
                if (sum == 0)
                {
                    arr = new ArrayList<>();
                    arr.add(ar.get(i));
                    arr.add(ar.get(j));
                    arr.add(ar.get(k));
                    if (set.contains(arr))
                    {
                        j++;
                        continue;
                    }
                    else
                    {
                        set.add(arr);
                        arrayList.add(arr);
                    }
                }
                if (sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return arrayList;
    }
    public static void main(String args[])
    {
        ThreeSumZero threeSumZero = new ThreeSumZero();
        List<Integer> ar = Arrays.asList( 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 );
        System.out.println(threeSumZero.threeSum(ar));
    }
}
