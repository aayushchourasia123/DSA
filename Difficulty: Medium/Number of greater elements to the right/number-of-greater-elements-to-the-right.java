
class Solution {
    public static int[] count_NGE(int arr[], int indices[]) {
        // code here
        //tc=O(n*queries)
        int[] res = new int[indices.length];

        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            int count = 0;

            for (int j = idx + 1; j < arr.length; j++) {
                if (arr[j] >arr[idx]) {
                    count++;
                }
            }

            res[i] = count;
        }

        return res;
        
    }
}
