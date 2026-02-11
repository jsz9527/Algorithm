package sort;

public class L912_SearchOrderedAyyRotatedToTheLeft {

    public static int searchOrderedAyyRotatedToTheLeft_notRepeat(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        int mid = 0;

        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (nums[mid] == target) return mid;

            if (nums[l] <= nums[mid]) { //左边有序
                if(nums[l] <= target && target <= nums[mid] ){
                    r = mid -1;
                }else {
                    l = mid + 1;
                }
            } else { //右边有序
                if(nums[mid] <= target && target <= nums[r] ){
                    l = mid + 1;
                }else {
                    r = mid -1;
                }
            }


        }

        return -1;
    }


    public static int searchOrderedAyyRotatedToTheLeft_maybeRepeat(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;

            if (nums[l] == nums[mid] && nums[mid] == nums[r]) { // 无法判断哪边有序，直接缩小边界
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {// 左边有序
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {// 右边有序
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
