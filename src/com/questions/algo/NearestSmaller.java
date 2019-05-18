package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NearestSmaller
{
    public ArrayList<Integer> prevSmaller(List<Integer> ar)
    {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < ar.size(); i++)
        {
            if (stack.isEmpty())
            {
                result.add(-1);
                stack.push(ar.get(i));
            }
            else
            {
                if (ar.get(i) <= stack.peek())
                {
                    while (!stack.isEmpty() && ar.get(i) <= stack.peek())
                    {
                        stack.pop();
                    }
                    if (stack.isEmpty())
                    {
                        result.add(-1);
                    }
                    else
                    {
                        result.add(stack.peek());
                    }
                }
                else
                {
                    result.add(stack.peek());
                }
                stack.push(ar.get(i));
            }
        }
        return result;
    }
    public static void main(String args[])
    {
        NearestSmaller nearestSmaller = new NearestSmaller();
        List<Integer> ar = Arrays.asList(39, 27, 11, 4, 24, 32, 32, 1 );
        System.out.println(nearestSmaller.prevSmaller(ar));
    }
}
