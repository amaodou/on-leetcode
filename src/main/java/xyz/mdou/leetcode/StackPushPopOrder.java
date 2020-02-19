package xyz.mdou.leetcode;

import java.util.Stack;

public class StackPushPopOrder {

    private static boolean isPopOrder(int[] push, int[] pop) {
        if (push != null && pop != null) {
            int iPush = 0;
            int iPop = 0;
            Stack<Integer> stack = new Stack<>();
            while (iPush < push.length) {
                stack.push(push[iPush]);
                iPush++;
                if (pop[iPop] == stack.peek()) {
                    stack.pop();
                    iPop++;
                }
            }
            while (!stack.isEmpty() && iPop < pop.length) {
                if (stack.peek() == pop[iPop]) {
                    stack.pop();
                    iPop++;
                } else {
                    break;
                }
            }
            if (stack.isEmpty() && iPop == pop.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // push = 12345
        // pop = 45321
        System.out.println(isPopOrder(new int[]{1}, new int[]{4}));
        System.out.println(isPopOrder(new int[]{1}, new int[]{1}));
        System.out.println(isPopOrder(new int[]{1,2,3}, new int[]{1,2,3}));
        System.out.println(isPopOrder(new int[]{1,2,3}, new int[]{3,1,2}));
        System.out.println(isPopOrder(null, null));
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
