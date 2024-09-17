class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        List<Integer> ap = new ArrayList<>();

        for(int num : arr)
        {
            ap.add(num);
        }
        Collections.sort(ap);
        for(int i=1;i<ap.size()-1;i++)
        {
            if(ap.get(i)-ap.get(i-1) != ap.get(i+1)-ap.get(i))
            {
                return false;
            }
        }
        return true;
    }
}