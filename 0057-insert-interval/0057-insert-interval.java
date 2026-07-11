class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int newstart = newInterval[0];
        int newend = newInterval[1];
        boolean inserted = false;

        for(int i = 0; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!inserted && newstart < start){
                list.add(new int[]{newstart, newend});
                inserted = true;
            }
            list.add(new int[]{start, end});
        }
        if(!inserted){
            list.add(new int[]{newstart, newend});
        }
        Collections.sort(list, (a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int start1 = list.get(0)[0];
        int end1 = list.get(0)[1];

        for(int i = 1; i<list.size(); i++){
            int start2 = list.get(i)[0];
            int end2 = list.get(i)[1];

            if(end1 >= start2){
                end1 = Math.max(end1, end2);
                continue;
            } else{
                ans.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }
        ans.add(new int[]{start1, end1});
        return ans.toArray(new int[ans.size()][]);
    }
}