package q03;


import java.util.HashMap;

public class Solution {

    public int solve(int[][] prices, int length) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return maxValueRecurse(prices, length, map);
    }

    private int maxValueRecurse(int[][] prices, int restOfLength, HashMap<Integer, Integer> map) {
        if (restOfLength <= 0) {
            return 0;
        }

        if (map.containsKey(restOfLength)) {
            return map.get(restOfLength);
        }

        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i][0] <= restOfLength) {
                maxPrice = Math.max(maxPrice, prices[i][1] + maxValueRecurse(prices, restOfLength - prices[i][0], map));
            }
        }

        map.put(restOfLength, maxPrice);

        return maxPrice;
    }

}
