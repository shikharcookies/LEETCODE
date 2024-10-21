class Solution {
    public int maxArea(int[] height) {
        int maxHeight = 0;
        int a_ptr = 0;
        int b_ptr  = height.length - 1;
        while(a_ptr < b_ptr)
        {
            if(height[a_ptr]<height[b_ptr])
            {
                maxHeight = Math.max(maxHeight, height[a_ptr]* (b_ptr - a_ptr));
                a_ptr +=1;
            }
            else
            {
               maxHeight = Math.max(maxHeight, height[b_ptr]* (b_ptr - a_ptr));
               b_ptr -=1;
            }
        }
        return maxHeight;
    }
}