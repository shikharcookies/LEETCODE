class MyCalendarTwo {
      // List to store single bookings
    List<int[]> track;
    
    // List to store double bookings
    List<int[]> doubleBook;
    public MyCalendarTwo() {
        track = new ArrayList<>();
        doubleBook = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check if the new booking overlaps with any double-booked intervals
        for (int[] event : doubleBook) {
            if (Math.max(start, event[0]) < Math.min(end, event[1])) {
                return false;  // Triple booking would happen, reject the booking
            }
        }

        // Check for overlaps with single bookings and store double bookings
        for (int[] event : track) {
            if (Math.max(start, event[0]) < Math.min(end, event[1])) {
                // Store the overlapping part as a new double booking
                doubleBook.add(new int[]{Math.max(start, event[0]), Math.min(end, event[1])});
            }
        }

        // Add the new booking to single bookings
        track.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */