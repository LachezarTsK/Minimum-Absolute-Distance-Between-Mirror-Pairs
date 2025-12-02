
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final int NOT_FOUND = -1;

    public int minMirrorPairDistance(int[] input) {
        int minMirrorPairDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> reversedValueToLatestIndex = new HashMap<>();

        for (int i = 0; i < input.length; ++i) {
            if (reversedValueToLatestIndex.containsKey(input[i])) {
                minMirrorPairDistance = Math.min(minMirrorPairDistance, i - reversedValueToLatestIndex.get(input[i]));
            }
            reversedValueToLatestIndex.put(reverseValue(input[i]), i);
        }
        return minMirrorPairDistance != Integer.MAX_VALUE ? minMirrorPairDistance : NOT_FOUND;
    }

    private int reverseValue(int value) {
        int reversedValue = 0;
        while (value > 0) {
            int digit = value % 10;
            reversedValue = reversedValue * 10 + digit;
            value /= 10;
        }
        return reversedValue;
    }
}
