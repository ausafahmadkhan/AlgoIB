package com.questions.algo;


public class RomanToNumber
{
    public int romanToInt(String s) {
        char ch;
        int num = 0, count = 0;
        for (int i = 0; i < s.length(); ) {
            ch = s.charAt(i);
            if (ch == 'M') {
                while (ch == 'M') {
                    count++;
                    i++;
                    if (i == s.length())
                        break;
                    ch = s.charAt(i);
                }
                num = count * 1000;
            } else if (ch == 'C') {
                if (i + 1 == s.length()) {
                    num = num + 100;
                    break;
                }
                if (s.charAt(i + 1) == 'M') {
                    num = num + 900;
                    i += 2;
                } else if (s.charAt(i + 1) == 'D') {
                    num = num + 400;
                    i += 2;
                } else {
                    count = 0;
                    while (ch == 'C') {
                        count++;
                        i++;
                        if (i == s.length())
                            break;
                        ch = s.charAt(i);
                    }
                    num = num + (count * 100);
                }
            } else if (ch == 'D') {
                if (i + 1 == s.length()) {
                    num = num + 500;
                    break;
                }
                if (s.charAt(i + 1) != 'C') {
                    num = num + 500;
                    i++;
                } else {
                    i++;
                    ch = s.charAt(i);
                    count = 0;
                    while (ch == 'C') {
                        count++;
                        i++;
                        if (i == s.length())
                            break;
                        ch = s.charAt(i);
                    }
                    num = num + (count * 100 + 500);
                }
            } else if (ch == 'X') {
                if (i + 1 == s.length()) {
                    num = num + 10;
                    break;
                }
                if (s.charAt(i + 1) == 'C') {
                    num = num + 90;
                    i += 2;
                } else if (s.charAt(i + 1) == 'L') {
                    num = num + 40;
                    i += 2;
                } else {
                    count = 0;
                    while (ch == 'X') {
                        count++;
                        i++;
                        if (i == s.length())
                            break;
                        ch = s.charAt(i);
                    }
                    num = num + (count * 10);
                }
            } else if (ch == 'L') {
                if (i + 1 == s.length()) {
                    num = num + 50;
                    break;
                }
                if (s.charAt(i + 1) != 'X') {
                    num = num + 50;
                    i++;
                } else {
                    i++;
                    ch = s.charAt(i);
                    count = 0;
                    while (ch == 'X') {
                        count++;
                        i++;
                        if (i == s.length())
                            break;
                        ch = s.charAt(i);
                    }
                    num = num + (count * 10 + 50);
                }
            } else if (ch == 'I') {
                if (i + 1 == s.length()) {
                    num = num + 1;
                    break;
                }
                if (s.charAt(i + 1) == 'X') {
                    num = num + 9;
                    i += 2;
                } else if (s.charAt(i + 1) == 'V') {
                    num = num + 4;
                    i += 2;
                } else {
                    count = 0;
                    while (ch == 'I') {
                        count++;
                        i++;
                        if (i == s.length())
                            break;
                        ch = s.charAt(i);
                    }
                    num = num + (count);
                }
            } else if (ch == 'V') {
                if (i + 1 == s.length()) {
                    num = num + 5;
                    break;
                }
                if (s.charAt(i + 1) != 'I') {
                    num = num + 5;
                    i++;
                } else {
                    i++;
                    ch = s.charAt(i);
                    count = 0;
                    while (ch == 'I') {
                        count++;
                        i++;
                        if (i == s.length())
                            break;
                        ch = s.charAt(i);
                    }
                    num = num + (count + 5);
                }
            }
        }
        return num;
    }
    public static void main(String args[])
    {
        RomanToNumber romanToNumber = new RomanToNumber();
        System.out.println(romanToNumber.romanToInt("MMCDLXXV"));
    }
}
