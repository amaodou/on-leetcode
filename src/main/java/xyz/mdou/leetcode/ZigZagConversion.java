package xyz.mdou.leetcode;

import org.junit.Assert;

public class ZigZagConversion {

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        Assert.assertEquals(zigZagConversion.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
    }

    public String convert(String s, int numRows) {
        if (numRows == 0) {
            return s;
        }
        int sLength = s.length();
        int zigZagLength = numRows * 2 - 2;
        int zigZagCount = sLength / zigZagLength + (sLength % zigZagLength == 0 ? 0 : 1);
        StringBuilder zigZagString = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < zigZagCount; j++) {
                if (i + j * zigZagLength >= sLength) {
                    continue;
                }
                zigZagString.append(s.charAt(i + j * zigZagLength));
                if (i == numRows - 1) {
                    continue;
                }
                if (zigZagLength - i < zigZagLength) {
                    if (j * zigZagLength + zigZagLength - i >= sLength) {
                        continue;
                    }
                    zigZagString.append(s.charAt(j * zigZagLength + zigZagLength - i));
                }
            }
        }
        return zigZagString.toString();
    }
}