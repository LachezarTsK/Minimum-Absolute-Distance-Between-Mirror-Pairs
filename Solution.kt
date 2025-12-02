
import kotlin.math.min

class Solution {

    private companion object {
        const val NOT_FOUND = -1
    }

    fun minMirrorPairDistance(input: IntArray): Int {
        var minMirrorPairDistance = Int.MAX_VALUE
        val reversedValueToLatestIndex = mutableMapOf<Int, Int>()

        for (i in input.indices) {
            if (reversedValueToLatestIndex.containsKey(input[i])) {
                minMirrorPairDistance = min(minMirrorPairDistance, i - reversedValueToLatestIndex[input[i]]!!)
            }
            reversedValueToLatestIndex[reverseValue(input[i])] = i
        }
        return if (minMirrorPairDistance != Int.MAX_VALUE) minMirrorPairDistance else NOT_FOUND
    }

    private fun reverseValue(value: Int): Int {
        var value = value
        var reversedValue = 0
        while (value > 0) {
            val digit = value % 10
            reversedValue = reversedValue * 10 + digit
            value /= 10
        }
        return reversedValue
    }
}
