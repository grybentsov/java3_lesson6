package test.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.geekbrains.java3_lesson6.Task_1;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class Test_1 {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,5,4,3,7,2}, new int[]{1,7}, "Case 1"},
                {new int[]{9,13,52,80,2,10}, new int[]{10,9}, "Case 2"},
                {new int[]{7,8,11}, new int[]{11, 7}, "Case 3"}
        });
    }

    private int[] originalArray;
    private int[] expectedArray;
    private String msg;

    public Test_1(int[] originalArray, int[] expectedArray, String msg) {
        this.originalArray = originalArray;
        this.expectedArray = expectedArray;
        this.msg = msg;
    }

    @Test
    public void arraysEquality() {
        assertArrayEquals("This array must be the same as expected array",
                expectedArray, Task_1.newlyBuiltArray(originalArray));
    }

    @Test(expected = RuntimeException.class)
    public void exceptionTest() {
        Task_1.newlyBuiltArray(new int[]{9,5,7});
    }
}
