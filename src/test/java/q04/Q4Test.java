package q04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Exchange coins Problem Test")
public class Q4Test {

    private Solution slt = new Solution();


    @Test
    public void test0() {
        int coins[] = {1};
        assertEquals(1, slt.solve(coins, 5));
    }

    @Test
    public void test1() {
        int coins[] = {1, 2, 5};
        assertEquals(4, slt.solve(coins, 5));
    }

    @Test
    public void test2() {
        int coins[] = {1, 2, 4};
        assertEquals(4, slt.solve(coins, 4));
    }

    @Test
    public void test3() {
        int coins[] = {2, 5, 3, 6};
        assertEquals(5, slt.solve(coins, 10));
    }
}
