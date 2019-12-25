package xyz.mdou.leetcode;

public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("42"));
        System.out.println(stringToInteger.myAtoi("-41930000000000000000 with words"));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        char[] cs = str.toCharArray();
        for (char c : cs) {
            if ((c == '+' || c == '-') && stringBuilder.length() == 0) {
                stringBuilder.append(c);
            } else if (c >= '0' && c <= '9') {
                stringBuilder.append(c);
            } else {
                break;
            }
        }
        String atoiString = stringBuilder.toString();
        if (atoiString.isEmpty() || atoiString.equals("-") || atoiString.equals("+")) {
            return 0;
        }
        try {
            return Integer.valueOf(atoiString);
        } catch (NumberFormatException e) {
            return atoiString.startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}