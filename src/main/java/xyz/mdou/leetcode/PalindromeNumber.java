package xyz.mdou.leetcode;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int mod = x % 10;
        int dividend = x / 10;
        int palindromeNum = mod;
        while (dividend > 0) {
            mod = dividend % 10;
            palindromeNum = palindromeNum * 10 + mod;
            dividend /= 10;
        }
        return palindromeNum == x;
    }
}