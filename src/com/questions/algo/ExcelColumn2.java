package com.questions.algo;

import java.util.ArrayList;

public class ExcelColumn2 {
    public String convertToTitle(int n)
    {
        int i = 1, div = 0,d = 0,t = n, r = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while(t != 0)
        {
            t = t / 26;
            d++;
        }
        t = n;
        while(t != 0)
        {
            div = t / (int) Math.pow(26, i);
            r = t % (int) Math.pow(26, i);
            r = r / (int) Math.pow(26,i - 1);
            if(r == 0)
            {
                if(i != d) {
                    r = 26;
                    div--;
                    i--;
                }
                else
                {
                    r = div;
                    div = 0;
                }
            }
            t = div * (int) Math.pow(26, i);
            stringBuffer.append((char) (r + 64));
            i++;
        }
        stringBuffer.reverse();
        return stringBuffer.toString();
    }
    public String convertToTitle2(int n)
    {
        int t = n,r = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while(t != 0)
        {
            r = t % 26;
            t = t / 26;
            if(r == 0)
            {
                r = 26;
                t--;
            }
            stringBuffer.append((char)(r + 64));
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String args[]) {
        ExcelColumn2 excelColumn = new ExcelColumn2();
        System.out.println(excelColumn.convertToTitle2(943566));
    }
}
