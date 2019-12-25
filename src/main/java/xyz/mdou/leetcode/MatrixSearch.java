package xyz.mdou.leetcode;

public class MatrixSearch {

    public boolean search(int[][] m, int target) {
        int i = 0;
        int j = m[0].length - 1;
        while (i < m.length && j > 0) {
            int num = m[i][j];
            if (num < target) {
                i += 1;
            } else if (num > target) {
                j -= 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = { 
            { 1, 4, 7, 11, 15 }, 
            { 2, 5, 8, 12, 19 }, 
            { 3, 6, 9, 16, 22 }, 
            { 10, 13, 14, 17, 24 },
            { 18, 21, 23, 26, 30 } 
        };
        MatrixSearch mSearch = new MatrixSearch();
        
        System.out.println(mSearch.search(array, 5));
    }

}