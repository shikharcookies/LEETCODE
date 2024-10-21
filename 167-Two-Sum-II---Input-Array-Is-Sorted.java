class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int a_ptr = 0;
        int b_ptr = numbers.length-1;

        while(a_ptr <= b_ptr)
        {
            int sum = numbers[a_ptr] + numbers[b_ptr];

            if(sum>target)
            {
                b_ptr-=1;
            }
            else if(sum<target)
            {
                a_ptr+=1;
            }
            else
            {
                return new int[]{a_ptr+1, b_ptr+1};
            }
        }
        return new int[]{a_ptr+1, b_ptr+1};
    }
}