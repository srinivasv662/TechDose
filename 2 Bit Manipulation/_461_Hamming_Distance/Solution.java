package _461_Hamming_Distance;

class Solution {
    public int hammingDistance(int x, int y) {
        
        int cnt = 0;
        while(x != 0 || y != 0){
            if((x % 2 != 0 && y % 2 == 0) || (x % 2 == 0 && y % 2 != 0)){
                cnt++;
            }
            x >>= 1;
            y >>= 1;
        }
        
        return cnt;
        
    }
}
