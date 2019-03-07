package com.questions.algo;

public class GridUnique
{
    public int uniquePath(int i, int j, int X, int Y)
    {
        if (i > X || j > Y)
            return 0;
        else if (i == X && j == Y)
            return 1;
        else
            return uniquePath(i + 1, j, X, Y) + uniquePath(i, j+1, X, Y);
    }
    public int uniquePaths(int A, int B)
    {
        int count = uniquePath(0,0, A - 1, B - 1);
        return  count;
    }
    public static void main(String args[])
    {
        GridUnique gridUnique = new GridUnique();
        System.out.println(gridUnique.uniquePaths(1,100));
    }
}
