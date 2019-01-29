package com.questions.algo;

import java.util.ArrayList;

public class EpicSystems
{
	public boolean isPrime(int n)
	{
		int c = 0;
		for (int i = 1; i <= n/2; i++)
		{
			if (n % i == 0)
				c++;
		}
		if (c == 1)
			return true;
		
		
		return false;
	}
	public ArrayList<Integer> epic(int n)
	{
		boolean found = false;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 2; i <= n/2; i++)
		{
			if (isPrime(i) && isPrime(n - i))
			{
				found = true;
				ar.add(i);
				ar.add(n - i);
			}
			if(found)
				break;
		}
		return ar;
	}
	public static void main(String args[])
	{
		EpicSystems es = new EpicSystems();
		System.out.println(es.epic(68));
	}
}
