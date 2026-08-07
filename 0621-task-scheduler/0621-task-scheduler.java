class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Step 1: Frequency Count
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : map.values()) {
            maxHeap.offer(freq);
        }

        // Step 3: Queue
        // int[]{remainingFrequency, readyTime}
        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {

            // Ek CPU interval
            time++;

            // Agar koi task available hai
            if (!maxHeap.isEmpty()) {

                int freq = maxHeap.poll();

                freq--;

                // Agar task abhi bhi bacha hai
                if (freq > 0) {
                    q.offer(new int[]{freq, time + n});
                }
            }

            // Agar queue ka task ready ho gaya
            if (!q.isEmpty() && q.peek()[1] == time) {

                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}