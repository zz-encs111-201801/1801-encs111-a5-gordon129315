package q03;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Rod-cutting Problem Test")
public class Q3Test {

    private Solution slt = new Solution();

    @Test
    public void test0() {
        int arr1[][] = {{1, 1}};
        assertEquals(1, slt.solve(arr1, 1));

        int arr2[][] = {{1, 2}, {2, 3}, {3, 7}, {4, 8}, {5, 10}};
        assertEquals(0, slt.solve(arr2, 0));
    }

    @Test
    public void test1() {
        int arr1[][] = {{1, 1}, {2, 5}, {3, 8}, {4, 9}, {5, 10}, {6, 17}, {7, 17}, {8, 20}};
        assertEquals(22, slt.solve(arr1, 8));

        int arr2[][] = {{1, 2}, {2, 3}, {3, 7}, {4, 8}, {5, 10}};
        assertEquals(11, slt.solve(arr2, 5));

        int arr3[][] = {{1, 2}, {2, 7}, {3, 8}, {4, 25}, {5, 17}, {6, 28}, {7, 30}};
        assertEquals(34, slt.solve(arr3, 7));
    }
}
