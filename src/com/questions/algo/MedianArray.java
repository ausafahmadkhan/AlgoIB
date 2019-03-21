package com.questions.algo;

import java.awt.image.VolatileImage;
import java.util.Arrays;
import java.util.List;

public class MedianArray
{
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b)
    {
        int total = a.size() + b.size();
        if (total % 2 == 0)
            return (getMedian(a, 0, b, 0, total / 2) + getMedian(a, 0, b, 0, total / 2 + 1)) / 2.0;
        else
            return getMedian(a, 0, b, 0, total / 2 + 1);
    }

    public int getMedian(List<Integer> a, int aCurrent, List<Integer> b, int bCurrent, int k)
    {
        if (aCurrent >= a.size())
            return b.get(bCurrent + k - 1);
        else if (bCurrent >= b.size())
            return a.get(aCurrent + k - 1);
        if (k == 1)
        {
            return Math.min(a.get(aCurrent), b.get(bCurrent));
        }
        int aKey = (aCurrent + k/2 - 1) >= a.size() ? Integer.MAX_VALUE : a.get(aCurrent + k/2 - 1);
        int bKey = (bCurrent + k/2 - 1) >= b.size() ? Integer.MAX_VALUE : b.get(bCurrent + k/2 - 1);

        if (aKey < bKey)
            return getMedian(a, aCurrent + k/2, b, bCurrent, k - k/2);
        else
            return getMedian(a, aCurrent, b, bCurrent + k/2, k - k/2);
    }
    public static void main(String args[])
    {
        MedianArray medianArray = new MedianArray();
        List<Integer> a = Arrays.asList(-49, 33, 35, 42 );
        List<Integer> b = Arrays.asList(-26);
        System.out.println(medianArray.findMedianSortedArrays(a, b));
    }
}
