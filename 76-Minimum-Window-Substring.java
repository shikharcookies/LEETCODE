class Solution {
    public String minWindow(String s, String t) {
        int startans=0,endans=0;
        int [] arr1 = new int [128];
        int [] arr2 = new int [128];
        int start=0,end=0,min=Integer.MAX_VALUE;
        Arrays.fill(arr1,0);
        Arrays.fill(arr2,0);

        for(char i:t.toCharArray()) arr2[i]++;

        for(int i=0;i<s.length();i++)
        {
            arr1[s.charAt(i)]++;
            while(end<=i && isvalid(arr1,arr2))
            {
                    if(min>i-end+1)
                    {
                        startans=i+1;
                        endans=end;
                        min=i-end+1;
                    }
                    arr1[s.charAt(end)]--; 
                    end++;
            }
            
        }
        return s.substring(endans,startans);
    }
    public boolean isvalid(int [] arr1 , int [] arr2)
    {
        for(int i='A';i<128;i++) if(arr1[i]<arr2[i]) return false;
        return true;
    }

}