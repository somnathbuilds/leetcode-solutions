class Solution {
    public int maximumSum(int[] arr) {
        int No_delete = arr[0];
        int One_delete = arr[0];
        int result = arr[0];

        for(int i = 1; i<arr.length; i++){
            int preNo_delete = No_delete;
            int preOne_delete = One_delete;

            No_delete = Math.max(arr[i], No_delete + arr[i]);         

            One_delete = Math.max(preOne_delete + arr[i], preNo_delete);

            result = Math.max(result, Math.max(No_delete, One_delete));
        }
        return result;
    }
}