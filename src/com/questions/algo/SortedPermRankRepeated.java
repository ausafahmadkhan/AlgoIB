package com.questions.algo;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SortedPermRankRepeated
{
    public BigInteger fact(long n)
    {
        if( n == 0 || n == 1)
        {
            return  BigInteger.ONE;
        }
        else
        {
            return BigInteger.valueOf(n).multiply(fact(n - 1));
            //return (n * fact(n - 1) % 1000003);
        }
    }

    public long findRank(String s)
    {
        HashMap<Character,Integer> h = new HashMap<>();
        char c;
        int i;
        BigInteger fac , count = BigInteger.ONE;


        //adding the characters in a hashmap
        //with their corresponding frequency
        for (i = 0; i < s.length(); i++)
        {
            c = s.charAt(i);
            if (h.containsKey(c))
                h.put(c, h.get(c) + 1);
            else
                h.put(c, 1);
        }

        //storing the characters in a collection
        System.out.println(h);
        char ch;

        for (i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            for (Map.Entry<Character,Integer> e : h.entrySet())
            {
                //if the frequency is 0, it means it is no longer in the string
                if (h.get(e.getKey()) == 0)
                    continue;

                //if the character 'ch' is smaller than current character 'c' in string
                //then decrease the freq of the smaller character 'ch' by 1
                //and calculate the total permutations possible with 'ch' as the first character
                // by iterating through the collection 'characters' again but with frequency
                // of 'ch' - 1 which gives total permutations possible with 'ch' as the first character
                if (e.getKey() < c) {
                    //decreasing freq so to make 'ch' as the first character
                    h.put(e.getKey(), h.get(e.getKey()) - 1);

                    //calculating total permutations possible with n - 1 characters
                    fac = fact(s.length() - 1 - i);

                    //for every character present in the hashmap 'h',
                    //if the frequency > 1, there are duplicates present
                    //hence dividing it by total fact of n - 1 characters
                    for (Map.Entry<Character,Integer> en : h.entrySet())
                    {
                        if (h.get(en.getKey()) > 1) {
                            fac = fac.divide(fact(h.get(en.getKey())));

                        }
                    }
                    count = count.add(fac);
                    count = count.remainder(BigInteger.valueOf(1000003));
                    //restoring the frequency of the current smaller character 'ch'
                    h.put(e.getKey(), h.get(e.getKey()) + 1);
                }

            }

            //removing the first character of the input string
            h.put(s.charAt(i), h.get(s.charAt(i)) - 1);
        }
        count.remainder(BigInteger.valueOf(1000003));
        return count.intValue();
    }
    public static void main(String args[])
    {
        SortedPermRankRepeated sortedPermRankRepeated = new SortedPermRankRepeated();
        System.out.println(sortedPermRankRepeated.findRank("sadasdsasassasas"));
        System.out.println(sortedPermRankRepeated.findRank("asasdsdsadasdadsadasdsa"));
    }

}
