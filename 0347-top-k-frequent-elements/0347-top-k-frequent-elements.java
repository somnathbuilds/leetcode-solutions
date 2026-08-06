class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //Step:1 Fill the pair of a[0]= element, a[1]=frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        //Step:2 make min heap according to a[1]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] -b[1]);

        //Step:3 Traverse the HashMap
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //Step:4 Head me pair add krna
            pq.offer(new int[]{entry.getKey(),entry.getValue()});

            if(pq.size() > k){
                pq.poll();
            }
        }
        //Step:5 ans stor kro a[0]= element
        int[] ans = new int[k];

        for(int i = k-1; i >= 0; i--){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}