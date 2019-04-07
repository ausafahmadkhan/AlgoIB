package com.questions.algo;

import com.sun.xml.internal.ws.server.ServerRtException;

import java.util.ArrayList;

public class ZigZagString
{
    public String convert(String text, int nRows)
    {
        if (nRows == 1)
            return text;
        StringBuffer[] strings = new StringBuffer[nRows];
        int i, j = 0;
        for (i = 0; i < strings.length; i++)
        {
            strings[i] = new StringBuffer();
        }
        boolean reverse = false;
        for (i = 0; i < text.length();)
        {
            if (!reverse)
            {
                while (j < nRows)
                {
                    strings[j].append(text.charAt(i));
                    i++;
                    if (i == text.length())
                        break;
                    j++;
                }
                j -= 2;
                reverse = true;

            }
            else
            {
                while (j >= 0)
                {
                    strings[j].append(text.charAt(i));
                    i++;
                    if (i == text.length())
                        break;
                    j--;
                }
                j += 2;
                reverse = false;
            }
        }
        StringBuffer temp = new StringBuffer();
        for (i = 0; i < strings.length; i++)
        {
            temp.append(strings[i]);
            System.out.println(strings[i]);
        }
        return temp.toString();
    }
    public static void main(String args[])
    {
        ZigZagString zigZagString = new ZigZagString();
        System.out.println(zigZagString.convert("kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS", 20));
    }
}
