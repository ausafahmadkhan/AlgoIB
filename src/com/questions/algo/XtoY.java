package com.Algo;

public class XtoY 
{
	public boolean isPower(int n)
	{
		int temp, rem = 0;
		for(int i = n/2; i > 1; i--)
		{
			temp = n;
			rem = 0;
			if(n % i == 0)
			{
				while(temp != 0 && rem == 0)
				{
					temp = temp / i; 
					rem = temp % i;
					if(temp == 1)
					{
						System.out.println(i);
						return true;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) 
	{
		XtoY obj = new XtoY();
		System.out.println(obj.isPower(324));
	}

}
