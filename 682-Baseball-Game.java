class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> bg = new Stack<>();
        int sum=0;

        for(String op:operations)
        {
            if(op.equals(\C\))
            {
                bg.pop();
            }
            else if(op.equals(\D\))
            {
                int val= bg.peek();
                bg.push(2*val);
            }
            else if(op.equals(\+\))
            {
                int s1= bg.pop();
                int s2= bg.pop();

                bg.push(s2);
                bg.push(s1);

                bg.push(s1+s2);
            }
            else
            {
                bg.push(Integer.parseInt(op));
            }

        }
        while(!bg.isEmpty())
        {
            sum+=bg.pop();
        }
        return sum;
    }
}