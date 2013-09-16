import java.util.Stack;


public class ValidParentheses {
	public static boolean isValid(String s) {
		if(s.length() % 2 != 0)	return false;
		
		Stack<Character> parentheses = new Stack<Character>();
		
		parentheses.push(s.charAt(0));
		for(int i = 1; i < s.length(); i++)	{
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				parentheses.push(s.charAt(i));
			}
			
			if(s.charAt(i) == ')' )
				if(parentheses.peek() == '('){
					parentheses.pop();
				}	else parentheses.push(s.charAt(i));
				
			if(s.charAt(i) == ']' )
				if(parentheses.peek() == '['){
					parentheses.pop();
			}	else parentheses.push(s.charAt(i));	
				
			if(s.charAt(i) == '}' )
				if(parentheses.peek() == '{'){
					parentheses.pop();
			}	else parentheses.push(s.charAt(i));		
		}
		
		if(parentheses.isEmpty()) return true;
		
		return false;
    }
	
	public static void main(String[] args)	{
		String s1 = "([])";
		System.out.println(s1);
		System.out.println(isValid(s1));
		System.out.println();
		
		String s2 = "{[]([])()()()}";
		System.out.println(s2);
		System.out.println(isValid(s2));
		System.out.println();
		
		String s3 = "{[]([])()()({}())}";
		System.out.println(s3);
		System.out.println(isValid(s3));
		System.out.println();
		
		String s4 = "{[([])()()()}";
		System.out.println(s4);
		System.out.println(isValid(s4));
		System.out.println();
	}
}

