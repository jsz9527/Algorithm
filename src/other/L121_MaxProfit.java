package other;

public class L121_MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int result = 0;
        for(int i : prices){
            if(i <= minPrice){
                minPrice = i;
            }
            if(result < (i-minPrice)){
                result = i-minPrice;
            }
        }
        return  result;
    }
}
