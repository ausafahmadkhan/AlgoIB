package com.questions.algo;
import java.io.*;
import java.util.*;

//Wrong Solution





public class ManhattanMatrix {

    private static boolean marked[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());
            marked = new boolean[N][M];
            int[][] A = new int[N][M];
            for(int i_A=0; i_A<N; i_A++)
            {
                String[] arr_A = br.readLine().split(" ");
                for(int j_A=0; j_A<arr_A.length; j_A++)
                {
                    A[i_A][j_A] = Integer.parseInt(arr_A[j_A]);
                }
            }
            int sx = Integer.parseInt(br.readLine().trim());
            int sy = Integer.parseInt(br.readLine().trim());
            int Q = Integer.parseInt(br.readLine().trim());
            String[] arr_x = br.readLine().split(" ");
            int[] x = new int[Q];
            for(int i_x=0; i_x<arr_x.length; i_x++)
            {
                x[i_x] = Integer.parseInt(arr_x[i_x]);
            }
            String[] arr_y = br.readLine().split(" ");
            int[] y = new int[Q];
            for(int i_y=0; i_y<arr_y.length; i_y++)
            {
                y[i_y] = Integer.parseInt(arr_y[i_y]);
            }

            int[] out_ = solve(A, x, sy, sx, y);
            System.out.print(out_[0]);
            for(int i_out_=1; i_out_<out_.length; i_out_++)
            {
                System.out.print(" " + out_[i_out_]);
            }
            System.out.println();
        }

        wr.close();
        br.close();
    }
    public static int traverse(int ar[][], int x, int y, int a, int b, int n, int m, int count)
    {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return -1;
        if (x == a && y == b)
            return count;
        if (marked[x][y])
            return -1;
        marked[x][y] = true;
        int val, temp = ar[x][y];
        for (int i = 1; i <= temp; i++)
        {
            val = traverse(ar, x + i, y, a, b, n , m, count + 1);
            if (val != -1)
                return val;
        }
        for (int i = 1; i <= temp; i++)
        {
            val = traverse(ar, x - i, y, a, b, n , m, count + 1);
            if (val != -1)
                return val;
        }
        for (int i = 1; i <= temp; i++)
        {
            val = traverse(ar, x , y + i, a, b, n , m, count + 1);
            if (val != -1)
                return val;
        }
        for (int i = 1; i <= temp; i++)
        {
            val = traverse(ar, x, y - i, a, b, n , m, count + 1);
            if (val != -1)
                return val;
        }
        return -1;
    }
    static int[] solve(int[][] A, int[] x, int sy, int sx, int[] y)
    {
        // Write your code here
        int []out = new int[x.length];
        for (int i = 0; i < x.length; i++)
        {
            out[i] = traverse(A, sx - 1, sy -1, x[i] - 1, y[i] - 1, A.length, A[i].length, 0);
        }
        return out;
    }
}