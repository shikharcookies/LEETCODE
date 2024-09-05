class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m= rolls.length;
        int tSum = mean *(m+n);
        int cSum = 0;


        for(int i=0;i<m;i++)
        {
            cSum+=rolls[i];
        }

        int missingSum = tSum - cSum;

        if(missingSum > 6*n || missingSum <n)
        {
            return new int[0];
        }
        int[]res = new int[n];
        int quot = missingSum/n;
        int rem = missingSum%n;

        for(int i=0;i<n;i++)
        {
            res[i]= quot;
            if(rem >0)
            {
                res[i]++;
                rem--;
            }
        }
        return res;
    }
}