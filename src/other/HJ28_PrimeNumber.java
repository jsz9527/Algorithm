package other;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

//匈牙利算法
//素数伴侣
public class HJ28_PrimeNumber {
    static int max=0;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            //输入正偶数
            int n=sc.nextInt();
            //用于记录输入的n个整数
            int[] arr=new int[n];
            //用于存储所有的奇数
            ArrayList<Integer> odds=new ArrayList<>();
            //用于存储所有的偶数
            ArrayList<Integer> evens=new ArrayList<>();
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                //将奇数添加到odds
                if(arr[i]%2==1){
                    odds.add(arr[i]);
                }
                //将偶数添加到evens
                if(arr[i]%2==0){
                    evens.add(arr[i]);
                }
            }
            //值为对应的偶数的伴侣
            int[] matcheven=new int[evens.size()];
			//记录伴侣的对数
			int count=0;
			for(int j=0;j<odds.size();j++){
				//值表示对应的偶数是否查找过
				//每次循环，都是新的数组v
				boolean[] v=new boolean[evens.size()];
				//如果匹配上，则计数加1
                if( find( odds.get(j) , matcheven , evens , v )){
                    count++;
                }
            }
            System.out.println(count);
        }   
    }
    
    //判断奇数x能否找到伴侣
    private static boolean find(int x, int[] matcheven, ArrayList<Integer> evens, boolean[] v){
        for(int i=0 ; i<evens.size() ; i++){
            //该位置偶数没被访问过，并且能与x组成素数伴侣
            if( v[i]==false  &&  isPrime(x+evens.get(i)) ){
                v[i]=true;
                //（如果i位置偶数还没有伴侣）或者（如果i位置偶数已经有伴侣，并且这个伴侣（另一个奇数y）能重新找到新伴侣）
				//逻辑或：第一个条件为true，第二个条件不会执行
				//数组v的入参是奇数x的数组v，为了减小时间复杂度
				int y = matcheven[i] ;
				if( y == 0 || find( y , matcheven , evens , v ) ){
					// 则 i位置偶数与奇数x组成伴侣
					matcheven[i]=x;
                    return true;
                }
            }
        }
        return false;
    }

    //判断x是否是素数
    private static boolean isPrime(int x){
        if(x==1) return false;
        //如果能被2到根号x整除，则一定不是素数
        for(int i=2;i<=(int)Math.sqrt(x);i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }

}
