class Solution {
    public int maximumSum(int[] arr) {
        int No_delete = arr[0];
        int One_delete = Integer.MAX_VALUE;
        int result = arr[0];

        for(int i = 1; i<arr.length; i++){
            int preNo_delete = No_delete;
            int preOne_delete = One_delete;

            No_delete = Math.max(arr[i], No_delete + arr[i]);
            int opt;
            if(preOne_delete == Integer.MAX_VALUE){
                opt = arr[i];
            } else{
                opt = preOne_delete + arr[i];
            }
            One_delete = Math.max(opt, preNo_delete);
            result = Math.max(result, Math.max(No_delete, One_delete));
        }
        return result;
    }
}