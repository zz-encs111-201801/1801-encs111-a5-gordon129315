package q03;


import java.util.HashMap;
import java.util.LinkedList;

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

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            if (prices[i][0] <= restOfLength) {
                list.add(prices[i][1] + maxValueRecurse(prices, restOfLength - prices[i][0], map));
            }
        }

        int maxPrice = maxValueInList(list);
        map.put(restOfLength, maxPrice);

        return maxPrice;
    }

    private int maxValueInList(LinkedList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int value : list) {
            max = Math.max(max, value);
        }
        return max;
    }

}
