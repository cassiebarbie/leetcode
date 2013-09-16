import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class ThreeSum {
	/*
	 *  O(n^3). Came up with myself.
	 */
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> num_pos = new ArrayList<Integer>();
		ArrayList<Integer> num_neg = new ArrayList<Integer>();
		for(int i = 0; i < num.length; i++)	{
			if(num[i] < 0){
				num_neg.add(num[i]);
			}
			else num_pos.add(num[i]);
		}
		
		for(int j = 0; j < num_neg.size() - 1; j++)	{	
			for(int k = j+1; k < num_neg.size(); k++)	{
				int twoSum = num_neg.get(j) + num_neg.get(k);
				for(int i = 0; i < num_pos.size(); i++){
					ArrayList<Integer> zero_sum  = new ArrayList<Integer>();
					if(twoSum + num_pos.get(i) == 0){
						if(num_neg.get(j) > num_neg.get(k))	{
							zero_sum.add(num_neg.get(k));
							zero_sum.add(num_neg.get(j));
						} else {
							zero_sum.add(num_neg.get(j));
							zero_sum.add(num_neg.get(k));
						}
						zero_sum.add(num_pos.get(i));
					}
					if(zero_sum.size() != 0 && !result.contains(zero_sum))	result.add(zero_sum);
				}	
			}
		}
		
		for(int j = 0; j < num_pos.size() - 1; j++)	{	
			for(int k = j+1; k < num_pos.size(); k++)	{
				int twoSum = num_pos.get(j) + num_pos.get(k);
				for(int i = 0; i < num_neg.size(); i++){
					ArrayList<Integer> zero_sum  = new ArrayList<Integer>();
					if(twoSum + num_neg.get(i) == 0){
						zero_sum.add(num_neg.get(i));
						if(num_pos.get(j) > num_pos.get(k))	{
							zero_sum.add(num_pos.get(k));
							zero_sum.add(num_pos.get(j));
						} else {
							zero_sum.add(num_pos.get(j));
							zero_sum.add(num_pos.get(k));
						}
					}
					if(zero_sum.size() != 0 && !result.contains(zero_sum))	result.add(zero_sum);
				}	
			}
		}
		
		int zero_freq = 0;
		for(int m = 0; m < num_pos.size(); m++){
			if(num_pos.get(m) == 0) zero_freq++;
		}
		if(zero_freq >= 3){
			ArrayList<Integer> all_zero = new ArrayList<Integer>();
			all_zero.add(0);
			all_zero.add(0);
			all_zero.add(0);
 			result.add(all_zero);
		}
		
        return result;
    }
	
	/*
	 * O(n^2) use HashMap
	 */
	public static ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> num_hashMap= new HashMap<Integer, Integer>();
		
		for(int k = 0; k < num.length; k++){
			if(num_hashMap.containsKey(num[k])){
				num_hashMap.put(num[k], num_hashMap.get(num[k]) + 1);
			} else {
				num_hashMap.put(num[k], 1);
			}
		}
		
		for(int i = 0; i < num.length - 1; i++) {
			for(int j = i + 1; j< num.length; j++) {
				int twoSum = num[i] + num[j];
				int diff = 0 - twoSum;
				num_hashMap.put(num[i], num_hashMap.get(num[i]) - 1);
				num_hashMap.put(num[j], num_hashMap.get(num[j]) - 1);
				
				ArrayList<Integer> zero_sum = new ArrayList<Integer>();
				
				if(num_hashMap.containsKey(diff) && num_hashMap.get(diff) > 0) {
					zero_sum.add(num[i]);
					zero_sum.add(num[j]);
					zero_sum.add(diff);
					Collections.sort(zero_sum);
					if (!result.contains(zero_sum)) result.add(zero_sum);
				}
				num_hashMap.put(num[i], num_hashMap.get(num[i]) + 1);
				num_hashMap.put(num[j], num_hashMap.get(num[j]) + 1);
			}
		}
		return result;
	}
	
	/*
	 *  O(n^2). Good solution from online source.
	 */
	public static ArrayList<ArrayList<Integer>> threeSum3(int[] num) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num.length<3) return res;
        
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if(i==0 || num[i]>num[i-1]){ //avoid duplicate solutions   
                int j=i+1, 
                    k=num.length-1;
         
                while(j<k){ 
                    if(num[j]+num[k]==-num[i]){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        res.add(temp);
                        k--;
                        j++;
                        while(k>j && num[k]==num[k+1]) k--;//avoid duplicate solutions 

                        while(j<k && num[j]==num[j-1]) j++;//avoid duplicate solutions 

                    }else if(num[j]+num[k]>-num[i]){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        return res;
	}
	
	public static void main(String[] args)	{
		int[] num_array = new int[8];
		for(int i=0; i<8; i++){
			num_array[i] = i-4;
		}
		System.out.println(threeSum(num_array));
		System.out.println();
		
		int[] num_array2 = new int[4];
		num_array2[0] = 3;
		num_array2[1] = -2;
		num_array2[2] = 1;
		num_array2[3] = 0;
		System.out.println(threeSum(num_array2));
		System.out.println();
		
		int[] num_array3 = new int[3];
		num_array3[0] = -1;
		num_array3[1] = -1;
		num_array3[2] = 2;
		System.out.println(threeSum(num_array3));
		System.out.println();
		
		int[] num_array4 = new int[4];
		num_array4[0] = -1;
		num_array4[1] = 0;
		num_array4[2] = 1;
		num_array4[3] = 0;
		System.out.println(threeSum(num_array4));
		System.out.println();
	}
}
