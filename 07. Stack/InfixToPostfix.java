// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class InfixToPostfix {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new solve().infixToPostfix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class solve{
	public static String infixToPostfix(String exp) {
		// Your code here
		Stack <Character> s = new Stack<Character>();
		String res = new String("");
		for (int i=0; i<exp.length(); i++) {
			if(s.empty() && (exp.charAt(i)=='^'||exp.charAt(i)=='/'||exp.charAt(i)=='*'||exp.charAt(i)=='+'||exp.charAt(i)=='-'))
				s.push(exp.charAt(i));
			else if(exp.charAt(i) == '^'){
				s.push('^');
			}
			else if(exp.charAt(i) == '*' || exp.charAt(i) == '/'){
				while(!s.empty() && (s.peek() == '^'||s.peek()=='*'||s.peek()=='/')) {
					res = res + s.pop();
				}
				s.push(exp.charAt(i));
			}
			else if(exp.charAt(i)=='+' || exp.charAt(i)=='-'){
				while(!s.empty() && s.peek()!='('){
					res = res + s.pop();
				}
				s.push(exp.charAt(i));
			}
			else if(exp.charAt(i)=='(')
				s.push('(');
			else if(exp.charAt(i)==')'){
				while(!s.empty() && s.peek()!='('){
					res = res + s.pop();
				}
				if(!s.empty())
					s.pop();
			}
			else{
				res = res + exp.charAt(i);
			}
			// System.out.println(s);
		}
		while(!s.empty())
			res = res + s.pop();

		return res;
	} 
}