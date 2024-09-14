class Solution {
    public int longestSubarray(int[] nums) {

        int maxvalue=0;
        for(int num:nums){
            if(num>maxvalue){
                maxvalue=num;
            }
        }

        int maxlength=0;
        int currentlength=0;
        for(int num:nums){
            if(num==maxvalue){
                currentlength++;
                if(currentlength>maxlength){
                    maxlength=currentlength;
                }
            }
            else{
                currentlength=0;
            }
        }
            return maxlength;
    }
}