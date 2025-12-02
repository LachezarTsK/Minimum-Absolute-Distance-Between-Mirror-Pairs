
function minMirrorPairDistance(input: number[]): number {
    const NOT_FOUND = -1;
    let minMirrorPairDistance = Number.MAX_SAFE_INTEGER;
    const reversedValueToLatestIndex = new Map<number, number>();

    for (let i = 0; i < input.length; ++i) {
        if (reversedValueToLatestIndex.has(input[i])) {
            minMirrorPairDistance = Math.min(minMirrorPairDistance, i - reversedValueToLatestIndex.get(input[i]));
        }
        reversedValueToLatestIndex.set(reverseValue(input[i]), i);
    }
    return minMirrorPairDistance !== Number.MAX_SAFE_INTEGER ? minMirrorPairDistance : NOT_FOUND;
};

function reverseValue(value: number): number {
    let reversedValue = 0;
    while (value > 0) {
        const digit = value % 10;
        reversedValue = reversedValue * 10 + digit;
        value = Math.floor(value / 10);
    }
    return reversedValue;
}
