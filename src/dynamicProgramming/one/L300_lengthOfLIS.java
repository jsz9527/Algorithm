package dynamicProgramming.one;

import java.util.ArrayList;

//dp[i] 表示 以数组中下标为i的元素结尾的 最长递增子序列长度
//dp[i] = max(dp[j]) + 1，其中 0<= j < i 且 nums[j] < nums[i]
public class L300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for(int i=1; i<nums.length; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }


    public int lengthOfLIS_greed(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int[] d = new int[nums.length+1];
        int len = 1;
        d[len] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] > d[len]){
                d[++len] = nums[i];
            }else if(nums[i] < d[1] ){
                d[1] = nums[i];
            }else {
                int l=1, r=len, pos=0;
                while (l<=r){
                    int mid = (l+r)/2;
                    if( d[mid] < nums[i]){
                        pos = mid;
                        l = pos+1;
                    }else {
                        r = mid - 1;
                    }
                }
                d[pos+1]=nums[i];
            }
        }
        return len;
    }


    public int lengthOfLIS_greed1(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int[] d = new int[nums.length+1];
        int len = 1;
        d[len] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] > d[len]){
                d[++len] = nums[i];
            }else if(nums[i] < d[1] ){
                d[1] = nums[i];
            }else {
                int l=1, r=len, pos=0;
                while (l<r){
                    int mid = (l+r)/2;
                    if( d[mid] < nums[i]){
                        pos = mid;
                        l = pos+1;
                    }else {
                        r = mid;
                    }
                }
                d[pos+1]=nums[i];
            }
        }
        return len;
    }


}
