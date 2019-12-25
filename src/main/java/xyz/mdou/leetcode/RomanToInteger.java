package xyz.mdou.leetcode;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("IV"));
    }

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int result = 0;
        int preVal = 0;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            int currentVal = 0;
            switch(c) {
                case 'I':
                    currentVal = 1;
                    break;
                case 'V':
                    currentVal = 5;
                    break;
                case 'X':
                    currentVal = 10;
                    break;
                case 'L':
                    currentVal = 50;
                    break;
                case 'C':
                    currentVal = 100;
                    break;
                case 'D':
                    currentVal = 500;
                    break;
                case 'M':
                    currentVal = 1000;
                    break;
            }
            if (preVal != 0 && preVal < currentVal) {
                result += (currentVal - preVal - preVal);
            } else {
                result += currentVal;
            }
            preVal = currentVal;
        }
        return result;
    }
}
