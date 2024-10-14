class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a,b)-> b-a);
        for(int n:nums)
        {
            max_heap.add(n);
        }
        long res=0;
        while(k>0)
        {
           int n = max_heap.poll();
           res+=n;
           k--;
           max_heap.add((int)Math.ceil(n/3.0));
        }
        return res;
    }
}