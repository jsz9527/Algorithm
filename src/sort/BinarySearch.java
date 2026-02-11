package sort;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        if( target < nums[l] || nums[r] < target){
            return -1;
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }

        return -1;
    }


    public static int binarySearch1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        if( target < nums[l] || nums[r] < target){
            return -1;
        }

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                l = mid + 1;
            } else{
                r = mid;
            }
        }

        return -1;
    }


    public static int binarySearch_largeScale(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        if( target < nums[l] || nums[r] < target){
            return -1;
        }

        while (l < r) {                     // 注意这里是 l < r
            int mid = (l + r) / 2;

            if (nums[mid] < target) {
                l = mid + 1;
            } else{
                r = mid;                    // 直接压缩到左侧
            }
        }

        return nums[l] == target ? l : -1; // 最后再比较一次
    }


}