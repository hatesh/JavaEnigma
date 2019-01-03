package Util;

public class CharUtil {
    public static char[] arrayCombine(char[] c1, char[] c2) {
        char[] rtn = new char[c1.length + c2.length];
        int counter  = 0;
        for (int i = 0; i < c1.length; i++, counter++) rtn[counter] = c1[i];
        for (int i = 0; i < c2.length; i++, counter++) rtn[counter] = c2[i];
        return rtn;
    }
    public static char[] arrayAppend(char[] a, char c) {
        char[] rtn = new char[a.length + 1];
        for (int i = 0; i < a.length; i++) rtn[i] = a[i];
        rtn[a.length] = c;
        return rtn;
    }
    public static char[] arrayPrefix(char[] a, char c) {
        char[] rtn = new char[a.length + 1];
        rtn[0] = c;
        for (int i = 0; i < a.length; i++) rtn[i+1] = a[i];
        return rtn;
    }
    public static int getValue(char c) { return Character.getNumericValue(c) - 10; }
    public static char getLetter(int i) {
        if (i < 0) i += 26;
        return (char) (i + 65);
    }
}
