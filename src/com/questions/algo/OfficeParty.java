package com.questions.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class OfficeParty
{
    public boolean isPossible(double[] area, double ar, int guests)
    {
        double current = area[0];
        int n = guests, i = 0;
        while (n > 0)
        {
            current = current - ar;
            if (current < 0)
            {
                i++;
                if (i == area.length)
                    return false;
                current = area[i];
            }
            else
                n--;

        }
        return true;
    }
    public String largestPiece(int[] radii, int guests)
    {
        double high = 0.0;
        double area[] = new double[radii.length];
        for (int i = 0; i < radii.length; i++)
        {
            area[i] = 3.14159265359 * radii[i] * radii[i];
            high = high < area[i] ? area[i] : high;
        }
        double low = 0.0, middle;
        while (low < high)
        {
            middle = (low + high) / 2.0;
            if (isPossible(area, middle, guests))
            {
                low = middle;
            }
            else
            {
                high = middle - 0.0001;
            }
        }
        DecimalFormat df = new DecimalFormat("#.####");
        return df.format(high);
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of elements in radii");
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] radii = new int[n];
        for (int i = 0; i < n; i++)
        {
            radii[i] = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.println("Enter the number of guests");
        int guests = Integer.parseInt(bufferedReader.readLine());
        OfficeParty officeParty = new OfficeParty();
        System.out.println(officeParty.largestPiece(radii, guests));

    }
}
