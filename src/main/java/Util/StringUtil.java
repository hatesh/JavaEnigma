package Util;

public class StringUtil {
    public static String[] arrayPrefix(String[] a, String s) {
        String[] rtn = new String[a.length + 1];
        rtn[0] = s;
        for (int i = 0; i < a.length; i++) rtn[i+1] = a[i];
        return rtn;
    }
    public static String spaceSeperatedConcatenate(String[] a) {
        String rtn = "";
        for (String s : a) rtn += s + " ";
        return rtn.substring(0, rtn.length() - 1);
    }
}
