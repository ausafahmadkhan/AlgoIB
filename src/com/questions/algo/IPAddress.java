package com.questions.algo;

import java.util.*;

public class IPAddress
{
    public class CompareVersion implements Comparator<String> {
        public int compare(String ver1, String ver2) {
            String s1[] = ver1.split("\\.");
            String s2[] = ver2.split("\\.");
            int temp1, temp2;
            int l = s1.length > s2.length ? s1.length : s2.length;
            for (int i = 0; i < l; ) {
                if (i == s1.length) {
                    return -1;
                } else if (i == s2.length) {
                    return 1;
                }
                temp1 = Integer.parseInt(s1[i]);
                temp2 = Integer.parseInt(s2[i]);
                if (temp1 > temp2)
                    return 1;
                else if (temp1 < temp2)
                    return -1;
                else
                    i++;
            }
            return 0;
        }
    }
    public List<String> restoreIpAddresses(String s)
    {
        Set<String> ar = new HashSet<>();
        getIP(s, 0, "", 1, ar);
        getIP(s, 0, "", 2, ar);
        getIP(s, 0, "", 3, ar);
        List<String> arr = new ArrayList<>();
        for (String st : ar)
        {
            arr.add(st);
        }
        CompareVersion compareVersion = new CompareVersion();
        Collections.sort(arr, compareVersion);
        return arr;
    }
    public String getIP(String s, int startPos, String ip, int noOfDigits, Set<String> ar)
    {
        if (startPos == s.length())
            return ip;
        if (s.charAt(startPos) == '0' && noOfDigits != 1)
            return "";
        String temp = "";
        while (noOfDigits > 0)
        {
            if (startPos == s.length())
                return "";
            temp += s.charAt(startPos);
            startPos++;
            noOfDigits--;
        }
        if (Integer.parseInt(temp) > 255)
            return "";
        ip += temp;
        ip += ".";
        String ip1 = getIP(s, startPos, ip, 1, ar);
        if (ip1 != "" && ip1.length() == s.length() + 4)
            ar.add(ip1.substring(0, ip1.length() - 1));
        String ip2 = getIP(s, startPos, ip, 2, ar);
        if (ip2 != "" && ip2.length() == s.length() + 4)
            ar.add(ip2.substring(0, ip2.length() - 1));
        String ip3 = getIP(s, startPos, ip, 3, ar);
        if (ip3 != "" && ip3.length() == s.length() + 4)
            ar.add(ip3.substring(0, ip3.length() - 1));
        return "";
    }
    public static void main(String args[])
    {
        IPAddress ipAddress = new IPAddress();
        System.out.println(ipAddress.restoreIpAddresses("73426183"));
    }
}