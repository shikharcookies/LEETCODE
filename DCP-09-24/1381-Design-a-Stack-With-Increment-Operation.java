class CustomStack {
    int capacity;
    Stack<Integer> stack;
    int[] values;

    public CustomStack(int maxSize) {
        stack = new Stack<>();
        capacity= maxSize;
        values=new int[capacity];
    }

    public void push(int x) {
        if (stack.size() < capacity) stack.push(x);
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        int top = stack.pop();
        top+= values[stack.size()];
        if(stack.size()>0) values[stack.size()-1] += values[stack.size()];
        values[stack.size()]=0;
        return top;
    }

    public void increment(int k, int val) {
        int temp = Math.min(k-1, stack.size()-1);
        if(temp >=0)
        {
            values[temp] +=val;
        }
    }
}