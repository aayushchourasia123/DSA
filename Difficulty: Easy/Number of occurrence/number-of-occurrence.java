class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int first = findBound(arr, target, true);
        int last = findBound(arr, target, false);
        
        if(first==-1) return 0;
        return last-first+1;
    }
     private int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0, high = nums.length - 1;
        int bound = -1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    high = mid - 1;  // Search left to find first occurrence
                } else {
                    low = mid + 1;   // Search right to find last occurrence
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return bound;
     }
}
