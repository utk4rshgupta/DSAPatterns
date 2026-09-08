class MyCalendarTwo {
    TreeMap<Integer, Integer> line;

    public MyCalendarTwo() {
        line = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        line.put(startTime, line.getOrDefault(startTime, 0) + 1);
        line.put(endTime, line.getOrDefault(endTime, 0) - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : line.entrySet()) {
            count += entry.getValue();
            if (count > 2) {
                line.put(startTime, line.getOrDefault(startTime, 0) - 1);
                if (line.get(startTime) == 0) {
                    line.remove(startTime);
                }
                line.put(endTime, line.getOrDefault(endTime, 0) + 1);
                if (line.get(endTime) == 0) {
                    line.remove(endTime);
                }
                return false;
            }

        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */