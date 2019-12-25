# on-leetcode

记录leetcode解题思路

## [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)

### 题目概要

找出给出字符串中最长的回文字符串。

例如

```console
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

### 解题过程

* 思路1：回文字符串的特点是翻转后字符串值保持不变，那是不是可以将源字符串翻转，然后找出两个字符串中都包含的子字符串，再选出长度最长的子字符串呢?

    按照这个思路实现后发现有一种情况不能解决，比如源字符串`accdefcca`翻转后为`accfedcca`，按照上面的思路找到了错误结果`acc`，放弃。

* 思路2：以一个字符为中心向两侧比对，再以两个字符为中心向两侧比对（为中心的两个字符必须相同），找出左右两侧字符都相同的最大长度，然后再根据中心字符的位置，即可知道回文字符串的开始和结束位置，最终实现：[LongestPalindromicSubstring](./src/main/java/com/study/leetcode/LongestPalindromicSubstring.java)


## [ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion)

### 题目概要

给出字符串输出转换成指定行数的锯齿形线条后的字符串。

例1

```console
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Explanation: 

P   A   H   N
A P L S I I G
Y   I   R
```

例2

```console
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
```

### 解题过程

* 思路：根据锯齿形线条的行数可以求出单个锯齿包含的字符个数（即`numRows + numRows - 2`），根据源字符串长度和单个锯齿长度可以求出锯齿组数，通过for循环输出每行的字符，第一行输出各组锯齿的第一个字符，第二行输出各组锯齿的第二个和最后一个字符，以此类推，第n行输出每组锯齿的第n个和第`(numRows + numRows - 2) - n`个字符。最终实现[ZigZagConversion](./src/main/java/com/study/leetcode/ZigZagConversion.java)