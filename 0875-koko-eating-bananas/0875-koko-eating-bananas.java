class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = findMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEat(piles, h, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Find maximum pile
    public int findMax(int[] piles) {
        int max = piles[0];

        for (int bananas : piles) {
            if (bananas > max) {
                max = bananas;
            }
        }

        return max;
    }

    // Check if Koko can finish within h hours
    public boolean canEat(int[] piles, int h, int speed) {

        long hours = 0; // Use long to avoid overflow

        for (int bananas : piles) {
            hours += (bananas + (long) speed - 1) / speed;
        }

        return hours <= h;
    }
}