
using System;
using System.Collections.Generic;

public class Solution
{
    private static readonly int NOT_FOUND = -1;

    public int MinMirrorPairDistance(int[] input)
    {
        int minMirrorPairDistance = int.MaxValue;
        Dictionary<int, int> reversedValueToLatestIndex = [];

        for (int i = 0; i < input.Length; ++i)
        {
            if (reversedValueToLatestIndex.ContainsKey(input[i]))
            {
                minMirrorPairDistance = Math.Min(minMirrorPairDistance, i - reversedValueToLatestIndex[input[i]]);
            }
            reversedValueToLatestIndex[ReverseValue(input[i])] = i;
        }
        return minMirrorPairDistance != int.MaxValue ? minMirrorPairDistance : NOT_FOUND;
    }

    private int ReverseValue(int value)
    {
        int reversedValue = 0;
        while (value > 0)
        {
            int digit = value % 10;
            reversedValue = reversedValue * 10 + digit;
            value /= 10;
        }
        return reversedValue;
    }
}
