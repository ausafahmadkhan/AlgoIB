package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PainterProblem {

    public int solve(int N, int T, List<Integer> ar)
    {
        int max = 0;
        for(int i = 0; i < ar.size(); i++)
        {
            max +=(int)(((long)ar.get(i))%10000003);
            max = max%10000003;
        }

        int mid, l = 0, h = max;
        while(l < h)
        {
            mid = (l + h) / 2;
            if(isPossible(N, mid, ar))
                h = mid;
            else
                l = mid + 1;
        }
        return  (int)(((long)h*T)%10000003);
    }
    public boolean isPossible(int N, long desiredTime, List<Integer> ar)
    {
        int currentTime = 0, p = 1;
        for(int i = 0; i < ar.size(); i++)
        {
            currentTime += ar.get(i);
            if(currentTime > desiredTime)
            {
                p++;
                currentTime = ar.get(i);
                if(currentTime > desiredTime || p > N)
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        PainterProblem painterProblem = new PainterProblem();
        List<Integer> ar = Arrays.asList(1000000, 1000000);
        System.out.println(painterProblem.solve(1, 1000000, ar));
    }
}
