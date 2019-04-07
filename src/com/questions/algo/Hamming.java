package com.questions.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hamming
{
	public int compare(String a, String b)
	{
		int count = 0, i = 0, j = 0;
		while (i < a.length() || j < b.length())
		{
			if (i >= a.length() && b.charAt(j) == '1')
				count++;
			else if (j >= b.length() && a.charAt(i) == '1')
				count++;
			else if (i < a.length() && j < b.length() && a.charAt(i) != b.charAt(j))
				count++;
			i++;
			j++;
		}
		return count;
	}
	public int hammmingDistance(final List<Integer> ar)
    {
		ArrayList<String> b = new ArrayList<String>();
		for(int i = 0; i < ar.size(); i++)
		{
			StringBuffer st = new StringBuffer();
			int t = ar.get(i);
			while(t != 0)
			{
				st.append(t % 2);
				t = t / 2;
			}
			b.add(st.toString());
		}
		int count = 0;
		for(int i = 0; i < ar.size() - 1; i++)
		{
			for(int j = i + 1; j < ar.size(); j++)
			{
				count = count + compare(b.get(i), b.get(j));
			}
		}
		return (count * 2) % 1000000007;
	}
	public int hammingDistance(final List<Integer> A) 
	{
	        int n = A.size();
	        int dist = 0;
	        for(int i = 0; i < 31; i++) {
	            int oneCount = 0;
	            for(int j = 0; j < n; j++) {
	                int num = A.get(j);
	                oneCount += (num & 1 << i) != 0? 1 : 0;
	            }
	            int zeroCount = n - oneCount;
	            dist += (2L * oneCount * zeroCount) % 1000000007;
	            dist = dist % 1000000007;
	        }
	        return dist;
	    }
	public static void main(String args[])
	{
		Hamming h = new Hamming();
		List<Integer> ar = Arrays.asList(2, 2, 2);
		System.out.println(h.hammingDistance(ar));
	}
}
