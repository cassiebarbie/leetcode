import java.util.ArrayList;

public class StringToInt {

	public int atoi(String str) {
		 if(str.length() == 0)	return 0;
		 
	 	ArrayList<Integer> integers = new ArrayList<Integer>();
	 	
	 	int i = 0;
	 	int intPointer = 0;
	 	boolean neg = false;
        int final_result = 0;
	 	
        while(str.charAt(i) == ' ') {
       		i++;
       	}
       	if(str.charAt(i) == '-' ){
       		neg = true;
       		i++;
       	} else if (str.charAt(i) == '+'){
       		i++;
       	}
       	
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
        	integers.add(intPointer, str.charAt(i) - '0');
        	intPointer++;
        	i++;
        }
     
        for(int j = 0; j < integers.size(); j++){
        	if(neg == false){
        		final_result += integers.get(j) * Math.pow(10, integers.size() - j - 1);
        	}
        	else final_result -= integers.get(j) * Math.pow(10, integers.size() - j - 1);
        }
        
        if(final_result >= Integer.MAX_VALUE)	return Integer.MAX_VALUE;
        if(final_result <= Integer.MIN_VALUE)	return Integer.MIN_VALUE;
        
        return final_result;
	}
}
