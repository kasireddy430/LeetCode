class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);   // event before
        Integer next = calendar.ceilingKey(start); // event after

        // Check overlap with previous
        if (prev != null && calendar.get(prev) > start) return false;

        // Check overlap with next
        if (next != null && next < end) return false;

        calendar.put(start, end); // Safe to add
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */