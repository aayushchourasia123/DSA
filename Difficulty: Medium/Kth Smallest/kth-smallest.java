// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        
        //tc=O(n + k log n)
//         PriorityQueue<Integer> mh=new PriorityQueue<>();
        
//         for(int no :arr){
//             mh.add(no);
//         }
//         for(int i=0;i<k-1;i++){
//             mh.poll();
//         }
//         return mh.peek();
//     }
// }

//tc=O(n logk)
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll(); // remove largest
            }
        }
        return pq.peek(); // root is kth smallest
    }
}


