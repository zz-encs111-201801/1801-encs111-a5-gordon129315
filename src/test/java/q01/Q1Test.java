package q01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Coin-row Problem Test")
public class Q1Test {

    private Solution slt = new Solution();;

    @Test
    public void testBasic() {
        int arr1[] = {2};
        assertEquals(2, slt.solve(arr1));

        int arr2[] = {2, 2};
        assertEquals(2, slt.solve(arr2));

        int arr3[] = {2, 2, 2};
        assertEquals(4, slt.solve(arr3));

        int arr4[] = {2, 2, 2, 2};
        assertEquals(4, slt.solve(arr4));
    }

    @Test
    public void test() {
        int arr1[] = {20, 10, 20, 50, 20, 10, 20};
        assertEquals(90, slt.solve(arr1));
        int arr2[] = {20, 10, 190, 200, 201, 10, 20};
        assertEquals(431, slt.solve(arr2));
    }

}
