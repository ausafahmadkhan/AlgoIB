package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JustifiedText
{
    public List<String> fullJustify(List<String> s, int L)
    {
        int sum = 0, j = 0;
        List<String> ar = new ArrayList<>();
        if (s.size() == 0)
            return ar;
        for (int i = 0; i < s.size(); i++)
        {
            if (sum == 0) {
                ar.add(s.get(i));
            }
            else if (sum + s.get(i).length() < L)
            {
                ar.set(j, ar.get(j) + " " + s.get(i));
                sum++;
            }
            else
            {
                sum = 0;
                i--;
                j++;
                continue;
            }
            sum = sum + s.get(i).length();
        }
        for (String str : ar)
        {
            System.out.println(str);
            System.out.println(str.length());
        }
        padString(ar, L);
        return ar;
    }
    public void padString(List<String> a, int L)
    {
        int spaces,i, j;
        for (i = 0; i < a.size() - 1; i++) {
            if (a.get(i).length() == L)
                continue;
            else {
                spaces = L - a.get(i).length();
                String temp = "";
                boolean spacepresent = false;
                for (j = 0; j < a.get(i).length(); ) {
                    if (a.get(i).charAt(j) == ' ' && a.get(i).charAt(j + 1) != ' ' && spaces > 0) {
                        spacepresent = true;
                        temp += ' ';
                        temp += ' ';
                        spaces--;
                    } else {
                        temp += a.get(i).charAt(j);
                    }
                    j++;
                    if (j == a.get(i).length() && spaces > 0) {
                        if (!spacepresent)
                            break;
                        a.set(i, temp);
                        temp = "";
                        j = 0;
                    }
                }
                if (!spacepresent) {
                    for (j = 0; j < spaces; j++) {
                        temp += ' ';
                    }
                }
                a.set(i, temp);
            }
        }
        spaces = L - a.get(i).length();
        String temp = "";
        for (j = 0; j < spaces; j++)
        {
            temp = temp + ' ';
        }
        a.set(i,a.get(i) + temp);
    }
    public static void main(String args[])
    {
        JustifiedText justifiedText = new JustifiedText();
        List<String> st = Arrays.asList("glu", "muskzjyen", "ahxkp", "t", "djmgzzyh", "jzudvh", "raji", "vmipiz", "sg", "rv", "mekoexzfmq", "fsrihvdnt", "yvnppem", "gidia", "fxjlzekp", "uvdaj", "ua", "pzagn", "bjffryz", "nkdd", "osrownxj", "fvluvpdj", "kkrpr", "khp", "eef", "aogrl", "gqfwfnaen", "qhujt", "vabjsmj", "ji", "f", "opihimudj", "awi", "jyjlyfavbg", "tqxupaaknt", "dvqxay", "ny", "ezxsvmqk", "ncsckq", "nzlce", "cxzdirg", "dnmaxql", "bhrgyuyc", "qtqt", "yka", "wkjriv", "xyfoxfcqzb", "fttsfs", "m");
        st = justifiedText.fullJustify(st,144 );
        for (String s : st)
        {
            System.out.println(s);
            System.out.println(s.length());
        }
    }

}
