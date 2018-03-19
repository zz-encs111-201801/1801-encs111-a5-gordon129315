package q04;


import java.util.Arrays;

public class Solution {

    public int solve(int[] coins, int value) {
        Arrays.sort(coins);
        return recursion(coins, coins.length - 1, value);
    }

    private int recursion(int[] coins, int i, int restValue) {
        if (restValue == 0) {
            return 1;
        }

        if (restValue < 0 || i < 0) {
            return 0;
        }

        //选了 + 没选，从下一个开始选
        return recursion(coins, i, restValue - coins[i]) + recursion(coins, i - 1, restValue);

    }

}
