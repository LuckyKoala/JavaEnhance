package tech.zuosi.javaenhance.offer_questions.base.duplication_in_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luckykoala on 19-2-23.
 */
public class TestMain {
    private static final Map<String, Solution> solutionMap;

    static {
        solutionMap = new HashMap<String, Solution>() {{
            put("WithReording", new WithReordering());
            put("WithBitSet", new WithBitSet());
            put("WithBinarySearching", new WithBinarySearching());
            put("WithSorting", new WithSorting());
        }};
    }

    private static void test(Solution solution) {
        int[][] cases = new int[][]{
                new int[]{2,3,1,0,2,5,3,4}, //偶数个 有重复
                new int[]{1,2,3,2,4}, //奇数个 有重复
                new int[]{3,1,2,0}, //偶数个 无重复
                new int[]{1,0,2}, //奇数个 无重复
                null //NULL 容错
        };
        for(int[] testcase : cases) {
            System.out.println("case: "+ Arrays.toString(testcase)
                    +" ,result: "+solution.duplicateNumberOf(testcase));
        }
    }

    public static void main(String[] args) {
        solutionMap.forEach((name, solution) -> {
            System.out.println(String.format("Testing Solution-[%s]", name));
            test(solution);
        });
    }
}
