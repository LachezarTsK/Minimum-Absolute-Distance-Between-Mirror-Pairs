
package main
import "math"

const NOT_FOUND = -1

func minMirrorPairDistance(input []int) int {
    minMirrorPairDistance := math.MaxInt
    reversedValueToLatestIndex := map[int]int{}

    for i := range input {
        if _, has := reversedValueToLatestIndex[input[i]]; has {
            minMirrorPairDistance = min(minMirrorPairDistance, i - reversedValueToLatestIndex[input[i]])
        }
        reversedValueToLatestIndex[reverseValue(input[i])] = i
    }

    if minMirrorPairDistance != math.MaxInt {
        return minMirrorPairDistance
    }
    return NOT_FOUND
}

func reverseValue(value int) int {
    reversedValue := 0
    for value > 0 {
        digit := value % 10
        reversedValue = reversedValue * 10 + digit
        value /= 10
    }
    return reversedValue
}
