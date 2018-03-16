package q02;


import java.util.HashMap;

public class Solution {

    public int solve(int[][] items, int bagCapacity) {
        HashMap<Combination, Integer> map = new HashMap<>();
        return maxValueRecurse(bagCapacity, items, items.length, map);
    }

    private int maxValueRecurse(int restOfWeight, int[][] items, int i, HashMap<Combination, Integer> map) {
        if (restOfWeight <= 0) {
            return 0;
        }
        if (i == 0) {
            return 0;
        }

        Combination key = new Combination(restOfWeight, i);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int v1 = restOfWeight - items[i - 1][0] >= 0 ? items[i - 1][1] + maxValueRecurse(restOfWeight - items[i - 1][0], items, i - 1, map) : 0;
        int v2 = maxValueRecurse(restOfWeight, items, i - 1, map);

        int max = Math.max(v1, v2);
        map.put(key, max);

        return max;
    }

}
