package com.datastructures;

import java.util.Stack;

/**
 * @author sridhar
 * 	
 * Input: exp = “[()]{}{[()()]()}” 
 *	Output: Balanced
 *
 *	Input: exp = “[(])” 
 *	Output: Not Balanced 
 *
 *	}][}}(}][))]
 *	[](){()}
 *	()
 *	({}([][]))[]()
 *	{)[](}]}]}))}(())(
 *	([[)
 *
 */
public class BalancedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str =  "}][}}(}][))]";

		if(isBalancedBrackets(str)) {
			System.out.println("expression is balanced");
		}
		else {
			System.out.println("expression is not balanced");	
		}
	}

	public  static boolean isBalancedBrackets(String str){
		char[] charArray = str.toCharArray();
		Stack<Character> stack = new Stack();
		char x;
		for(int i=0; i<charArray.length;i++) {
			if(charArray[i]=='{'||charArray[i]=='('||charArray[i]=='[') {
				stack.push(charArray[i]);
			}
			if(stack.isEmpty()) {
				return false;
			}
			switch(charArray[i]) {		
			case ')':
				x=stack.pop();
				if(x=='{'|| x=='[')
					return false;
				break ;
			case '}':
				x=stack.pop();
				if(x=='['|| x=='(')
					return false;
				break;
			case ']':
				x=stack.pop();
				if(x=='{'|| x=='(')
					return false;		
				break;
			}	

		}
		return (stack.isEmpty());

		// Write your code here
	/*	if(str==null ) return false;
		int n = -1;
		while (str.length() != n) {
			n = str.length();        
			str = str.replace("()", "");           
			str = str.replace("[]", "");
			str = str.replace("{}", "");
		}
		return (str.length()==0);
		*/

	}

}
