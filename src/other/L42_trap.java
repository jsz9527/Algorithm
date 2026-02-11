package other;

//接雨水
//按列遍历
public class L42_trap {
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        while (left<right){
            if(height[left] < height[right]){
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft-height[left];
                left++;
            }else {
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight-height[right];
                right--;
            }
        }

        return result;

    }

    public int trap1(int[] height) {
        int result = 0;
        int left = 1;
        int right = height.length-2;
        int maxLeft = height[left-1];
        int maxRight = height[right+1];
        while (left<=right){
            if(height[left-1] < height[right+1]){
                maxLeft = Math.max(maxLeft, height[left-1]);
                if(maxLeft>height[left]){
                    result += maxLeft-height[left];
                }
                left++;
            }else {
                maxRight = Math.max(maxRight, height[right+1]);
                if(maxRight>height[right]){
                    result += maxRight-height[right];
                }
                right--;
            }
        }

        return result;

    }
}
