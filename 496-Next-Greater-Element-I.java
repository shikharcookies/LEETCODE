class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nums1Idx = new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            nums1Idx.put(nums1[i],i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);


        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums2.length;i++)
        {
        int curr = nums2[i];
        while(!stack.isEmpty() && curr > stack.peek())
        {
            int val = stack.pop();
            int idx = nums1Idx.get(val);
            res[idx]=curr;
        }
        if(nums1Idx.containsKey(curr))
        stack.push(curr);
    }
    return res;
    }
}