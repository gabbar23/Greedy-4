
Time Complexity (TC): O(n)
Space Complexity (SC): O(1)
class Solution {
    // Helper function to check if we can make all elements in tops or bottoms equal to the target
    private int isValid(int[] tops, int[] bottoms, int target) {
        int topCount = 0;
        int bottomCount = 0;

        // Loop through tops and bottoms arrays
        for (int i = 0; i < tops.length; i++) {
            // If neither tops[i] nor bottoms[i] equals target, it's impossible
            if (tops[i] != target && bottoms[i] != target)
                return -1;
            
            // Count rotations needed for tops and bottoms
            if (tops[i] != target) topCount++;
            if (bottoms[i] != target) bottomCount++;
        }

        // Return the minimum rotations required to make all tops or bottoms the target
        return Math.min(topCount, bottomCount);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Check rotations needed to make either tops[0] or bottoms[0] the uniform value
        int rotationsForTops = isValid(tops, bottoms, tops[0]);
        int rotationsForBottoms = isValid(tops, bottoms, bottoms[0]);

        // Return the maximum value between the two checks (or -1 if both are invalid)
        return Math.max(rotationsForTops, rotationsForBottoms);
    }
}
