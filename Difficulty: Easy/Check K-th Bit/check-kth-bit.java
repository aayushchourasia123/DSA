class CheckBit {
    static boolean checkKthBit(int n, int k) {
        // code here
        //return (n & (1<<k))!=0; //using <<
        return ((n>>k) & 1)==1;   //using>>
    }
}