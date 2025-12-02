
#include <vector>
#include <limits>
#include <algorithm>
#include <unordered_map>
using namespace std;

class Solution {

    static const int NOT_FOUND = -1;

public:
    int minMirrorPairDistance(const vector<int>& input) const {
        int minMirrorPairDistance = numeric_limits<int>::max();
        unordered_map<int, int> reversedValueToLatestIndex;

        for (int i = 0; i < input.size(); ++i) {
            if (reversedValueToLatestIndex.contains(input[i])) {
                minMirrorPairDistance = min(minMirrorPairDistance, i - reversedValueToLatestIndex[input[i]]);
            }
            reversedValueToLatestIndex[reverseValue(input[i])] = i;
        }
        return minMirrorPairDistance != numeric_limits<int>::max() ? minMirrorPairDistance : NOT_FOUND;
    }

private:
    int reverseValue(int value) const {
        int reversedValue = 0;
        while (value > 0) {
            int digit = value % 10;
            reversedValue = reversedValue * 10 + digit;
            value /= 10;
        }
        return reversedValue;
    }
};
