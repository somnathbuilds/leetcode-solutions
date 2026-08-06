class Solution {
    public String reorganizeString(String s) {

        // Step 1: Count frequency
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap (frequency ke basis par)
        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // Step 3: Heap me sab entries daalo
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        StringBuilder ans = new StringBuilder();

        // Step 4: Har baar 2 characters nikalo
        while (pq.size() > 1) {

            Map.Entry<Character, Integer> first = pq.poll();
            Map.Entry<Character, Integer> second = pq.poll();

            // Answer me add karo
            ans.append(first.getKey());
            ans.append(second.getKey());

            // Frequency kam karo
            first.setValue(first.getValue() - 1);
            second.setValue(second.getValue() - 1);

            // Agar frequency bachi hai to wapas heap me daalo
            if (first.getValue() > 0) {
                pq.offer(first);
            }

            if (second.getValue() > 0) {
                pq.offer(second);
            }
        }

        // Step 5: Agar ek character bach gaya
        if (!pq.isEmpty()) {

            Map.Entry<Character, Integer> last = pq.poll();

            // Agar frequency 1 se zyada hai to impossible
            if (last.getValue() > 1) {
                return "";
            }

            ans.append(last.getKey());
        }

        return ans.toString();
    }
}