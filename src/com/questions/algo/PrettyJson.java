package com.questions.algo;

import java.util.ArrayList;
import java.util.List;

public class PrettyJson
{
    public ArrayList<String> prettyJSON(String s)
    {
        ArrayList<String> ar = new ArrayList<>();
        int ntabs = 0, j = -1;
        char ch;
        for (int i = 0; i < s.length(); i++)
        {
            ch = s.charAt(i);
            if (ch == '{' || ch == '[')
            {
                ar.add("");
                j++;
                indent(ar, ntabs, j);
                ar.set(j, ar.get(j) + ch);
                ntabs++;
                if (s.charAt(i + 1) != '{' && s.charAt(i+ 1) != '[') {
                    ar.add("");
                    j++;
                    indent(ar, ntabs, j);
                }
            }
            else if (ch == '}' || ch == ']')
            {
                ar.add("");
                j++;
                ntabs--;
                indent(ar, ntabs, j);
                ar.set(j, ar.get(j) + ch);
            }
            else
            {
                ar.set(j, ar.get(j) + ch);
                if (ch == ',' && s.charAt(i + 1) != '{' && s.charAt(i + 1) != '[' && s.charAt(i + 1) != ' ')
                {
                    ar.add("");
                    j++;
                    indent(ar, ntabs, j);
                }
            }
        }
        return ar;
    }
    public void indent(List<String> strings, int numTabs, int index)
    {
        for (int i = 0; i < numTabs; i++)
        {
            strings.set(index, strings.get(index) + "\t");
        }
    }
    public static void main(String args[])
    {
        PrettyJson prettyJson = new PrettyJson();
        List<String> ar = prettyJson.prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
        for (String s : ar)
        {
            System.out.println(s);
        }
    }
}
