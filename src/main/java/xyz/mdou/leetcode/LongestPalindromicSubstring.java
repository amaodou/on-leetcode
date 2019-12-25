package xyz.mdou.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("accdefcca"));
        System.out.println(solution.longestPalindrome("abck"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0, length = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = longestPalindromeLength(s, i, i);
            int length2 = longestPalindromeLength(s, i, i + 1);
            int tmpLength = Math.max(length1, length2);
            if (tmpLength > length) {
                length = tmpLength;
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int longestPalindromeLength(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
