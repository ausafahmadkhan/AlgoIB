package com.questions.algo;

public class CountAndSay
{
    public String countAndSay(int n)
    {
        String s = "1";
        if (n == 1)
            return s;
        for (int i = 2; i <= n; i++)
        {
            s = getNext(s);
        }
        return s;
    }
    public String getNext(String n)
    {
        if (n.length() == 1)
            return "1"+n.charAt(0);
        StringBuffer sb = new StringBuffer();
        int i, c = 1;
        for (i = 0; i < n.length() - 1; i++)
        {
            if (n.charAt(i) == n.charAt(i + 1))
            {
                c++;
            }
            else
            {
                sb.append(c+ "" + n.charAt(i));
                c = 1;
            }
        }
        if (n.charAt(i) != n.charAt(i - 1))
            sb.append("1"+ n.charAt(i));
        else
            sb.append(c +""+ n.charAt(i));
        return sb.toString();
    }
    public static void main(String args[])
    {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.getNext("2"));
    }
}
