package other;

import java.util.HashMap;

public class L1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int y = target - nums[i];
            if(hashMap.containsKey(y)){
                return new int[]{i, hashMap.get(y)};
            }else {
                if(!hashMap.containsKey(nums[i])){
                    hashMap.put(nums[i], i);
                }
            }
        }

        return new int[]{0, 0};
    }
}
