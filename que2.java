Time Complexity (TC): O(n * log m)
Space Complexity (SC): O(m)
class Solution {
    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) > target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    public int shortestWay(String source, String target) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        // Populate the map with characters and their positions in the source
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        int count = 1;
        int sIndex = 0;
        int tIndex = 0;

        while (tIndex < target.length()) {
            char tChar = target.charAt(tIndex);

            // If the target character is not in the source, return -1
            if (!map.containsKey(tChar)) {
                return -1;
            }

            List<Integer> list = map.get(tChar);
            int k = binarySearch(list, sIndex);

            // If no valid index is found, we need a new subsequence
            if (k == -1) {
                count++;
                sIndex = list.get(0);
            } else {
                sIndex = list.get(k);
            }

            sIndex++;
            tIndex++;
        }

        return count;
    }
}
