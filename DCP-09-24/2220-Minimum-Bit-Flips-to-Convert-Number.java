class Solution {
    public int minBitFlips(int start, int goal) {
        int n=start^goal,c=0;
        while(n>0)
        {
            n&=n-1;
            c+=1;
        }
        return c;
    }
}