package other;

import java.util.ArrayList;
import java.util.List;

//全排列
public class L46_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> el = new ArrayList<>();
        permute_recursion(nums, 0, result, el);
        return result;
    }

    public void permute_recursion(int[] nums, int index, List<List<Integer>> result, List<Integer> el) {
        if(index == nums.length){
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(el);
            result.add(tempList);
            return ;
        }

        for(int i=index; i<nums.length; i++){
            swap(nums, index, i);
            el.add(nums[index]);

            permute_recursion(nums, index+1, result, el);

            el.remove(el.size() -1 );
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
