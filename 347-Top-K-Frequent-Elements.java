class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
        {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>()
        {
            public int compare(int[]i1,int[]i2)
            {
                return Integer.compare(i1[1], i2[1]);
            }
        });
        for(int i : map.keySet())
        {
            int[] arr={i,map.get(i)};
            if(pq.size()<k)
            {
                pq.add(arr);
            }
            else if(map.get(i)>pq.peek()[1])
            {
                pq.remove();
                pq.add(arr);
            }
        }
        int ans[] = new int[k];
        int i=0;
        while(!pq.isEmpty())
        {
            ans[i++]=pq.remove()[0];
        }
        return ans;
    }
}