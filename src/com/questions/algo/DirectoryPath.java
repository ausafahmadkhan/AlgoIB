package com.questions.algo;

import java.util.Stack;

public class DirectoryPath
{
    public String simplify(String s)
    {
        char ch;
        Stack<String> stack = new Stack<>();
        StringBuffer stringBuffer;
        for (int  i = 0; i < s.length(); i++)
        {
            ch = s.charAt(i);
            if (ch == '/' ) {
                if (i + 1 == s.length())
                    break;
                if (Character.isLetter(s.charAt(i + 1))) {
                    stringBuffer = new StringBuffer();
                    i++;
                    ch = s.charAt(i);
                    while (Character.isLetter(ch)) {
                        stringBuffer.append(ch);
                        i++;
                        if (i == s.length())
                            break;
                        ch = s.charAt(i);
                    }
                    stack.push(stringBuffer.toString());
                    i--;
                }
            }
            else if (ch == '.')
            {
                if (i + 1 == s.length())
                    break;
                if (s.charAt(i+1) == '.')
                {
                    if (stack.isEmpty())
                        continue;
                    stack.pop();
                    i++;
                }
            }
        }
        stringBuffer = new StringBuffer();
        if (stack.isEmpty())
        {
            return "/";
        }
        while (!stack.isEmpty())
        {
            stringBuffer.insert(0,"/" + stack.pop());
        }
        return stringBuffer.toString();
    }
    public static void main(String args[])
    {
        DirectoryPath directoryPath = new DirectoryPath();
        System.out.println(directoryPath.simplify("/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/.."));
    }
}
