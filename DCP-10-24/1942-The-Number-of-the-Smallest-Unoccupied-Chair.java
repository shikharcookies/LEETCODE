class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        // store the arrival time of the target friend
        // so that we can atleast sort the times based
        // on the arrival time so as to allot a seat
        int targetStart = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        int n = times.length;

        // create a heap for the available seats
        // so that we can allot each seat as per
        // the arrival time of a friend
        PriorityQueue<Integer> availableSeat = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableSeat.offer(i);
        }

        // create a heap to store the leavingTime of the 
        // friend with their alloted seat in ascending 
        // order of their leavingtime.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            // check if the smallest seat is available
            // for that friend and then free up all the 
            // seats of the friends who have left by adding
            // the seats back to the 'availableSeat' heap.
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0]) {
                availableSeat.offer(pq.poll()[1]);
            }

            // check if the current friend is the target friend
            // by checking their arrival time since arrival
            // time is distinct
            if (times[i][0] == targetStart) {
                break;
            }

            // otherwise, just add the leavingTime
            // with their alloted seat
            pq.offer(new int[]{times[i][1], availableSeat.poll()});
        }
        // return the smallest seat available for the
        // target friend
        return availableSeat.peek();
    }
}