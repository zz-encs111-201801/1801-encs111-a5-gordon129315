package q01;


import java.util.HashMap;

public class Solution {

//    public int solve(int[] coins) {
//        return 0;
//    }

    public int solve(int[] coins) {
        HashMap<Integer, Integer> map = new HashMap<>();  //remember the repeat data
        return solveRecurse(coins, coins.length, map);
    }

    private int solveRecurse(int[] coins, int i, HashMap<Integer, Integer> map) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return coins[0];
        }

        if (map.containsKey(i)) {
            return map.get(i);
        }

        int v1 = coins[i - 1] + solveRecurse(coins, i - 2, map);
        int v2 = solveRecurse(coins, i - 1, map);

        int max = Math.max(v1, v2);
        map.put(i, max);

        return max;
    }

}
