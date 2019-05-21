package com.questions.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Ranges
{

    private static Set<Long> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String input1 = br.readLine().trim();
        String[] input = input1.split(" ");
        long N = Long.parseLong(input[0]);
        long M = Long.parseLong(input[1]);
        set = new HashSet();
        while(M > 0){
            long X = Long.parseLong(br.readLine().trim());
            long out_ = getOutput(N, X);
            System.out.println(out_);
            M--;
        }
        wr.close();
        br.close();
    }
    static long getOutput(long N, long M){
        // Write your code here
        set.add(M);
        long sum = 0L;
        long i = 1, leftindex = 1, rightindex, temp = 1;
        boolean crossed = false;
        while(i <= N)
        {
            if (set.contains(i))
            {
                if (!crossed)
                {
                    crossed = true;
                    temp = i + 1;
                    i++;
                }
                else
                {
                    crossed = false;
                    rightindex = i - 1;
                    sum = sum + leftindex + rightindex;
                    leftindex = temp;
                }
            }
            else
            {
                i++;
            }
        }
        sum = sum + leftindex + N;
        return sum;
    }
}
