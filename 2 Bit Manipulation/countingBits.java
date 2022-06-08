class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            int val = i;
            int cnt = 0;
            while(val > 0){
                cnt++;
                val = val & (val - 1);
            }
            
            res[i] = cnt;
        }
        
        return res;
    }
}

// TC: O(nlogn)
// SC: O(n)

// class Solution {
//     public int[] countBits(int n) {
//         int[] res = new int[n + 1];
//         res[0] = 0;
        
//         for(int i = 1; i <= n; i++){
//             res[i] = res[i / 2] + i % 2;
//         }
        
//         return res;
//     }
// }

// TC: O(n)
// SC: O(n)