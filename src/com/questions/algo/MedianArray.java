package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianArray
{
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b)
    {
        if (a.size() == 0 && b.size() == 0)
            return 0;
        else if (a.size() == 0)
        {
            if(b.size() % 2 == 0)
            {
                return (b.get((b.size() - 1)/2) + b.get((b.size() - 1)/2 +1)) / 2.0;
            }
            else {
                return b.get(b.size()/2);
            }
        }
        else if (b.size() == 0)
        {
            if(a.size() % 2 == 0)
            {
                return (a.get((a.size() - 1)/2) + a.get((a.size() - 1)/2 +1)) / 2.0;
            }
            else {
                return a.get(a.size()/2);
            }
        }
        double res = getMedian(a, b);
        return  res != Integer.MIN_VALUE ? res : getMedian(b, a);
    }
    public int getInsertPos(List<Integer> ar, int key)
    {
        int l = 0, h = ar.size() - 1, mid;
        while (l <= h)
        {
            mid = (l + h) / 2;
            if (ar.get(mid) >= key)
            {
                h = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return l;
    }

    public double getMedian(List<Integer> a, List<Integer> b)
    {
        int totalLength = a.size() + b.size();
        int leftLength, rightLength;
        int l = 0, h = a.size() - 1, mid;
        while (l <= h)
        {
            mid = (l + h) / 2;
            int temp = getInsertPos(b, a.get(mid));
            leftLength = mid + temp;
            rightLength = totalLength - leftLength;
            if (leftLength == rightLength || Math.abs(leftLength - rightLength) == 1)
            {
                if (leftLength > rightLength)
                {
                    if (mid == 0)
                        return b.get(temp - 1);
                    else if (temp == 0)
                        return a.get(mid - 1);
                    else
                    {
                        return a.get(mid - 1) > b.get(temp - 1) ? a.get(mid - 1) : b.get(temp - 1);
                    }
                }
                else if (leftLength < rightLength)
                {
                    return a.get(mid);
                }
                else
                {
                    int leftLast;
                    if (mid == 0)
                        leftLast = b.get(temp - 1);
                    else if (temp == 0)
                        leftLast = a.get(mid - 1);
                    else
                    {
                        leftLast = a.get(mid - 1) > b.get(temp - 1) ? a.get(mid - 1) : b.get(temp - 1);
                    }
                    return (a.get(mid) + leftLast) / 2.0;
                }
            }
            else if (leftLength < rightLength)
            {
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }
    public static void main(String args[])
    {
        MedianArray medianArray = new MedianArray();
        List<Integer> a = Arrays.asList(-48, -43, 46);
        List<Integer> b = Arrays.asList( 18, 29 );
        System.out.println(medianArray.findMedianSortedArrays(a, b));
    }
}
