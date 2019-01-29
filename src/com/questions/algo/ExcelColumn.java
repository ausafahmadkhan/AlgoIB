package com.questions.algo;

public class ExcelColumn
{
    public int titleToNumber(String a) {
        int num = 0;
        for (int i = a.length() - 1, j = 0; i >= 0; i--) {
            num += (int) Math.pow(26, j) * (a.charAt(i) - 'A' + 1);
            j++;
        }
        return num;
    }

    public  static void main(String args[])
    {
        ExcelColumn excelColumn = new ExcelColumn();
        System.out.println(excelColumn.titleToNumber("ZQBZCD"));
    }
}
