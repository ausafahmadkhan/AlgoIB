package com.questions.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tournament
{
    public static int draw(String s1, String s2)
    {
        char ch;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
        {
            ch = s1.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        int countDraw = 0;
        for (int i = 0; i < s2.length(); i++)
        {
            ch = s2.charAt(i);
            if (map.containsKey(ch) && map.get(ch) > 0)
            {
                countDraw++;
                map.put(ch, map.get(ch) - 1);
            }
        }
        return countDraw;
    }

    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int rounds;
        char ch;
        ArrayList<Integer> ar = new ArrayList<>();
        String s1, s2;
        for (int i = 0; i < t; i++)
        {
            rounds = sc.nextInt();
            s1 = sc.nextLine();
            s2 = sc.nextLine();
            ar.add(draw(s1, s2));
        }
        for (Integer i : ar)
        {
            System.out.println(i);
        }
    }
}
